package com.example.lenovo.mediaplayer_udacity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lenovo.mediaplayer_udacity.Music.Music;
import com.example.lenovo.mediaplayer_udacity.Music.MusicAdapter;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        final ArrayList<Music> musics = new ArrayList<>();
        musics.add(new Music("Music Name", "Rafael", "00:00:20", R.mipmap.ic_launcher));
        musics.add(new Music("Music Name", "Rafael", "00:00:20", R.mipmap.ic_launcher));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MusicAdapter musicAdapter = new MusicAdapter(musics);
        recyclerView.setAdapter(musicAdapter);
        musicAdapter.notifyDataSetChanged();
        recyclerView.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
