package br.com.bcalvessilva.queapp.listener;

import android.media.MediaPlayer;
import android.widget.ImageView;

/**
 * Created by bcalvessilva on 10/06/17.
 */

public class PlayImageOnCompletionListener implements MediaPlayer.OnCompletionListener {
    private ImageView playImage;

    public PlayImageOnCompletionListener(ImageView playImage){
        this.playImage = playImage;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        playImage.setEnabled(true);
    }
}
