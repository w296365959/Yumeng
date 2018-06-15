package com.sscf.investment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.umeng.message.PushAgent;
import com.umeng.message.UmengNotifyClickActivity;

import org.android.agoo.common.AgooConstants;

/**
 * (Hangzhou) <br/>
 * Author: wzm<br/>
 * Date :  2018/6/15 11:15 </br>
 * Summary:
 */

public class MipushTestActivity extends UmengNotifyClickActivity {
    private static String TAG = MipushTestActivity.class.getName();
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mipush);
        PushAgent.getInstance(this).onAppStart();
    }

    @Override
    public void onMessage(Intent intent) {
        super.onMessage(intent);  //此方法必须调用，否则无法统计打开数
        String body = intent.getStringExtra(AgooConstants.MESSAGE_BODY);
        Log.i(TAG, body);
    }
}
