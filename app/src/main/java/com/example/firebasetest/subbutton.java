package com.example.firebasetest;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class subbutton extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //parse는 db받기
        Intent tt = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01077777777"));
        startActivity(tt);
    }

}