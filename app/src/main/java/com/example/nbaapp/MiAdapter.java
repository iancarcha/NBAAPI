package com.example.nbaapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.List;

public class MiAdapter extends ArrayAdapter<NBA> {
    public MiAdapter(@NonNull Context context, int lv_nba_raw, int resource, List<NBA> objects) {
        super(context, resource, objects);

    }

    public View getView(int position, View convertView, ViewGroup parent) {

        NBA nba = getItem(position);
        Log.e("xxx", nba.toString());

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_nba_raw, parent, false);
        }


        TextView txtNBA = convertView.findViewById(R.id.txtequipo);

        ImageView ivPosterImage = convertView.findViewById(R.id.imgnba);


        txtNBA.setText(nba.getEquipo());


        Glide.with(getContext()).load(
                nba.getImagenurl()
        ).into(ivPosterImage);



        return convertView;
    }
    
}
