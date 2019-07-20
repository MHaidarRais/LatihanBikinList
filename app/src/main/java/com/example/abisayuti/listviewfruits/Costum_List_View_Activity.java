package com.example.abisayuti.listviewfruits;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URI;

public class Costum_List_View_Activity extends AppCompatActivity {


    String namabuah[] =  {"Alpukat", "Apel", "Cherry", "Durian", "Jambu Air", "Manggis", "Strawberry"}; //array dalam string

    int gambarbuah[] = {R.drawable.alpukat, R.drawable.apel, R.drawable.ceri, R.drawable.durian, R.drawable.jambuair, R.drawable.manggis, R.drawable.strawberry};

    int suarabuah[] = {R.raw.alpukat, R.raw.apel, R.raw.ceri, R.raw.durian, R.raw.jambuair, R.raw.manggis, R.raw.strawberry};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_costum__list__view_);
        ListView list = findViewById(R.id.listCostum);

        //memangggil adapter

        CostumAdapter adapter = new CostumAdapter(Costum_List_View_Activity.this, namabuah, gambarbuah);
        //sambungkan list dengan adapter
        list.setAdapter(adapter);

        // mamaberikan aksi pada list
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //kita cari alamat suaranya
                Uri alamatsuara = Uri.parse("android.resource://"+getPackageName()+"/"+suarabuah[i]);

                //media player
                MediaPlayer player = new MediaPlayer();
                player.setAudioStreamType(AudioManager.STREAM_MUSIC);

                //input data
                try {
                    player.setDataSource(getApplicationContext(), alamatsuara);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    player.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                player.start(); //menjalankan suara


            }
        });
    }

    public static class  CostumAdapter extends ArrayAdapter{

        Activity activ;
        String namabuah[];
        int gambarbuah[];

        public  CostumAdapter(Activity activity, String[] nama, int[] gambar) {

            super(activity, R.layout.listitem, nama);
            this.activ =activity;
            this.gambarbuah =gambar;
            this.namabuah =nama;

        }

        @NonNull
        @Override
        public  View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = activ.getLayoutInflater();
            View v = inflater.inflate(R.layout.listitem, null);
            //kealin
            TextView nama = v.findViewById(R.id.txtNamaBuah);
            ImageView gambar = v.findViewById(R.id.imgBuah);
            //set sesuai item
            nama.setText(namabuah[position]);
            gambar.setImageResource(gambarbuah[position]);

            return  v;
        }

    }

}
