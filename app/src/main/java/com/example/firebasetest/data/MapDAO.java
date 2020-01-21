package com.example.firebasetest.data;

import androidx.annotation.NonNull;

import com.example.firebasetest.data.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MapDAO {

    FirebaseFirestore b = FirebaseFirestore.getInstance();

    ResultSet rs;

    public MapDAO(){

    }
    MapDTO mapdto = new MapDTO();

    public void getList(String v,String v1){

        //search v와 v1으로 search 하도록
        DocumentReference ref1= b.collection(v).document(v1);

        ref1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();

                    if(document.exists()) {

                        //여기서 class로 요소들 받기
                        //mapdto.setName(document.getString("name"));
                        //mapdto.setPicture(document.getString("Picture"));
                        //mapdto.setDetails(document.getString("details"));
                    }

                }
            }
        });

    }

}
