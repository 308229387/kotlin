package com.example.kotlin.dualsim;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;

import com.example.kotlin.BuildConfig;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public abstract class DualSimBase {

    static class DualSimMatchException extends Exception {

        private static final long serialVersionUID = -996812356902545308L;

        DualSimMatchException(String info) {
            super(info);
        }

    }

    /**
     * the data connection was connected by the main SIM
     */
    public static final int TYPE_SIM_MAIN = 0;

    /**
     * the data connection was connected by the Assistant SIM
     */
    public static final int TYPE_SIM_ASSISTANT = 1;

    protected int currentapiVersion;

    protected TelephonyManager mTelephonyManager;

    protected TelephonyManagement.TelephonyInfo mTelephonyInfo;

    protected Context mContext;

    protected DualSimBase(Context context) {
        currentapiVersion = Build.VERSION.SDK_INT;
        mTelephonyManager = ((TelephonyManager) context.
                getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE));
        mContext = context.getApplicationContext();
    }

    public TelephonyManagement.TelephonyInfo getTelephonyInfo() {
        return mTelephonyInfo;
    }

    public abstract DualSimBase update(Context context);


    public int getSimState(int simID) {
        try {
            return getReflexState(mTelephonyManager, "getSimState", simID);
        } catch (DualSimMatchException e) {
            try {
                return getReflexState(mTelephonyManager, "getSimStateGemini", simID);
            } catch (DualSimMatchException e1) {
                if (simID == TYPE_SIM_MAIN) {
                    return mTelephonyManager.getSimState();
                }
            }
        }
        return 0;
    }

    @SuppressLint({"NewApi", "MissingPermission", "HardwareIds"})
    public String getImei(int simID) {
        try {
            if (currentapiVersion >= 29) {//android Q 通过计算生成id
                return getRealDeviceID(mContext);
            } else if (currentapiVersion >= 21) {
                return getReflexData(mTelephonyManager, "getImei", simID);
            } else {
                return getReflexData(mTelephonyManager, "getDeviceId", simID);
            }
        } catch (DualSimMatchException e) {
            try {
                return getReflexData(mTelephonyManager, "getDeviceIdGemini", simID);
            } catch (DualSimMatchException ex) {
                if (simID == TYPE_SIM_MAIN) {
                    return mTelephonyManager.getDeviceId();
                }
            }
        }
        return "";
    }


    protected Object eval(Object evalObj, String predictedMethodName, Object[] params, Class[] paramsCls)
            throws DualSimMatchException {
        try {
            Class<?> telephonyClass = Class.forName(evalObj.getClass().getName());
            if (params != null && paramsCls != null) {
                Method getSimID = telephonyClass.getMethod(predictedMethodName, paramsCls);
                return getSimID.invoke(evalObj, params);
            } else {
                Method getSimID = telephonyClass.getMethod(predictedMethodName);
                return getSimID.invoke(evalObj);
            }
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
            throw new DualSimMatchException(predictedMethodName);
        }
    }

    protected Object eval(Class evalCls, Object evalObj, String predictedMethodName, Object[] params, Class[] paramsCls)
            throws DualSimMatchException {
        if (evalCls == null) {
            return null;
        }
        try {
            if (params != null && paramsCls != null) {
                Method getSimID = evalCls.getMethod(predictedMethodName, paramsCls);
                return getSimID.invoke(evalObj, params);
            } else {
                Method getSimID = evalCls.getMethod(predictedMethodName);
                return getSimID.invoke(evalObj);
            }
        } catch (Exception e) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace();
            }
            throw new DualSimMatchException(predictedMethodName);
        }
    }


    protected String getReflexData(TelephonyManager telephony, String predictedMethodName, int id)
            throws DualSimMatchException {
        String data = "";
        Object ob_phone = eval(telephony, predictedMethodName, new Object[]{id}, new Class[]{int.class});
        if (ob_phone != null) {
            data = ob_phone.toString();
        }
        return data;
    }


    protected int getReflexState(TelephonyManager telephony, String predictedMethodName, int slotID)
            throws DualSimMatchException {
        Object ob_phone = eval(telephony, predictedMethodName, new Object[]{slotID}, new Class[]{int.class});
        if (ob_phone != null) {
            return Integer.parseInt(ob_phone.toString());
        }
        return 0;
    }


    protected String getProperty(String propertyKey) throws IOException, InterruptedException {
        return execCommandGetLine("getprop " + propertyKey);
    }

    private String execCommandGetLine(String command) throws IOException, InterruptedException {
        String resultStr = null;

        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(command);

        int exit = proc.waitFor();
        if (exit == 0) {
            InputStream inputStream = proc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            try {
                resultStr = br.readLine();
            } finally {
                inputStream.close();
            }
        }
        return resultStr;
    }


    @NotNull
    @Override
    public String toString() {
        return mTelephonyInfo.toString();
    }

    /**
     * 获取的设备ID.
     *
     * @param context
     * @return
     */
    @SuppressLint({"MissingPermission", "HardwareIds"})
    private String getRealDeviceID(Context context) {
        if (null == context) {
            return "";
        }
        // 手机IMEI串号
        String imeiSerial = "";
        try {
            imeiSerial = (String) Build.class.getField("SERIAL").get(null);
            if (TextUtils.isEmpty(imeiSerial) || Objects.requireNonNull(imeiSerial).startsWith("000000") || "unknown".equalsIgnoreCase(imeiSerial)) {
                imeiSerial = Build.SERIAL;
            }
        } catch (Exception e) {
            Log.e("BaseInfoUtils", ">>>get imeiSerial error : ", e);
        }
        try {
            if (TextUtils.isEmpty(imeiSerial) || Objects.requireNonNull(imeiSerial).startsWith("000000") || "unknown".equalsIgnoreCase(imeiSerial)) {
                String m_szDevIDShort = "35" + //we make this look like a valid IMEI
                        Build.BOARD.length() % 10 +
                        Build.BRAND.length() % 10 +
                        Build.CPU_ABI.length() % 10 +
                        Build.DEVICE.length() % 10 +
                        Build.DISPLAY.length() % 10 +
                        Build.HOST.length() % 10 +
                        Build.ID.length() % 10 +
                        Build.MANUFACTURER.length() % 10 +
                        Build.MODEL.length() % 10 +
                        Build.PRODUCT.length() % 10 +
                        Build.TAGS.length() % 10 +
                        Build.TYPE.length() % 10 +
                        Build.USER.length() % 10; //13 digits
                String m_szBTMAC = "";
                //小米 MI 3	android 4.2.1 BluetoothManager获取异常
                BluetoothManager mbluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
                BluetoothAdapter bAdapt = mbluetoothManager.getAdapter();
                if (bAdapt != null) {
                    m_szBTMAC = bAdapt.getAddress();
                }
                String m_szAndroidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
                String m_szWLANMAC = getAdresseMAC(context);
                imeiSerial = m_szDevIDShort + m_szAndroidID + m_szWLANMAC + m_szBTMAC;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("BaseInfoUtils", ">>>getRealDeviceID error : ", e);
        }


        Log.w("BaseInfoUtils", "getRealDeviceID imeiSerial:" + imeiSerial);
        return imeiSerial;
    }

    private static final String marshmallowMacAddress = "02:00:00:00:00:00";
    private static final String fileAddressMac = "/sys/class/net/wlan0/address";

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public String getAdresseMAC(Context context) {
        WifiManager wifiMan = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInf = wifiMan.getConnectionInfo();

        if (wifiInf != null && marshmallowMacAddress.equals(wifiInf.getMacAddress())) {
            String result;
            try {
                result = getAdressMacByInterface();
                if (result != null) {
                    return result;
                } else {
                    result = getAddressMacByFile(wifiMan);
                    return result;
                }
            } catch (IOException e) {
                Log.e("MobileAccess", "Erreur lecture propriete Adresse MAC");
            } catch (Exception e) {
                Log.e("MobileAcces", "Erreur lecture propriete Adresse MAC ");
            }
        } else {
            if (wifiInf != null && wifiInf.getMacAddress() != null) {
                return wifiInf.getMacAddress();
            } else {
                return "";
            }
        }
        return marshmallowMacAddress;
    }

    private String getAdressMacByInterface() {
        try {
            List<NetworkInterface> all = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface nif : all) {
                if (nif.getName().equalsIgnoreCase("wlan0")) {
                    byte[] macBytes = nif.getHardwareAddress();
                    if (macBytes == null) {
                        return "";
                    }

                    StringBuilder res1 = new StringBuilder();
                    for (byte b : macBytes) {
                        res1.append(String.format("%02X:", b));
                    }

                    if (res1.length() > 0) {
                        res1.deleteCharAt(res1.length() - 1);
                    }
                    return res1.toString();
                }
            }

        } catch (Exception e) {
            Log.e("MobileAcces", "Erreur lecture propriete Adresse MAC ");
        }
        return null;
    }

    @SuppressLint("MissingPermission")
    private String getAddressMacByFile(WifiManager wifiMan) throws Exception {
        String ret;
        int wifiState = wifiMan.getWifiState();

        wifiMan.setWifiEnabled(true);
        File fl = new File(fileAddressMac);
        FileInputStream fin = new FileInputStream(fl);
        ret = crunchifyGetStringFromStream(fin);
        fin.close();

        boolean enabled = WifiManager.WIFI_STATE_ENABLED == wifiState;
        wifiMan.setWifiEnabled(enabled);
        return ret;
    }

    private String crunchifyGetStringFromStream(InputStream crunchifyStream) throws IOException {
        if (crunchifyStream != null) {
            Writer crunchifyWriter = new StringWriter();

            char[] crunchifyBuffer = new char[2048];
            try {
                Reader crunchifyReader = new BufferedReader(new InputStreamReader(crunchifyStream, StandardCharsets.UTF_8));
                int counter;
                while ((counter = crunchifyReader.read(crunchifyBuffer)) != -1) {
                    crunchifyWriter.write(crunchifyBuffer, 0, counter);
                }
            } finally {
                crunchifyStream.close();
            }
            return crunchifyWriter.toString();
        } else {
            return "No Contents";
        }
    }

}
