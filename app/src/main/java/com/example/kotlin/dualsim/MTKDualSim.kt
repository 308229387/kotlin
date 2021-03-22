package com.example.kotlin.dualsim

import android.annotation.SuppressLint
import android.content.Context
import android.text.TextUtils
import android.util.Log
import com.example.kotlin.BuildConfig

open class MTKDualSim private constructor(context: Context) : DualSimBase(context) {
    //Android系统API提供的TelephonyManager
    //    private TelephonyManager mySystemAPITM;
    //MTK芯片系统TelephonyManagerEx单例
    private val myMTKTMInstance: Any?

    //4.0+ com.mediatek.telephony.smsManagerEx单例
    private var mySmsManagerExInstance: Any? = null

    //4.0- android.telephony.gemini.GeminiSmsManager静态方法类
    private var myGeminiSmsManagerClass: Class<*>? = null
    override fun update(context: Context): DualSimBase {
        mTelephonyInfo = TelephonyManagement.TelephonyInfo()
        mTelephonyInfo.setStateSIM1(getSimState(TYPE_SIM_MAIN))
        mTelephonyInfo.setStateSIM2(getSimState(TYPE_SIM_ASSISTANT))
        mTelephonyInfo.setImeiSIM1(getImei(TYPE_SIM_MAIN))
        mTelephonyInfo.setImeiSIM2(getImei(TYPE_SIM_ASSISTANT))
        val stateSim1 = mTelephonyInfo.getStateSIM1()
        val stateSim2 = mTelephonyInfo.getStateSIM2()
        if (stateSim1 != 0 && stateSim1 != 1 && stateSim1 != 7 && stateSim1 != 8) {
            mTelephonyInfo.setImeiSIM1(getImei(TYPE_SIM_MAIN))
            if (stateSim2 != 0 && stateSim2 != 1 && stateSim2 != 7 && stateSim2 != 8) {
                mTelephonyInfo.setImeiSIM2(getImei(TYPE_SIM_ASSISTANT))
            }
        } else if (stateSim2 != 0 && stateSim2 != 1 && stateSim2 != 7 && stateSim2 != 8) {
            mTelephonyInfo.setStateSIM1(mTelephonyInfo.getStateSIM2())
            mTelephonyInfo.setImeiSIM1(getImei(TYPE_SIM_ASSISTANT))
            mTelephonyInfo.setStateSIM2(1)
        }
        return this
    }

    /**
     * 获取SIM卡状态
     *
     * @param simID
     * @return
     */
    override fun getSimState(simID: Int): Int {

        //5.0及以上的系统使用API的TelephonyManager
        return if (currentapiVersion >= 21) {
            super.getSimState(simID)
        } else { //5.0以下系统使用MTK的TelephonyManagerEx类，无法获取时使用API的TelephonyManager提供的getCallStateGemini方法
            if (myMTKTMInstance != null) {
                try {
                    /*return (Integer) myMTKTMInstance.getClass().getDeclaredMethod("getSimState", int.class)
                        .invoke(myMTKTMInstance, simID);*/
                    eval(myMTKTMInstance, "getSimState", arrayOf<Any>(simID), arrayOf<Class<*>?>(Int::class.javaPrimitiveType)) as Int
                } catch (e: Exception) {
                    if (BuildConfig.DEBUG) {
                        e.printStackTrace()
                        Log.d("mydebug", "isMTKDoubleSim-error:" + e.message)
                    }
                    super.getSimState(simID)
                }
            } else {
                super.getSimState(simID)
            }
        }
    }

    override fun getImei(simID: Int): String {
        return if (currentapiVersion >= 21) {
            super.getImei(simID)
        } else if (myMTKTMInstance != null) {
            try {
                val result = eval(myMTKTMInstance, "getDeviceId", arrayOf<Any>(simID), arrayOf<Class<*>?>(Int::class.javaPrimitiveType)) as String
                if (TextUtils.isEmpty(result)) {
                    super.getImei(simID)
                } else {
                    result
                }
            } catch (e: DualSimMatchException) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
                super.getImei(simID)
            }
        } else {
            super.getImei(simID)
        }
    }

    /**
     * 初始化SmsManager Class
     */
    @SuppressLint("PrivateApi")
    private fun initSM() {
        try {
            if (myGeminiSmsManagerClass == null) {
                myGeminiSmsManagerClass = Class.forName("android.telephony.gemini.GeminiSmsManager")
            }
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }
        try {
            if (mySmsManagerExInstance == null) mySmsManagerExInstance = eval(
                Class.forName("com.mediatek.telephony.SmsManagerEx"), null, "getDefault", null, null
            )
            /*(Class.forName("com.mediatek.telephony.SmsManagerEx"))
                        .getDeclaredMethod("getDefault").invoke(null);*/
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }
    }//Normal MTK Platform
    //Gionee MTK Platform
    /**
     * MTK芯片系统判断
     *
     * @return
     */
    val isMTKSystem: Boolean
        get() {
            var isMTKSystem = false
            try {
                //Normal MTK Platform
                var normalMTKPlatform: String
                Log.d("mydebug", "check MTKSystem")
                if (!TextUtils.isEmpty(getProperty(MTK_PLATFORM_KEY).also { normalMTKPlatform = it })) {
                    if (normalMTKPlatform.startsWith("MT") || normalMTKPlatform.startsWith("mt")) {
                        isMTKSystem = true
                    }
                }
                //Gionee MTK Platform
                if (!isMTKSystem) {
                    var gioneeMTKPlatform: String
                    Log.d("mydebug", "check MTKSystem")
                    if (!TextUtils.isEmpty(getProperty(MTK_GIONEE_PLATFORM_KEY).also { gioneeMTKPlatform = it })) {
                        if (gioneeMTKPlatform.startsWith("MT") || gioneeMTKPlatform.startsWith("mt")) {
                            isMTKSystem = true
                        }
                    }
                }
                Log.d("mydebug", "check MTKSystem")
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
            return isMTKSystem
        }//                    (clazz = Class.forName("com.mediatek.telephony.TelephonyManagerEx")).getDeclaredMethod("getDefault").invoke(clazz);//        Class<?> clazz;

    /**
     * 获取MTK芯片系统TelephonyManagerEx单例
     *
     * @return
     */
    private val mTKTMDefault: Any?
        get() {
            var mtkTMInstance: Any? = null
            try {
                mtkTMInstance = eval(Class.forName("com.mediatek.telephony.TelephonyManagerEx"), null, "getDefault", null, null)
                //                    (clazz = Class.forName("com.mediatek.telephony.TelephonyManagerEx")).getDeclaredMethod("getDefault").invoke(clazz);
            } catch (e: Exception) {
                Log.d("mydebug", "isMTKDoubleSim-error:" + e.message)
            }
            return mtkTMInstance
        }

    companion object {
        private var mInstance: MTKDualSim? = null
        private const val MTK_PLATFORM_KEY = "ro.mediatek.platform"
        private const val MTK_GIONEE_PLATFORM_KEY = "ro.gn.platform.support"
        @JvmStatic
        fun getInstance(context: Context): MTKDualSim? {
            if (mInstance == null) {
                mInstance = MTKDualSim(context)
            }
            return mInstance
        }
    }

    init {
        myMTKTMInstance = mTKTMDefault
        initSM()
    }
}