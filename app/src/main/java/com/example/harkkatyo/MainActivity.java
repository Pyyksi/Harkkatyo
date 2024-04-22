package com.example.harkkatyo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
    private ArrayList<MunicipalityData> populationData;
    private ArrayList<SelfSufficiencyData> selfSufficiencyData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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

        Context context = this;
        MunicipalityDataRetriever mr = new MunicipalityDataRetriever();

        String location = editMunicipalityName.getText().toString();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<MunicipalityData> populationData = mr.getPopulationData(context, location);
                ArrayList<SelfSufficiencyData> selfSufficiencyData = mr.getSelfSufficiencyData(context, location);
                ArrayList<EmploymentData> employmentData = mr.getEmploymentData(context, location);
                if ((populationData == null) || ((selfSufficiencyData == null) || (employmentData == null))){
                    return;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(context, TabActivity.class);
                        intent.putExtra("populationdata", populationData);
                        intent.putExtra("selfsufficiencydata", selfSufficiencyData);
                        intent.putExtra("employmentdata", employmentData);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
