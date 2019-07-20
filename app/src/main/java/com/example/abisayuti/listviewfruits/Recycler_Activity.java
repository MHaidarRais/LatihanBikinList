package com.example.abisayuti.listviewfruits;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Recycler_Activity extends AppCompatActivity {


    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


     recycler  = findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter adapter = new RecyclerAdapter();
        recycler.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                recycler.setLayoutManager(new GridLayoutManager(Recycler_Activity.this, 2));
                RecyclerAdapter adapter = new RecyclerAdapter();
                recycler.setAdapter(adapter);
            }
        });
    }

    public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
        String nama_buah[] = Grid_Activity.namabuah;
        int gambar_buah[] = Grid_Activity.gambarbuah;

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(nama_buah[position]);
            holder.imageView.setImageResource(gambar_buah[position]);

        }

        @Override
        public int getItemCount() {
            return nama_buah.length;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder (View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgBuah);
            textView = itemView.findViewById(R.id.txtNamaBuah);

        }
    }

}