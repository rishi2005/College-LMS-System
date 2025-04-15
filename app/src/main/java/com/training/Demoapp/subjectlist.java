package com.training.Demoapp;

import android.os.Bundle;
import android.widget.Adapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.training.Demoapp.datamodel.Item;
import com.training.Demoapp.itemadpter;
import com.training.Demoapp.Adapter.itemadapter;
import com.training.Demoapp.datamodel.Item;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class subjectlist extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_subjectlist);

            recyclerView = findViewById(R.id.recycle_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            List<Item> itemList = new ArrayList<>();
            itemList.add(new Item("Operating System"));
            itemList.add(new Item("Computer Networks"));
            itemList.add(new Item("Probability & Statistics"));
            itemList.add(new Item("Principle of Management"));
            itemList.add(new Item("Formal Languages & Automata"));
            itemList.add(new Item("Operating System Lab"));
            itemList.add(new Item("Computer Networks Lab"));
            itemList.add(new Item("Numerical Methods Lab"));
            itemList.add(new Item("Programing using Python"));
            itemList.add(new Item("Soft Skill & Attitude"));

            itemadapter adapter = new itemadapter(itemList);
            recyclerView.setAdapter(adapter);




            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }

