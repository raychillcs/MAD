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
public class GuitarFragment extends Fragment {

    ImageButton stringA, stringB, stringD, stringE1, stringE6, stringG;

    public GuitarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guitar, container, false);

        stringA = view.findViewById(R.id.imageButtonA);
        stringB = view.findViewById(R.id.imageButtonB);
        stringD = view.findViewById(R.id.imageButtonD);
        stringE1 = view.findViewById(R.id.imageButtonE1);
        stringE6 = view.findViewById(R.id.imageButtonE6);
        stringG = view.findViewById(R.id.imageButtonG);

        final MediaPlayer soundA = MediaPlayer.create(getActivity(), R.raw.stringa);
        final MediaPlayer soundB = MediaPlayer.create(getActivity(), R.raw.stringb);
        final MediaPlayer soundD = MediaPlayer.create(getActivity(), R.raw.stringd);
        final MediaPlayer soundE1 = MediaPlayer.create(getActivity(), R.raw.stringe1);
        final MediaPlayer soundE6 = MediaPlayer.create(getActivity(), R.raw.stringe6);
        final MediaPlayer soundG = MediaPlayer.create(getActivity(), R.raw.stringg);

        stringA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundA.start();
            }
        });
        stringB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundB.start();
            }
        });
        stringD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundD.start();
            }
        });
        stringE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundE1.start();
            }
        });
        stringE6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundE6.start();
            }
        });
        stringG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundG.start();
            }
        });

        return view;
    }

}
