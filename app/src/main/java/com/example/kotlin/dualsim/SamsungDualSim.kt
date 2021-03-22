package com.example.kotlin.dualsim

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.text.TextUtils
import com.example.kotlin.BuildConfig
import com.example.kotlin.dualsim.TelephonyManagement.TelephonyInfo

class SamsungDualSim private constructor(context: Context) : DualSimBase(context) {
    var androidMSTMClass: Class<*>? = null
    var androidMSMClass: Class<*>? = null
    var samsungMSMClass: Class<*>? = null
    private var   //samsung MultiSimManager实例
            mySamsungMSMObject: Any? = null

    override fun update(context: Context): DualSimBase {
        mTelephonyInfo = TelephonyInfo()
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

    override fun getSimState(simID: Int): Int {
        //SimManager
        return if (currentapiVersion < 21) {
            try {
                /*Object myObject = null;
                return (Integer) (myObject = getSimManagerDefault(simID)).getClass()
                        .getDeclaredMethod("getSimState").invoke(myObject);*/
                eval(getSimManagerDefault(simID), "getSimState", null, null) as Int
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
                super.getSimState(simID)
            }
        } else {
            super.getSimState(simID)
            /*return (Integer) (myObject = getSimManagerDefault(simID)).getClass()
                    .getDeclaredMethod("getSimState", int.class).invoke(myObject, simID);*/
        }
    }

    override fun getImei(simID: Int): String {
        return if (currentapiVersion < 21) {
            try {
                /*Object myObject = null;
                    String result = (String) (myObject = getSimManagerDefault(simID)).getClass()
                            .getDeclaredMethod("getDeviceId").invoke(myObject);*/
                val result = eval(getSimManagerDefault(simID), "getDeviceId", null, null) as String
                if (TextUtils.isEmpty(result)) {
                    super.getImei(simID)
                } else {
                    result
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
                super.getImei(simID)
            }
        } else {
            super.getImei(simID)
            /*return (String) (myObject = getSimManagerDefault(simID)).getClass()
                        .getDeclaredMethod("getDeviceId", int.class).invoke(myObject, simID);*/
        }
    }

    /**
     * 三星系统判断
     *
     * @return
     */
    val isSamsungDualSystem: Boolean
        get() = if ("samsung".equals(Build.MANUFACTURER, ignoreCase = true)) {
            if (currentapiVersion < 21) checkByStrings() else checkByfunction()
        } else false

    /**
     * 5.0-双卡支持判断
     *
     * @return
     */
    @SuppressLint("PrivateApi")
    private fun checkByStrings(): Boolean {
        try {
            if (androidMSMClass == null) androidMSMClass = Class.forName(CLASS_ANDROID_MULTISIMMANAGER)
            return eval(
                    androidMSMClass,
                    androidMSMClass!!.newInstance(),
                    "getSimSlotCount",
                    null,
                    null
                ) as Int /*androidMSMClass.getDeclaredMethod("getSimSlotCount").invoke(androidMSMClass.newInstance())*/ >= 2
        } catch (e: Exception) {
        }
        return false
    }

    /**
     * 5.0+双卡支持判断
     *
     * @return
     */
    private fun checkByfunction(): Boolean {
        try {
            if (samsungMSMClass == null) samsungMSMClass = Class.forName(CLASS_SAMSUNG_MULTISIMMANAGER)
            return (eval(
                samsungMSMClass,
                samsungMSMClass!!.newInstance(),
                "getSimSlotCount",
                null,
                null
            ) as Int /*samsungMSMClass.getDeclaredMethod("getSimSlotCount").invoke(samsungMSMClass.newInstance())*/
                    >= 2)
        } catch (e: Exception) {
        }
        return false
    }

    /**
     * 获取SimManager实例
     *
     * @param simID
     * @return
     */
    @SuppressLint("PrivateApi")
    private fun getSimManagerDefault(simID: Int): Any? {
        try {
            return if (currentapiVersion < 21) { //5.0-根据simID获取对应实例
                /* return (androidMSTMClass == null ? (androidMSTMClass = Class.forName(CLASS_ANDROID_MULTISIMTELEPHONYMANAGER))
                        : androidMSTMClass).getDeclaredMethod("getDefault", int.class).invoke(null, getLogicalSimSlot(simID));*/
                if (androidMSTMClass == null) {
                    androidMSTMClass = Class.forName(CLASS_ANDROID_MULTISIMTELEPHONYMANAGER)
                }
                eval(androidMSTMClass, null, "getDefault", arrayOf<Any>(getLogicalSimSlot(simID)), arrayOf<Class<*>?>(Int::class.javaPrimitiveType))
            } else { //5.0+直接获取实例
                if (mySamsungMSMObject == null) Class.forName(CLASS_SAMSUNG_MULTISIMMANAGER).newInstance().also { mySamsungMSMObject = it } else mySamsungMSMObject
            }
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }
        return null
    }

    /**
     * 获取simID对应的卡槽ID
     *
     * @param simID
     * @return
     */
    @SuppressLint("PrivateApi")
    private fun getLogicalSimSlot(simID: Int): Int {
        try {
            if (androidMSMClass == null) androidMSMClass = Class.forName(CLASS_ANDROID_MULTISIMMANAGER)
            return eval(androidMSMClass, androidMSMClass!!.newInstance(), "getLogicalSimSlot", arrayOf<Any>(simID), arrayOf<Class<*>?>(Int::class.javaPrimitiveType)) as Int
            //                    (Integer) androidMSMClass.getDeclaredMethod("getLogicalSimSlot", int.class).invoke(androidMSMClass.newInstance(), simID);
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                e.printStackTrace()
            }
        }
        return -1
    }

    companion object {
        private var mInstance: SamsungDualSim? = null
        private const val CLASS_ANDROID_MULTISIMMANAGER = "com.android.internal.telephony.MultiSimManager"

        //5.0+
        private const val CLASS_SAMSUNG_MULTISIMMANAGER = "com.samsung.android.telephony.MultiSimManager"

        //5.0-
        private const val CLASS_ANDROID_MULTISIMTELEPHONYMANAGER = "android.telephony.MultiSimTelephonyManager"
        @JvmStatic
        fun getInstance(context: Context): SamsungDualSim? {
            if (mInstance == null) {
                mInstance = SamsungDualSim(context)
            }
            return mInstance
        }
    }
}