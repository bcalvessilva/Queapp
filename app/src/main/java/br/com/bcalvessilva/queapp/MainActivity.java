package br.com.bcalvessilva.queapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import br.com.bcalvessilva.queapp.listener.PlayButtonOnClickListener;
/**
 * Created by bcalvessilva on 10/06/17.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createOnClickListener();
    }

    /** Set on click listener  */
    private void createOnClickListener() {
        int idMainButton = R.id.mainButton;
        Button mainButton = (Button)findViewById(idMainButton);
        mainButton.setOnClickListener(new PlayButtonOnClickListener(idMainButton,this,R.raw.que));

        int idValewButton = R.id.valewButton;
        Button valewButton = (Button)findViewById(idValewButton);
        valewButton.setOnClickListener(new PlayButtonOnClickListener(idValewButton,this,R.raw.valew));

        int idQueBackground = R.id.queBackground;
        ImageView queBackground = (ImageView) findViewById(idQueBackground);
        queBackground.setOnClickListener(new PlayButtonOnClickListener(idQueBackground,this,R.raw.comando){
            int counter = 0;
            public void onClick(View view){
                counter++;
                if(counter>5){
                    super.onClick(view);
                    counter=0;
                }
            }
        });
    }
}
