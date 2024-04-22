package com.example.harkkatyo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harkkatyo.BasicDataAdapter;
import com.example.harkkatyo.EmploymentData;
import com.example.harkkatyo.MunicipalityData;
import com.example.harkkatyo.R;
import com.example.harkkatyo.SelfSufficiencyData;

import java.util.ArrayList;

public class BasicDataFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<MunicipalityData> populationData;
    private ArrayList<SelfSufficiencyData> selfSufficiencyData;
    private ArrayList<EmploymentData> employmentData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_basic_data, container, false);

        recyclerView = view.findViewById(R.id.rvMunicipalityData);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        populationData = (ArrayList<MunicipalityData>) getActivity().getIntent().getSerializableExtra("populationdata");
        selfSufficiencyData = (ArrayList<SelfSufficiencyData>) getActivity().getIntent().getSerializableExtra("selfsufficiencydata");
        employmentData = (ArrayList<EmploymentData>) getActivity().getIntent().getSerializableExtra("employmentdata");

        if (populationData != null && selfSufficiencyData != null && employmentData != null) {
            BasicDataAdapter basicDataAdapter = new BasicDataAdapter(getContext(), populationData, selfSufficiencyData, employmentData);

            recyclerView.setAdapter(basicDataAdapter);
        }

        return view;
    }
}