package com.example.harkkatyo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BasicDataViewHolder extends RecyclerView.ViewHolder {

    TextView textYear;
    TextView textPopulation;
    TextView textSelfSufficiency;

    public BasicDataViewHolder(@NonNull View itemView) {
        super(itemView);
        textYear = itemView.findViewById(R.id.textYear);
        textPopulation = itemView.findViewById(R.id.textPopulation);
        textSelfSufficiency = itemView.findViewById(R.id.textSelfSufficiency);
    }
}
