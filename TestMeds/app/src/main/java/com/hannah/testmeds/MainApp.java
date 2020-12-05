package com.hannah.testmeds;


import android.app.Application;
import android.widget.Toast;

public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        isOnline();

    }
    public Boolean isOnline() {
        try {
            Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 www.google.com");
            int returnVal = p1.waitFor();
            boolean reachable = (returnVal == 0);
            return reachable;
        } catch (Exception e) {

            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Check Internet connection!", Toast.LENGTH_SHORT).show();
        return false;
    }

}