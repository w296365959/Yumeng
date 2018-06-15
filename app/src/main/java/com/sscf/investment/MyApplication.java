package com.sscf.investment;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.mezu.MeizuRegister;
import org.android.agoo.xiaomi.MiPushRegistar;

/**
 * (Hangzhou) <br/>
 * Author: wzm<br/>
 * Date :  2018/6/15 15:52 </br>
 * Summary:
 */

public class MyApplication extends Application implements IUmengRegisterCallback {
    public static final String TAG=MyApplication.class.getSimpleName();
    private PushAgent mPushAgent;
    public MyApplication mMyApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mMyApplication=this;
        UMConfigure.init( this,  UMConfigure.DEVICE_TYPE_PHONE, "65a562a2fffece2a64481b89355e57f6");

        mPushAgent = PushAgent.getInstance(this);
        try {
            mPushAgent.register(this);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        UMConfigure.setLogEnabled(true);
        MiPushRegistar.register(mMyApplication,"2882303761517711042","5651771182042");
        HuaWeiRegister.register(mMyApplication);
        MeizuRegister.register( mMyApplication, "304594", "ZviQoxFJkvkaYYS1RAMF");
        init();
    }

    private void init() {
        UmengMessageHandler messageHandler = new UmengMessageHandler() {
            /**
             * 通知的回调方法
             * @param context
             * @param msg
             */
            @Override
            public void dealWithNotificationMessage(Context context, UMessage msg) {
                //调用super则会走通知展示流程，不调用super则不展示通知
                super.dealWithNotificationMessage(context, msg);
            }
        };
        mPushAgent.setMessageHandler(messageHandler);
    }

    @Override
    public void onSuccess(String s) {

        Log.i(TAG, "onSuccess: ");
    }

    @Override
    public void onFailure(String s, String s1) {
        Log.i(TAG, "onFailure: ");
    }
}
