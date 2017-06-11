package br.com.bcalvessilva.queapp.listener;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by bcalvessilva on 10/06/17.
 */

public class PlayButtonOnClickListener implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private int idPlayButton;
    private AppCompatActivity activity;
    private int idRaw;

    public PlayButtonOnClickListener(int idPlayButton, AppCompatActivity activity, int idRaw){
        this.idPlayButton = idPlayButton;
        this.activity = activity;
        this.idRaw = idRaw;
        Button playButton = (Button)activity.findViewById(idPlayButton);
        this.mediaPlayer = getMediaPlayer(playButton);
    }

    @Override
    public void onClick(View view) {
        if(idPlayButton == view.getId()){
            Button playButton = (Button)activity.findViewById(idPlayButton);
            playButton.setEnabled(false);
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = getMediaPlayer(playButton);
            } mediaPlayer.start();
        }
    }

    private MediaPlayer getMediaPlayer(Button playButton) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this.activity, this.idRaw);
        mediaPlayer.setOnCompletionListener(new PlayButtonOnCompletionListener(playButton));
        return mediaPlayer;
    }
}
