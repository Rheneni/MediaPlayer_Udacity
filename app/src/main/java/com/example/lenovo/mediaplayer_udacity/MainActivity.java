package com.example.lenovo.mediaplayer_udacity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener mOnMusicClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onMusicClickListener();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Activities
        * 1. Main Menu
        * 2. List of Media Music/Videos
        * 3. Music details
        * 4. Music Player
        * 5. Video Player
        * 6. Source to Search Media
        *
        * */

        TextView musicList = (TextView)findViewById(R.id.musics_list);
        musicList.setOnClickListener(mOnMusicClickListener);
    }

    private void onMusicClickListener() {
        Intent musicListIntent = new Intent(MainActivity.this, MusicActivity.class);
        startActivity(musicListIntent);
    }
}
