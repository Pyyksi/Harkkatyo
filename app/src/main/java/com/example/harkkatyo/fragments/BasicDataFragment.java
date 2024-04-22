package com.example.harkkatyo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.harkkatyo.BasicDataAdapter;
import com.example.harkkatyo.MunicipalityData;
import com.example.harkkatyo.R;

import java.util.ArrayList;

public class BasicDataFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<MunicipalityData> populationData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_basic_data, container, false);

        recyclerView = view.findViewById(R.id.rvMunicipalityData);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        populationData = (ArrayList<MunicipalityData>) getActivity().getIntent().getSerializableExtra("data");

        if (populationData !=null) {
            BasicDataAdapter basicDataAdapter = new BasicDataAdapter(getContext(), populationData);

            recyclerView.setAdapter(basicDataAdapter);
        }

        return view;
    }
}