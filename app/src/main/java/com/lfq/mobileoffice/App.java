package com.lfq.mobileoffice;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.lfq.mobileoffice.net.MediaTypeUtil;
import com.lfq.mobileoffice.net.ResponseSetting;
import com.lfq.mobileoffice.ui.login.LoginActivity;

public class App extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        MediaTypeUtil.init(context);
        ResponseSetting.accessDenied(() -> {
            Intent intent = new Intent(App.getContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            App.getContext().startActivity(intent);
        });
        ResponseSetting.showToast(message -> {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });
    }

    public static Context getContext() {
        return context;
    }
}
