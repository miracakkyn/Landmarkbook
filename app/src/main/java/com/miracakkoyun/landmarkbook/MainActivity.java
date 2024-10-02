package com.miracakkoyun.landmarkbook;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.miracakkoyun.landmarkbook.databinding.ActivityDetailsBinding;
import com.miracakkoyun.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Landmark> landmarkArrayList;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        landmarkArrayList=new ArrayList<>();
        //Data
        Landmark pisa=new Landmark("Pisa","Italy",R.drawable.pisa);
        Landmark eiffel=new Landmark("Eiffel","France",R.drawable.eifel);
        Landmark kayisi=new Landmark("Kayısı","Turkey",R.drawable.apricot);
        Landmark colosseum = new Landmark("Colosseum","Italy",R.drawable.colesso);
        Landmark londeonBridge=new Landmark("London Bridge","UK",R.drawable.londonbridge);
        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eiffel);
        landmarkArrayList.add(kayisi);
        landmarkArrayList.add(colosseum);
        landmarkArrayList.add(londeonBridge);

    }
}