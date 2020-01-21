package com.example.firebasetest;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firebasetest.R;
import com.example.firebasetest.data.MapDTO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firebasetest.R;

import java.util.ArrayList;


public class DetailActivity  extends  AppCompatActivity{

    private static String TAG="LOGCHECK";

    FirebaseFirestore db= FirebaseFirestore.getInstance();

    String str1,str2,str3,str4,str5,str6,str7;
    Button intent_btn;

    MapDTO MapDTO = new MapDTO();


    MapDTO[] array = new MapDTO[6];

    ArrayList<MapDTO> data= new ArrayList<>();



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //activity_main에서 detailactivity 로 바꾸기
        setContentView(R.layout.activity_main);

        intent_btn = findViewById(R.id.intent_btn);


        final String[] number = new String[1];

        String title = "";
        String address = "";


        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            title = "error";
        }
        else {

            title = extras.getString("title");
            address = extras.getString("address");
        }

        final String[] str = {title + '\n' + address + '\n'};

        String search = "GS25";


        db.collection(search).whereEqualTo("title",title)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                int i=0;

                                Log.d(TAG, document.getId() + " => " + document.getData());

                                str1 = document.getData().get("title").toString();
                                str2 = document.getData().get("name").toString();
                                str3 = document.getData().get("open_time").toString();
                                str4 = document.getData().get("etc").toString();
                                str5 = document.getData().get("location").toString();
                                str6 = document.getData().get("phonenumber").toString();
                                str7 = document.getData().get("type").toString();

                                data.add(new MapDTO(str2,str3,str4,str5,str6,str7));

                                array[i]=new MapDTO(str2,str3,str4,str5,str6,str7);


                                Log.d(TAG,"array is "+array[i].getName());

                                Log.d(TAG, "str is "+ str2);

                                number[0]=str6;

                                i++;
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());

                        }

                        MyFirstAdapter adapter=new MyFirstAdapter(data);

                        ListView listView= (ListView)findViewById(R.id.listview);
                        listView.setAdapter(adapter);


                    }
        });




    }

}
