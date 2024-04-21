package com.example.harkkatyo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    //Visual elements
    private EditText editMunicipalityName;
    private TextView textTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textTest = findViewById(R.id.textTest);
        editMunicipalityName = findViewById(R.id.editMunicipalityName);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //"Hae kunnan tiedot"-button switches the view to TabActivity, witch is spread into
    //three fragments.
    public void switchToTabActivity (View view) {
        Intent intent = new Intent(this, TabActivity.class);
        startActivity(intent);
    }

    public void testFind (View view) {
        Context context = this;
        MunicipalityDataRetriever mr = new MunicipalityDataRetriever();

        String location = editMunicipalityName.getText().toString();

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<MunicipalityData> populationData = mr.getPopulationData(context, location);
                if (populationData == null) {
                    return;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String s = "";
                        for(MunicipalityData data : populationData) {
                            s = s + data.getYear() + ": " + data.getPopulation() + "\n";
                        }

                        textTest.setText(s);

                    }
                });
            }
        });
    }

    public void testFindTwo (View view) {
        Context context = this;
        MunicipalityDataRetriever mr = new MunicipalityDataRetriever();

        String location = editMunicipalityName.getText().toString();

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                String selfSufficiency = mr.getSelfSufficiency(context, location);
                if (selfSufficiency == null) {
                    return;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textTest.setText(selfSufficiency);
                    }
                });
            }
        });
    }
}