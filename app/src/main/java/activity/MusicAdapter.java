package activity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.onsoundplay.R;

import java.util.ArrayList;
import java.util.logging.Handler;

public class MusicAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<Music> arraylist;
    private MediaPlayer media;
    private Boolean c = true;

    public MusicAdapter(Context context, int layout, ArrayList<Music> arraylist) {
        this.context = context;
        this.layout = layout;
        this.arraylist = arraylist;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHld {
        TextView songName;
        TextView artist;
        ToggleButton playOrpause;
        ImageView stop;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHld viewHld;
        if (convertView == null) {
            viewHld = new ViewHld();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(layout, null);
            viewHld.songName = (TextView) convertView.findViewById(R.id.songName);
            viewHld.artist = (TextView) convertView.findViewById(R.id.artist);
            viewHld.playOrpause = (ToggleButton) convertView.findViewById(R.id.playOrpause);
            viewHld.stop = (ImageView) convertView.findViewById(R.id.stop);


            convertView.setTag(viewHld);
        }
            else{
                viewHld = (ViewHld) convertView.getTag();
            }
            Music music = arraylist.get(position);
            viewHld.songName.setText(music.getName());
            viewHld.artist.setText(music.getArtist());

            viewHld.playOrpause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (c) {
                        media = MediaPlayer.create(context, music.getSong());
                        c = false;
                    }
                    if(media.isPlaying()) {
                        media.pause();
                    } if(viewHld.playOrpause.isChecked()) {
                        media.start();
                    }
                }
            });

        viewHld.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!c) {
                    media.stop();
                    media.release();
                    c = true;
                }
            }
        });

            return convertView;
    }
}