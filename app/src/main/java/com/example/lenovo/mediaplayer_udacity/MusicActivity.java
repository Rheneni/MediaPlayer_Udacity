package com.example.lenovo.mediaplayer_udacity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
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

        ContentResolver musicResolver = getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if(musicCursor != null && musicCursor.moveToFirst()) {
            int titleColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int artistColumn = musicCursor.getColumnIndex(android.provider.MediaStore.Audio.Media.ARTIST);
            int durationColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            //add songs to list
            do {
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                long thisDuration = musicCursor.getInt(durationColumn);
                musics.add(new Music(thisTitle, thisArtist, convertMilisToString(thisDuration), R.mipmap.ic_launcher));
            }
            while (musicCursor.moveToNext());
        }
//        File file = new File(".");
//        if(file != null) {
//            File[] listOfFiles = file.listFiles();
//            if (listOfFiles != null) {
//                for (int i = 0; i < listOfFiles.length; i++) {
//                    if (listOfFiles[i].isFile()) {
//                        Log.v("tag", "Name " + i + ": " + listOfFiles[i].getName());
//                    }
//                }
//            }
//        }

//        musics.add(new Music("Music Name", "Rafael", "00:00:20", R.mipmap.ic_launcher));
//        musics.add(new Music("Music Name", "Rafael", "00:00:20", R.mipmap.ic_launcher));

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        MusicAdapter musicAdapter = new MusicAdapter(musics);
        recyclerView.setAdapter(musicAdapter);
        musicAdapter.notifyDataSetChanged();
        recyclerView.addItemDecoration( new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private String convertMilisToString(long timeInMilis) {
        String timeString = "";
        int hours = (int)timeInMilis/1000/60/60;
        int mins = (int)(timeInMilis - hours * 60 * 60 * 1000)/1000/60;
        int secs = (int)(timeInMilis - (hours * 60 + mins) * 60 * 1000) / 1000;
        if(hours >= 0 && hours <= 99){
            if (hours > 9){
                timeString += hours;
            }
            else {
                timeString += "0" + hours;
            }
        }
        timeString += ":";
        if (mins >= 0 && mins <= 60) {
            if (mins > 9){
                timeString += mins;
            }
            else {
                timeString += "0" + mins;
            }
        }
        timeString += ":";
        if (secs >= 0 && secs <= 60) {
            if (secs > 9){
                timeString += secs;
            }
            else {
                timeString += "0" + secs;
            }
        }

        return timeString;
    }
}
