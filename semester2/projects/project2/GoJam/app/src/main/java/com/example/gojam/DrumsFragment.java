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
public class DrumsFragment extends Fragment {

    ImageButton drumCym1, drumCym2, drumHat1, drumHat2, drumTom1, drumTom2, drumTom3, drumTom4, drumKick;

    public DrumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drums, container, false);

        drumCym1 = view.findViewById(R.id.imageButtonCym1);
        drumCym2 = view.findViewById(R.id.imageButtonCym2);
        drumHat1 = view.findViewById(R.id.imageButtonHat1);
        drumHat2 = view.findViewById(R.id.imageButtonHat2);
        drumTom1 = view.findViewById(R.id.imageButtonTom1);
        drumTom2 = view.findViewById(R.id.imageButtonTom2);
        drumTom3 = view.findViewById(R.id.imageButtonTom3);
        drumTom4 = view.findViewById(R.id.imageButtonTom4);
        drumKick = view.findViewById(R.id.imageButtonKick);

        final MediaPlayer soundCym1 = MediaPlayer.create(getActivity(), R.raw.cymbal1);
        final MediaPlayer soundCym2 = MediaPlayer.create(getActivity(), R.raw.cymbal2);
        final MediaPlayer soundHat1 = MediaPlayer.create(getActivity(), R.raw.closedhat1);
        final MediaPlayer soundHat2 = MediaPlayer.create(getActivity(), R.raw.closedhat2);
        final MediaPlayer soundTom1 = MediaPlayer.create(getActivity(), R.raw.tom1);
        final MediaPlayer soundTom2 = MediaPlayer.create(getActivity(), R.raw.tom2);
        final MediaPlayer soundTom3 = MediaPlayer.create(getActivity(), R.raw.tom3);
        final MediaPlayer soundTom4 = MediaPlayer.create(getActivity(), R.raw.tom4);
        final MediaPlayer soundKick = MediaPlayer.create(getActivity(), R.raw.kick);

        drumCym1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundCym1.start();
            }
        });
        drumCym2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundCym2.start();
            }
        });
        drumHat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundHat1.start();
            }
        });
        drumHat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundHat2.start();
            }
        });
        drumTom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundTom1.start();
            }
        });
        drumTom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundTom2.start();
            }
        });
        drumTom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundTom3.start();
            }
        });
        drumTom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundTom4.start();
            }
        });
        drumKick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundKick.start();
            }
        });

        return view;
    }

}
