package com.example.firebasetest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasetest.data.MapDTO;

import org.w3c.dom.Text;

import java.lang.annotation.Inherited;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static androidx.core.content.ContextCompat.startActivity;

public class MyFirstAdapter extends BaseAdapter {

    private final List<MapDTO> mData;
    private final Map<String,Integer> imageMap;


    public MyFirstAdapter(List<MapDTO> data)
    {
        mData=data;
        imageMap = new HashMap<>();
        imageMap.put("cafe",R.drawable.cafe);
        imageMap.put("gs",R.drawable.gs);
        imageMap.put("book",R.drawable.book);
        imageMap.put("cafeteria",R.drawable.cafeteria);
        imageMap.put("post",R.drawable.post);
        imageMap.put("coffemachine",R.drawable.coffeemachine);
        imageMap.put("copy",R.drawable.copy);
        imageMap.put("bread",R.drawable.bread);
        imageMap.put("pencil",R.drawable.pencil);

    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store,parent,false);

        ImageView mapImage= (ImageView)convertView.findViewById(R.id.store_image);
        TextView nameText= convertView.findViewById(R.id.map_name);
        TextView openText=convertView.findViewById(R.id.map_opentime);
        TextView etcText = convertView.findViewById(R.id.map_etc);
        TextView locationText = convertView.findViewById(R.id.map_location);

        MapDTO map= (MapDTO) mData.get(position);

        final String number= map.getPhonenumber();

        Log.d("a",map.getName()+map.getOpen_time());

        nameText.setText(map.getName());
        openText.setText(map.getOpen_time());
        etcText.setText(map.getEtc());
        locationText.setText(map.getLocation());



        Button intent_btn = convertView.findViewById(R.id.map_intent_btn);
        intent_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                v.getContext().startActivity(intent);
            }
        });

        mapImage.setImageResource(imageMap.get(map.getType()));

        return convertView;
    }


}
