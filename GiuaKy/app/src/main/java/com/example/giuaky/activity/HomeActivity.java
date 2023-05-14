package com.example.giuaky.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.giuaky.R;
import com.example.giuaky.adapter.TourAdapter;
import com.example.giuaky.adapter.TourNoiBatAdapter;
import com.example.giuaky.model.Tour;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        List<Tour> items = new ArrayList<>();
//        items.add(new Tour(R.drawable.bien1, "Biển Ngọc"));
//        items.add(new Tour(R.drawable.bien2, "Biển Lý Sơn"));
//        items.add(new Tour(R.drawable.bien3, "Biển Khánh Hòa"));
//        items.add(new Tour(R.drawable.bien4, "Biển Vũng Tàu"));
//        TourAdapter adapter = new TourAdapter(this, items);
//        recyclerView.setAdapter(adapter);
//
//
//        RecyclerView recyclerView2 = findViewById(R.id.my_recycler_view2);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        List<Tour> items2 = new ArrayList<>();
//        items2.add(new Tour(R.drawable.bien1, "Biển Ngọc"));
//        items2.add(new Tour(R.drawable.bien2, "Biển Lý Sơn"));
//        items2.add(new Tour(R.drawable.bien3, "Biển Khánh Hòa"));
//        items2.add(new Tour(R.drawable.bien4, "Biển Vũng Tàu"));
//        TourNoiBatAdapter adapter2 = new TourNoiBatAdapter(this, items2);
//        recyclerView2.setAdapter(adapter2);
    }
}