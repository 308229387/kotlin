package com.example.kotlin.dualsim

import android.content.Context
import com.example.kotlin.dualsim.TelephonyManagement.TelephonyInfo

class NormalDualSim private constructor(context: Context) : DualSimBase(context) {
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