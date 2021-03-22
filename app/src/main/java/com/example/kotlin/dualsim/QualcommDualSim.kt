package com.example.kotlin.dualsim

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.util.Log
import com.example.kotlin.BuildConfig
import com.example.kotlin.dualsim.TelephonyManagement.TelephonyInfo
import java.util.*

/**
 * <pre>
 * copyright  : Copyright ©2004-2018 版权所有　XXXXXXXXXXXXXXXX
 * company    : XXXXXXXXXXXXX
 * @author     : OuyangJinfu
 * e-mail     : jinfu123.-@163.com
 * createDate : 2017/7/18 0018
 * modifyDate : 2017/7/18 0018
 * @version    : 1.0
 * desc       : 高通芯片双卡类
</pre> *
 */
open class QualcommDualSim private constructor(context: Context) : DualSimBase(context) {
    //MSimTelephonyManager单例
    private val myQualcommTMInstance: Any?
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

    override fun getImei(simID: Int): String {
        return if (currentapiVersion >= 21) {
            super.getImei(simID)
        } else {
            if (myQualcommTMInstance != null) {
                try {
                    val result = eval(myQualcommTMInstance, "getDeviceId", arrayOf<Any>(simID), arrayOf<Class<*>?>(Int::class.javaPrimitiveType)) as String
                    if (TextUtils.isEmpty(result)) {
                        super.getImei(simID)
                    } else {
                        result
                    }
                } catch (e: DualSimMatchException) {
                    super.getImei(simID)
                }
            } else {
                super.getImei(simID)
            }
        }
    }

    /**
     * 获取SIM卡状态
     *
     * @param simID
     * @return
     */
    override fun getSimState(simID: Int): Int {
        return if (currentapiVersion >= 21) {
            super.getSimState(simID)
        } else {
            if (myQualcommTMInstance != null) {
                try {
                    /*return (Integer) myQualcommTMInstance.getClass().getDeclaredMethod("getSimState", int.class)
                            .invoke(myQualcommTMInstance, simID);*/
                    eval(myQualcommTMInstance, "getSimState", arrayOf<Any>(simID), arrayOf<Class<*>?>(Int::class.javaPrimitiveType)) as Int
                } catch (e: Exception) {
                    super.getSimState(simID)
                }
            } else {
                super.getSimState(simID)
            }
        }
    }

    /**
     * 判断是否高通系统
     * 通过CPU，主板型号判断较局限
     *
     * @return
     */
    fun isQualcommSystem(): Boolean {

        //华为手机
        if (isHuaWeiDualSimQualcommSystem()) {
            Log.d("mydebug", "HUAWEI-System")
            return true
        }

        //小米
        if (isMiDualSimQualcommSystem) {
            Log.d("mydebug", "XIAOMI-System")
            return true
        }

        //vivo手机
        if (isVivoQualcommSystem) {
            Log.d("mydebug", "Vivo-System")
            return true
        }

        //vivoX5手机
        if (isVivoX5DualSimQualcommSystem) {
            Log.d("mydebug", "VivoX5-System")
            return true
        }

        //移动
        if (isCMDualSimQualcommSystem()) {
            Log.d(
                "mydebug", """
     
     主板型号：CM-System
     """.trimIndent()
            )
            return true
        }

        //努比亚
        if (isNubiaDualSimQualcommSystem()) {
            Log.d(
                "mydebug", """
     
     主板型号：NUBIA-System
     """.trimIndent()
            )
            return true
        }
        return false
    }

    /**
     * 判断移动双卡系统
     *
     * @return
     */
    private fun isCMDualSimQualcommSystem(): Boolean {
        if ("CMDC" != Build.MANUFACTURER) {
            Log.d("mydebug", "!cmdc")
            return false
        }
        if (currentapiVersion >= 21) {
            try {
                //                        mTelephonyManager.getClass().getDeclaredMethod("isMultiSimEnabled").invoke(mTelephonyManager);
                return eval(mTelephonyManager, "isMultiSimEnabled", null, null) as Boolean
            } catch (e: DualSimMatchException) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
        } else {
            try {
                val execResult = getProperty(QUALCOMM_CMDC_PLATFORM)
                if (!TextUtils.isEmpty(execResult)) {
                    if (execResult == QUALCOMM_CMDC_PLATFORM_KEY) return true
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
        }
        return false
    }

    /**
     * 判断努比亚双卡系统
     *
     * @return
     */
    private fun isNubiaDualSimQualcommSystem(): Boolean {
        if ("nubia" != Build.MANUFACTURER.toLowerCase(Locale.ENGLISH)) {
            Log.d("mydebug", "!nubia")
            return false
        }
        if (currentapiVersion >= 21) {
            try {
                //                        mTelephonyManager.getClass().getDeclaredMethod("isMultiSimEnabled").invoke(mTelephonyManager);
                return eval(mTelephonyManager, "isMultiSimEnabled", null, null) as Boolean
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
        } else {
            try {
                val execResult = getProperty(QUALCOMM_NUBIA_PLATFORM_KEY)
                Log.d("mydebug", "nubia execResult:$execResult")
                if (!TextUtils.isEmpty(execResult)) {
                    var index: Int
                    if (execResult.toLowerCase(Locale.ROOT).indexOf(QUALCOMM_NUBIA_PLATFORM_VALUE).also { index = it } >= 0) {
                        Log.d("mydebug", "nubia index:$index")
                        return true
                    }
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
        }
        return false
    }

    /**
     * 判断小米双卡系统
     *
     * @return
     */
    private val isMiDualSimQualcommSystem: Boolean
        get() {
            if ("xiaomi" != Build.MANUFACTURER.toLowerCase(Locale.ENGLISH)) {
                Log.d("mydebug", "!xiaomi")
                return false
            }
            try {
                val execResult = getProperty(QUALCOMM_XIAOMI_PLATFORM)
                if (!TextUtils.isEmpty(execResult)) {
                    if (execResult == QUALCOMM_XIAOMI_PLATFORM_KEY) return true
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
            return false
        }

    /**
     * 判断华为双卡系统（某个型号）
     *
     * @return
     */
    private fun isHuaWeiDualSimQualcommSystem(): Boolean {
        if ("huawei" != Build.MANUFACTURER.toLowerCase(Locale.ENGLISH)) {
            return false
        }
        if (currentapiVersion >= 21) {
            try {
                //                        mTelephonyManager.getClass().getDeclaredMethod("isMultiSimEnabled").invoke(myContext);
                return eval(mTelephonyManager, "isMultiSimEnabled", null, null) as Boolean
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
        } else {
            try {
                val execResult = getProperty(QUALCOMM_BOARD_PLATFORM)
                Log.d("mydebug", "huawei-execResult:$execResult")
                if (!TextUtils.isEmpty(execResult)) {
                    if (execResult == QUALCOMM_BOARD_PLATFORM_KEY) return true
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
        }
        return false
    }

    private val isVivoQualcommSystem: Boolean
        get() {
            if ("BBK" != Build.MANUFACTURER) return false
            try {
                val execResult = getProperty(QUALCOMM_VIVO_PLATFORM)
                if (!TextUtils.isEmpty(execResult)) {
                    if ("dsds" == execResult || "dsds" == execResult || "tsts" == execResult) return true
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
            return false
        }
    private val isVivoX5DualSimQualcommSystem: Boolean
        get() {
            if ("vivo" != Build.MANUFACTURER.toLowerCase(Locale.ENGLISH)) {
                return false
            }
            try {
                val execResult = getProperty(QUALCOMM_VIVO_X5_PLATFORM)
                if (!TextUtils.isEmpty(execResult)) {
                    if (QUALCOMM_VIVO_X5_PLATFORM_KEY == execResult) return true
                }
            } catch (e: Exception) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace()
                }
            }
            return false
        }/*Class.forName("android.telephony.MSimTelephonyManager")
                .getDeclaredMethod("getDefault").invoke(null);*/

    /**
     * 获取MSimTelephonyManager单例
     *
     * @return
     */
    private val default: Any?
        @SuppressLint("PrivateApi")
        get() {
            try {
                return eval(Class.forName("android.telephony.MSimTelephonyManager"), null, "getDefault", null, null)
            } catch (e: Exception) {
            }
            return null
        }

    companion object {
        private var mInstance: QualcommDualSim? = null

        //Android系统API提供的TelephonyManager
        //    private TelephonyManager mySystemAPITM;
        private const val QUALCOMM_CMDC_PLATFORM = "persist.loc.nlp_name"
        private const val QUALCOMM_CMDC_PLATFORM_KEY = "com.qualcomm.location"
        private const val QUALCOMM_XIAOMI_PLATFORM = "ro.boot.hardware"
        private const val QUALCOMM_XIAOMI_PLATFORM_KEY = "qcom"

        //采用的处理器
        private const val QUALCOMM_NUBIA_PLATFORM_KEY = "ro.product.board"
        private const val QUALCOMM_NUBIA_PLATFORM_VALUE = "msm"

        //主板平台
        private const val QUALCOMM_BOARD_PLATFORM = "ro.board.platform"

        //根据主板型号判断
        private const val QUALCOMM_BOARD_PLATFORM_KEY = "hi3630"
        private const val QUALCOMM_VIVO_PLATFORM = "persist.radio.multisim.config"
        private const val QUALCOMM_VIVO_X5_PLATFORM = "ro.vivo.product.solution"
        private const val QUALCOMM_VIVO_X5_PLATFORM_KEY = "QCOM"
        @JvmStatic
        fun getInstance(context: Context): QualcommDualSim? {
            if (mInstance == null) {
                mInstance = QualcommDualSim(context)
            }
            return mInstance
        }
    }

    init {
        myQualcommTMInstance = default
    }
}