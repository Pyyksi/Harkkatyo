package com.example.harkkatyo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.crypto.AEADBadTagException;

public class BasicDataAdapter extends RecyclerView.Adapter<BasicDataViewHolder> {

    private ArrayList<MunicipalityData> populationData;
    private ArrayList<SelfSufficiencyData> selfSufficiencyData;
    private ArrayList<EmploymentData> employmentData;
    private Context context;

    public BasicDataAdapter(Context context, ArrayList<MunicipalityData> populationData, ArrayList<SelfSufficiencyData> selfSufficiencyData, ArrayList<EmploymentData> employmentData) {
        this.context = context;
        this.populationData = populationData;
        this.selfSufficiencyData = selfSufficiencyData;
        this.employmentData = employmentData;
    }
    @NonNull
    @Override
    public BasicDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BasicDataViewHolder(LayoutInflater.from(context).inflate(R.layout.basicdataview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BasicDataViewHolder holder, int position) {
        MunicipalityData data = populationData.get(position);
        SelfSufficiencyData self = selfSufficiencyData.get(position);
        EmploymentData emp = employmentData.get(position);
        holder.textYear.setText(new StringBuilder().append("Vuosi:   ").append(String.valueOf(data.getYear())).toString());
        holder.textPopulation.setText(new StringBuilder().append("Asukasluku:   ").append(String.valueOf(data.getPopulation())));
        holder.textSelfSufficiency.setText(new StringBuilder().append("Työpaikkaomavaraisuus:   ").append(String.valueOf(self.getSelfSufficiency())));
        holder.textEmploymentRate.setText(new StringBuilder().append("Työllisyysaste   ").append(String.valueOf(emp.getEmploymentRate())));
    }

    @Override
    public int getItemCount() {

        return Math.min(populationData.size(), Math.min(selfSufficiencyData.size(), employmentData.size()));
    }
}
