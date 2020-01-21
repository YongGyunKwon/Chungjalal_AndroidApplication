package com.example.firebasetest;

import com.example.firebasetest.data.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity  {

    private static String TAG="LOGCHECK";


    //realtime에 대한 접근
    //DatabaseReference mdata;

    //firesotre 참조
    FirebaseFirestore db= FirebaseFirestore.getInstance();


    TextView textview;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MapDTO> data= new ArrayList<>();
        for(int i=0;i<6;i++)
            data.add(new MapDTO());

         //이거 type....
        MyFirstAdapter adapter= new MyFirstAdapter(data);

        ListView listView= (ListView)findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }
}
