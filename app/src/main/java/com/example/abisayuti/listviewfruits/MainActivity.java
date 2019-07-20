package com.example.abisayuti.listviewfruits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // data dummy -> Asset bit.ly/MengenalBuah1
    // array dua dimensi . NB : Array dua dimensi untuk membuat detail array yang berisi array juga
    //array dua dimensi batal

    String namabuah[] =  {"Alpukat", "Apel", "Cherry", "Durian", "Jambu Air", "Manggis", "Strawberry"}; //array dalam string
        String nama = "BUAH BUAHAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //kenalkan dan hubungkan
        ListView listbuah = findViewById(R.id.ListView);

        //adapter -> mentransfer data ke listview
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, namabuah);

        //satukan adapter dengan listview
        listbuah.setAdapter(adapter);

        //listener indra
        listbuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, namabuah[i], Toast.LENGTH_SHORT).show();
            }
        });
    }


}
