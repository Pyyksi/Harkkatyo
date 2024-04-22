package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BasicDataAdapter extends RecyclerView.Adapter<BasicDataViewHolder> {

    private ArrayList<MunicipalityData> populationData;
    private Context context;

    public BasicDataAdapter(Context context, ArrayList<MunicipalityData> populationData) {
        this.context = context;
        this.populationData = populationData;
    }
    @NonNull
    @Override
    public BasicDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BasicDataViewHolder(LayoutInflater.from(context).inflate(R.layout.basicdataview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BasicDataViewHolder holder, int position) {
        MunicipalityData data = populationData.get(position);
        holder.textYear.setText(String.valueOf(data.getYear()));
        holder.textPopulation.setText(String.valueOf(data.getPopulation()));
        holder.textSelfSufficiency.setText(String.valueOf(data.getYear()));

    }

    @Override
    public int getItemCount() {
        return populationData.size();
    }
}
