package com.example.benarsalah;

import android.os.Bundle;
import android.content.Intent;
import android.app.Activity;
import android.view.View;
import android.view.Menu;
import android.media.MediaPlayer;
import android.widget.ToggleButton;
import android.widget.Button;

public class MainActivity extends Activity {

	MediaPlayer audioBackground;
	ToggleButton myToggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button go = (Button)findViewById(R.id.button1);
		 
        go.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this, Play.class);
                i.putExtra("pesan", "From Activity Main");
                startActivity(i);
            }
        });
		
        Button go1 = (Button)findViewById(R.id.button2);
		 
        go1.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(MainActivity.this, Skor.class);
                i.putExtra("pesan", "From Activity Main");
                startActivity(i);
            }
        });
		 //Memberi definisi di onCreate untuk toggle
		 myToggle = (ToggleButton) findViewById(R.id.toggleSound); 
		 
		//Memanggil file my_sound pada folder raw
        audioBackground = MediaPlayer.create(this, R.raw.my_sound);
        //Set looping ke true untuk mengulang audio jika telah selesai
        audioBackground.setLooping(true);
        //Set volume audio agar berbunyi
        audioBackground.setVolume(1,1);
        //Memulai audio
        audioBackground.start();
          
	}

	 /*Mendefinisikan fungsi onToggleClicked dengan 
    pengkondisian standar if/else*/
 
    public void onToggleClicked(View view) {
        boolean on = ((ToggleButton) view).isChecked();
 
        if (on) {
            /*Mematikan suara audio*/
            audioBackground.setVolume(0, 0);
        } else {
            /*Menghidupkan kembali audio background*/
            audioBackground.setVolume(1, 1);
        }
    }
 
    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        audioBackground.stop();
        MainActivity.this.finish();
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
