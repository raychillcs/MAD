package com.example.prototype;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4, sound5, sound6;
//    private Button play, stop, record;
//    private MediaRecorder myAudioRecorder;
//    private String outputFile;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_piano:
                    toolbar.setTitle("Piano");
                    fragment = new PianoFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_drums:
                    toolbar.setTitle("Drums");
                    fragment = new DrumsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_guitar:
                    toolbar.setTitle("Guitar");
                    fragment = new GuitarFragment();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Piano");
        loadFragment(new PianoFragment());

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        sound1 = soundPool.load(this, R.raw.sound1, 1);
        sound2 = soundPool.load(this, R.raw.sound2, 1);
        sound3 = soundPool.load(this, R.raw.sound3, 1);
        sound4 = soundPool.load(this, R.raw.sound4, 1);
        sound5 = soundPool.load(this, R.raw.sound5, 1);
        sound6 = soundPool.load(this, R.raw.sound6, 1);

//        play = (Button) findViewById(R.id.play);
//        stop = (Button) findViewById(R.id.stop);
//        record = (Button) findViewById(R.id.record);
//        stop.setEnabled(false);
//        play.setEnabled(false);
//        outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";
//        myAudioRecorder = new MediaRecorder();
//        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
//        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
//        myAudioRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
//        myAudioRecorder.setOutputFile(outputFile);
//
//        record.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    myAudioRecorder.prepare();
//                    myAudioRecorder.start();
//                } catch (IllegalStateException ise) {
//                    // make something ...
//                } catch (IOException ioe) {
//                    // make something
//                }
//                record.setEnabled(false);
//                stop.setEnabled(true);
//                Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        stop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myAudioRecorder.stop();
//                myAudioRecorder.release();
//                myAudioRecorder = null;
//                record.setEnabled(true);
//                stop.setEnabled(false);
//                play.setEnabled(true);
//                Toast.makeText(getApplicationContext(), "Audio Recorder successfully", Toast.LENGTH_LONG).show();
//            }
//        });
//
//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MediaPlayer mediaPlayer = new MediaPlayer();
//                try {
//                    mediaPlayer.setDataSource(outputFile);
//                    mediaPlayer.prepare();
//                    mediaPlayer.start();
//                    Toast.makeText(getApplicationContext(), "Playing Audio", Toast.LENGTH_LONG).show();
//                } catch (Exception e) {
//                    // make something
//                }
//            }
//        });
    }

    private void loadFragment(Fragment fragment){
        if (fragment != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();
        }
    }

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.button_sound1:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                soundPool.autoPause();
                break;
            case R.id.button_sound2:
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound3:
                soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound4:
                soundPool.play(sound4, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound5:
                soundPool.play(sound5, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound6:
                soundPool.play(sound6, 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }

}
