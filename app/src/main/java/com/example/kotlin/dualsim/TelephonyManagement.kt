package com.example.kotlin.dualsim

import android.content.Context


class TelephonyManagement private constructor() {
    
    /**
     * Reload telephonyinfo
     * * request permission [android.Manifest.permission.READ_PHONE_STATE]
     *
     * @param context 上下文
     * @return this
     */
    fun updateTelephonyInfo(context: Context?): TelephonyManagement {
        getDualSimChip(context)!!.update(context)
        return this
    }

    /**
     * * request permission [android.Manifest.permission.READ_PHONE_STATE]
     *
     * @param context 上下文
     * @return DualsimBase object
     */
    private fun getDualSimChip(context: Context?): DualSimBase? {
        if (mDualsimChip != null) {
            return mDualsimChip
        }
        //samsung chip
        if (SamsungDualSim.getInstance(context!!)!!.isSamsungDualSystem) {
            if (SamsungDualSim.getInstance(context)!!.getSimState(DualSimBase.TYPE_SIM_MAIN) == 0
                && SamsungDualSim.getInstance(context)!!.getSimState(DualSimBase.TYPE_SIM_ASSISTANT) == 0
            ) {
                return NormalDualSim.getInstance(context).also { mDualsimChip = it }
            }
            return SamsungDualSim.getInstance(context).also { mDualsimChip = it }
        }

        //MTK chip
        if (MTKDualSim.getInstance(context)!!.isMTKSystem) {
            return MTKDualSim.getInstance(context).also { mDualsimChip = it }
        }

        //qualcomm chip
        if (QualcommDualSim.getInstance(context)!!.isQualcommSystem()) {
            return QualcommDualSim.getInstance(context).also { mDualsimChip = it }
        }

        //normal chip
        return NormalDualSim.getInstance(context).also { mDualsimChip = it }
    }

    companion object {
        val instance: TelephonyManagement?
            get() {
                if (mInstance == null) {
                    mInstance = TelephonyManagement()
                }
                return mInstance
            }
        private var mInstance: TelephonyManagement? = null
        private var mDualsimChip: DualSimBase? = null
    }

    class TelephonyInfo{

        var imeiSIM1 = ""

        var imeiSIM2 = ""


        private var stateSIM1 = 1

        private var stateSIM2 = 1


        @JvmName("setImeiSIM11")
        fun setImeiSIM1(imeiSIM1: String?) {
            if (imeiSIM1 != null) {
                this.imeiSIM1 = imeiSIM1
            }
        }

        @JvmName("setImeiSIM21")
        fun setImeiSIM2(imeiSIM2: String?) {
            if (imeiSIM2 != null) {
                this.imeiSIM2 = imeiSIM2
            }
        }

        @JvmName("getStateSIM11")
        fun getStateSIM1(): Int {
            return stateSIM1
        }

        @JvmName("setStateSIM11")
        fun setStateSIM1(state: Int) {
            stateSIM1 = state
        }

        @JvmName("getStateSIM21")
        fun getStateSIM2(): Int {
            return stateSIM2
        }

        @JvmName("setStateSIM21")
        fun setStateSIM2(state: Int) {
            stateSIM2 = state
        }


    }

    /**
     * Get telephony SIM information
     * request permission [android.Manifest.permission.READ_PHONE_STATE]
     *
     * @param context 上下文
     * @return TelephonyInfo object
     */
    fun getTelephonyInfo(context: Context?): TelephonyInfo? {
        val dualsim = getDualSimChip(context)
        if (dualsim!!.telephonyInfo == null) {
            dualsim.update(context)
        }
        return dualsim.telephonyInfo
    }
}