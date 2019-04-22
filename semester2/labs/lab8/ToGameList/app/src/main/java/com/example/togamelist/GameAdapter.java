package com.example.togamelist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;

public class GameAdapter extends RealmRecyclerViewAdapter<Game, GameAdapter.ViewHolder> {

    private MainActivity activity;

    public GameAdapter(RealmResults<Game> data, MainActivity activity) {
        super(data, true);
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.list_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final GameAdapter.ViewHolder viewHolder, int i) {
        Game game = getItem(i);
        viewHolder.gameName.setText(game.getGame_name());
        viewHolder.platformName.setText(game.getPlatform_name());
        viewHolder.hasPlayed.setChecked(game.getPlayed());
        viewHolder.hasPlayed.setTag(i);

        viewHolder.hasPlayed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.isShown()){
                    int position = (Integer) viewHolder.hasPlayed.getTag();
                    Game game = getItem(position);
                    activity.changeGamePlayed(game.getId());
                }
            }
        });

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = (Integer) viewHolder.hasPlayed.getTag();
                Game game = getItem(position);
                activity.editGame(game.getId());
            }
        });
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gameName;
        TextView platformName;
        CheckBox hasPlayed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gameName = itemView.findViewById(R.id.gameTextView);
            platformName = itemView.findViewById(R.id.platformTextView);
            hasPlayed = itemView.findViewById(R.id.checkBox);
        }
    }
}