package com.rihat.retrofitapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rihat.retrofitapp.R;
import com.rihat.retrofitapp.models.CountryName;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter {

    public CountryAdapter(Context context, ArrayList<CountryName> countryNames){
        super(context,0,countryNames);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView,ViewGroup parent){
       /* if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    // put the spiner heare.
            );
        }*/

        return convertView;
    }
}
