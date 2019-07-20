package com.example.abisayuti.listviewfruits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class Grid_Activity extends AppCompatActivity {

public final static     String namabuah[] =  {"Alpukat", "Apel", "Cherry", "Durian", "Jambu Air", "Manggis", "Strawberry"}; //array dalam string

    public final static    int gambarbuah[] = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_);

        //deklarasikan
        GridView grid = findViewById(R.id.gridView);

                //adapter

        Costum_List_View_Activity.CostumAdapter adapter = new Costum_List_View_Activity.CostumAdapter(Grid_Activity.this, namabuah, gambarbuah);
        //menyatukan
        grid.setAdapter(adapter);



    }
}
