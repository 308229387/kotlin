package com.example.kotlin.dualsim;

import android.content.Context;
import android.util.Log;


public class TelephonyManagement {

    private static final String TAG = "chip";

    public static class TelephonyInfo {

        String imeiSIM1 = "";

        String imeiSIM2 = "";


        int stateSIM1 = 1;

        int stateSIM2 = 1;





        public String getImeiSIM1() {
            return imeiSIM1;
        }

        void setImeiSIM1(String imeiSIM1) {
            if (imeiSIM1 != null) {
                this.imeiSIM1 = imeiSIM1;
            }
        }

        public String getImeiSIM2() {
            return imeiSIM2;
        }

        void setImeiSIM2(String imeiSIM2) {
            if (imeiSIM2 != null) {
                this.imeiSIM2 = imeiSIM2;
            }
        }

        public int getStateSIM1() {
            return stateSIM1;
        }

        void setStateSIM1(int state) {
            stateSIM1 = state;
        }

        public int getStateSIM2() {
            return stateSIM2;
        }

        void setStateSIM2(int state) {
            stateSIM2 = state;
        }


    }

    private TelephonyManagement() {
    }

    public static TelephonyManagement getInstance() {
        if (mInstance == null) {
            mInstance = new TelephonyManagement();
        }
        return mInstance;
    }

    private static TelephonyManagement mInstance;

    private static DualsimBase mDualsimChip;

    /**
     * Get telephony SIM information
     * request permission {@link android.Manifest.permission#READ_PHONE_STATE}
     *
     * @param context 上下文
     * @return TelephonyInfo object
     */
    public TelephonyInfo getTelephonyInfo(Context context) {
        DualsimBase dualsim = getDualSimChip(context);
        if (dualsim.getTelephonyInfo() == null) {
            dualsim.update(context);
        }
        return dualsim.getTelephonyInfo();
    }

    /**
     * Reload telephonyinfo
     * * request permission {@link android.Manifest.permission#READ_PHONE_STATE}
     *
     * @param context 上下文
     * @return this
     */
    public TelephonyManagement updateTelephonyInfo(Context context) {

        getDualSimChip(context).update(context);

        return this;
    }

    /**
     * * request permission {@link android.Manifest.permission#READ_PHONE_STATE}
     *
     * @param context 上下文
     * @return DualsimBase object
     */
    public DualsimBase getDualSimChip(Context context) {

        if (mDualsimChip != null) {
            return mDualsimChip;
        }


        //samsung chip
        if (SamsungDualSim.getInstance(context).isSamsungDualSystem()) {
            if (SamsungDualSim.getInstance(context).getSimState(DualsimBase.TYPE_SIM_MAIN) == 0
                    && SamsungDualSim.getInstance(context).getSimState(DualsimBase.TYPE_SIM_ASSISTANT) == 0) {
                Log.w(TAG, ">>>>>>>>>use normal chip<<<<<<<<<<<");
                return mDualsimChip = NormalDualSim.getInstance(context);
            }
            Log.w(TAG, ">>>>>>>>>use samsung chip<<<<<<<<<<<");
            return mDualsimChip = SamsungDualSim.getInstance(context);
        }

        //MTK chip
        if (MTKDualSim.getInstance(context).isMTKSystem()) {
            Log.w(TAG, ">>>>>>>>>use MTK chip<<<<<<<<<<<");
            return mDualsimChip = MTKDualSim.getInstance(context);
        }

        //qualcomm chip
        if (QualcommDualSim.getInstance(context).isQualcommSystem(context)) {
            Log.w(TAG, ">>>>>>>>>use qualcomm chip<<<<<<<<<<<");
            return mDualsimChip = QualcommDualSim.getInstance(context);
        }

        //normal chip
        Log.w(TAG, ">>>>>>>>>use normal chip<<<<<<<<<<<");
        return mDualsimChip = NormalDualSim.getInstance(context);
    }

}
