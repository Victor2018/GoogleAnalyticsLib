package com.victor.analytics.library;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/*
 * -----------------------------------------------------------------
 * Copyright (C) 2018-2028, by Victor, All rights reserved.
 * -----------------------------------------------------------------
 * File: AnalyticsHelper.java
 * Author: Victor
 * Date: 2018/9/4 18:08
 * Description:
 * -----------------------------------------------------------------
 */
public class AnalyticsHelper {
    private String TAG = "AnalyticsHelper";
    private Context mContext;
    private static GoogleAnalytics googleAnalytics;
    private Tracker mTracker;

    private static AnalyticsHelper mAnalyticsHelper;

    private AnalyticsHelper() {

    }

    public void init (Context context) {
        mContext = context;
        googleAnalytics = GoogleAnalytics.getInstance(mContext);
        mTracker = googleAnalytics.newTracker(getTrackerId());
    }
    public void init (Context context,int resXmlId) {
        mContext = context;
        googleAnalytics = GoogleAnalytics.getInstance(mContext);
        mTracker = googleAnalytics.newTracker(resXmlId);
    }

    public static AnalyticsHelper getInstance () {
        if (mAnalyticsHelper == null) {
            synchronized (AnalyticsHelper.class) {
                if (mAnalyticsHelper == null) {
                    mAnalyticsHelper = new AnalyticsHelper ();
                }
            }
        }
        return mAnalyticsHelper;
    }

    public synchronized void sendCustomAction (String category,String actionName,String lable,long value) {
        if (mTracker == null) {
            throw new RuntimeException("plealse init mTracker first");
        }
        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(actionName)
                .setLabel(lable)
                .setValue(value)
                .build());
    }

    public synchronized void sendScreenName (String screenName) {
        if (mTracker == null) {
            throw new RuntimeException("plealse init mTracker first");
        }
        mTracker.setScreenName(screenName);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    private String getTrackerId () {
        String trackerId = null;
        if (mContext == null) return trackerId;
        ApplicationInfo appInfo = null;
        try {
            appInfo = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
            trackerId = appInfo.metaData.getString(Constant.GA_TRACKING_ID);
            Log.e(TAG,"********************** getTrackerId **********************");
            Log.e(TAG,"trackerId = " + trackerId);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return trackerId;
    }
}
