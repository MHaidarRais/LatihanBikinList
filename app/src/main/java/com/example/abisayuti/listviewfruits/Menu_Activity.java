package com.example.abisayuti.listviewfruits;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu_Activity extends AppCompatActivity implements View .OnClickListener {

    Button costumListView, listView , recycleView, gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);
        //hubungin

        costumListView = findViewById(R.id.btnCostumListView);
        listView = findViewById(R.id.btnListView);
        recycleView = findViewById(R.id.btnRecycler);
        gridView = findViewById(R.id.btnGridView);

        //keadaan / action
        costumListView.setOnClickListener(this);
        listView.setOnClickListener(this);
        recycleView.setOnClickListener(this);
        gridView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.btnListView) {

            startActivity(new Intent(Menu_Activity.this, MainActivity.class));

        }else if (id == R.id.btnRecycler) {

            startActivity(new Intent(Menu_Activity.this, Recycler_Activity.class));

        }else if (id == R.id.btnGridView) {

            startActivity(new Intent(Menu_Activity.this, Grid_Activity.class));

        }else if  (id == R.id.btnCostumListView) {

            startActivity(new Intent(Menu_Activity.this, Costum_List_View_Activity.class));
        }

    }
}
