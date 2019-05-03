package com.example.gojam;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class KeyboardFragment extends Fragment {

    ImageButton keyA4, keyAb4, keyB4, keyBb4, keyC4, keyD4, keyDb4, keyE4, keyEb4, keyF4, keyG4, keyGb4;

    public KeyboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_keyboard, container, false);

        keyA4 = view.findViewById(R.id.imageButtonA);
        keyAb4 = view.findViewById(R.id.imageButtonAb);
        keyB4 = view.findViewById(R.id.imageButtonB);
        keyBb4 = view.findViewById(R.id.imageButtonBb);
        keyC4 = view.findViewById(R.id.imageButtonC);
        keyD4 = view.findViewById(R.id.imageButtonD);
        keyDb4 = view.findViewById(R.id.imageButtonDb);
        keyE4 = view.findViewById(R.id.imageButtonE);
        keyEb4 = view.findViewById(R.id.imageButtonEb);
        keyF4 = view.findViewById(R.id.imageButtonF);
        keyG4 = view.findViewById(R.id.imageButtonG);
        keyGb4 = view.findViewById(R.id.imageButtonGb);

        final MediaPlayer soundA4 = MediaPlayer.create(getActivity(), R.raw.a4);
        final MediaPlayer soundAb4 = MediaPlayer.create(getActivity(), R.raw.ab4);
        final MediaPlayer soundB4 = MediaPlayer.create(getActivity(), R.raw.b4);
        final MediaPlayer soundBb4 = MediaPlayer.create(getActivity(), R.raw.bb4);
        final MediaPlayer soundC4 = MediaPlayer.create(getActivity(), R.raw.c4);
        final MediaPlayer soundD4 = MediaPlayer.create(getActivity(), R.raw.d4);
        final MediaPlayer soundDb4 = MediaPlayer.create(getActivity(), R.raw.db4);
        final MediaPlayer soundE4 = MediaPlayer.create(getActivity(), R.raw.e4);
        final MediaPlayer soundEb4 = MediaPlayer.create(getActivity(), R.raw.eb4);
        final MediaPlayer soundF4 = MediaPlayer.create(getActivity(), R.raw.f4);
        final MediaPlayer soundG4 = MediaPlayer.create(getActivity(), R.raw.g4);
        final MediaPlayer soundGb4 = MediaPlayer.create(getActivity(), R.raw.gb4);

        keyA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundA4.start();
            }
        });
        keyAb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundAb4.start();
            }
        });
        keyB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundB4.start();
            }
        });
        keyBb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundBb4.start();
            }
        });
        keyC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundC4.start();
            }
        });
        keyD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundD4.start();
            }
        });
        keyDb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundDb4.start();
            }
        });
        keyE4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundE4.start();
            }
        });
        keyEb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundEb4.start();
            }
        });
        keyF4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundF4.start();
            }
        });
        keyG4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundG4.start();
            }
        });
        keyGb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundGb4.start();
            }
        });

        return view;
    }

}
