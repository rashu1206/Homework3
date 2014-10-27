package com.royal.mukhi.homework;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    SeekBar seek_bar;
    Button play_button, pause_button, exit_button;
    MediaPlayer player;
    TextView text_shown;
    Handler seekHandler = new Handler();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getInit();
        seekUpdation();
    }

    public void getInit() {
        seek_bar = (SeekBar) findViewById(R.id.seek_bar);
        play_button = (Button) findViewById(R.id.play_button);
        pause_button = (Button) findViewById(R.id.pause_button);
        text_shown = (TextView) findViewById(R.id.text_shown);
        play_button.setOnClickListener(this);
        pause_button.setOnClickListener(this);
        exit_button.setOnClickListener(this);
        player = MediaPlayer.create(this, R.raw.danzakuduro);
        seek_bar.setMax(player.getDuration());
    }

    Runnable run = new Runnable() {
        @Override
        public void run() {
            seekUpdation();
        }
    };

    public void seekUpdation() {
        seek_bar.setProgress(player.getCurrentPosition());
        seekHandler.postDelayed(run, 1000);
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.play_button:
                text_shown.setText("Playing...");
                player.start();
                break;
            case R.id.pause_button:
                player.pause();
                text_shown.setText("Paused...");
        }
    }
    public void onButtonClick(View v) {
        FragmentManager fm = getFragmentManager();
        AlertDialogFragment alert = new AlertDialogFragment();
        alert.show(fm, "Alert_Dialog");

    }
    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(), "TimePicker");
    }

    }

