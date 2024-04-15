package com.example.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView songTitleTextView = findViewById(R.id.song_title);
        songTitleTextView.setText("arrdee"); //  song title

        Button playPauseButton = findViewById(R.id.play_pause_button);
        Button stopButton = findViewById(R.id.stop_button);

        mediaPlayer = MediaPlayer.create(this, R.raw.arrdee);

        playPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    mediaPlayer.pause();
                    playPauseButton.setText("Play");
                    stopButton.setVisibility(View.VISIBLE);
                } else {
                    mediaPlayer.start();
                    playPauseButton.setText("Pause");
                    stopButton.setVisibility(View.GONE);
                }
                isPlaying = !isPlaying;
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.prepareAsync();
                playPauseButton.setText("Play");
                stopButton.setVisibility(View.GONE);
                isPlaying = false;
            }
        });
    }
}
