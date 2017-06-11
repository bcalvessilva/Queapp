package br.com.bcalvessilva.queapp.listener;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by bcalvessilva on 10/06/17.
 */

public class PlayImageOnClickListener implements View.OnClickListener {
    private MediaPlayer mediaPlayer;
    private int idPlayImage;
    private AppCompatActivity activity;
    private int idRaw;

    public PlayImageOnClickListener(int idPlayImage, AppCompatActivity activity, int idRaw){
        this.idPlayImage = idPlayImage;
        this.activity = activity;
        this.idRaw = idRaw;
        ImageView playImage = (ImageView)activity.findViewById(idPlayImage);
        this.mediaPlayer = getMediaPlayer(playImage);
    }

    @Override
    public void onClick(View view) {
        if(idPlayImage == view.getId()){
            ImageView playImage = (ImageView)activity.findViewById(idPlayImage);
            playImage.setEnabled(false);
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = getMediaPlayer(playImage);
            } mediaPlayer.start();
        }
    }

    private MediaPlayer getMediaPlayer(ImageView playImage) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this.activity, this.idRaw);
        mediaPlayer.setOnCompletionListener(new PlayImageOnCompletionListener(playImage));
        return mediaPlayer;
    }
}
