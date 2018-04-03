package com.example.lenovo.mediaplayer_udacity.Music;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.mediaplayer_udacity.R;

import java.util.ArrayList;

/**
 * Created by Lenovo on 03/04/2018.
 */

public class MusicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Music> mMusics;
    private RecyclerView mRecyclerView;

    public MusicAdapter(ArrayList<Music> musics) {
        if(musics != null) {
            mMusics = new ArrayList<>(musics);
        } else {
            mMusics = new ArrayList<>();
        }
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        public TextView mNameView;
        public TextView mArtistView;
        public TextView mTimeView;
        public ImageView mImageView;

        public MusicViewHolder(View itemView) {
            super(itemView);
            mNameView = (TextView)itemView.findViewById(R.id.music_name);
            mArtistView = (TextView)itemView.findViewById(R.id.artist_name);
            mTimeView = (TextView)itemView.findViewById(R.id.time);
            mImageView = (ImageView)itemView.findViewById(R.id.image);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MusicViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_music, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        try {
            MusicViewHolder vh = (MusicViewHolder) holder;
            Music music = mMusics.get(position);
            vh.mNameView.setText(music.getName());
            vh.mArtistView.setText(music.getArtist());
            vh.mTimeView.setText(music.getTime());
            vh.mImageView.setImageResource(music.getImageResourceId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        int count = mMusics.size();
        return count;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        mRecyclerView = recyclerView;
    }


}
