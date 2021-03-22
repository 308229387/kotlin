package com.example.kotlin.dualsim

import android.content.Context
import com.example.kotlin.dualsim.TelephonyManagement.TelephonyInfo

/**
 * <pre>
 * copyright  : Copyright ©2004-2018 版权所有　XXXXXXXXXXXXXXXXX
 * company    : XXXXXXXXXXXXXXXX
 * @author     : OuyangJinfu
 * e-mail     : jinfu123.-@163.com
 * createDate : 2017/7/18 0018
 * modifyDate : 2017/7/18 0018
 * @version    : 1.0
 * desc       : 普通双卡类
</pre> *
 */
class NormalDualSim private constructor(context: Context) : DualsimBase(context) {
    override fun update(context: Context): NormalDualSim {
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

    companion object {
        private var mInstance: NormalDualSim? = null
        @JvmStatic
        fun getInstance(context: Context): NormalDualSim? {
            if (mInstance == null) {
                mInstance = NormalDualSim(context)
            }
            return mInstance
        }
    }
}