package com.example.root.mivacuna;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by root on 11/05/16.
 */
public class ArrayAdapterVacunas extends ArrayAdapter<vacunas> {

    private final Context context;


    public ArrayAdapterVacunas(Context context, ArrayList<vacunas> vacunasArrayList) {
        super(context, 0,vacunasArrayList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

     convertView = inflater.inflate(R.layout.list_vacunas, parent, false);


        Log.w("ERROR aquiIIIIIIIII",convertView.toString());
vacunas vacuna = getItem(position);

        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewTitulo);
textViewName.setText(vacuna.tituloVacuna);
        TextView textViewDescripcion = (TextView) convertView.findViewById(R.id.textViewDescripcion);
textViewDescripcion.setText(vacuna.DescripcionVacuna);







        return convertView;
    }



}
