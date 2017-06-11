package br.com.bcalvessilva.queapp.listener;

import android.media.MediaPlayer;
import android.widget.Button;

/**
 * Created by bcalvessilva on 10/06/17.
 */

public class PlayButtonOnCompletionListener implements MediaPlayer.OnCompletionListener {
    private Button playButton;

    public PlayButtonOnCompletionListener(Button playButton){
        this.playButton = playButton;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        playButton.setEnabled(true);
    }
}
