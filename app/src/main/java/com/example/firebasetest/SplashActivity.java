package com.example.firebasetest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;



public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(4000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MapsActivity.class));
        finish();
    }
}