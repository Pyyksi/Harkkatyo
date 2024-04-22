package com.example.harkkatyo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class BasicDataViewHolder extends RecyclerView.ViewHolder {

    TextView textYear;
    TextView textPopulation;
    TextView textSelfSufficiency;
    TextView textEmploymentRate;

    public BasicDataViewHolder(@NonNull View itemView) {
        super(itemView);
        textYear = itemView.findViewById(R.id.textYear);
        textPopulation = itemView.findViewById(R.id.textPopulation);
        textSelfSufficiency = itemView.findViewById(R.id.textSelfSufficiency);
        textEmploymentRate = itemView.findViewById(R.id.textEmploymentRate);
    }
}
