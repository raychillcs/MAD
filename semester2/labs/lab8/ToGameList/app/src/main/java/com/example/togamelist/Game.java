package com.example.togamelist;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Game extends RealmObject {
    @Required
    @PrimaryKey
    private String id;
    private String game_name;
    private String platform_name;
    private boolean played;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String book) {
        this.game_name = book;
    }

    public String getPlatform_name() {
        return platform_name;
    }

    public void setPlatform_name(String author) {
        this.platform_name = author;
    }

    public boolean getPlayed() {
        return played;
    }

    public void setPlayed(boolean done) {
        this.played = done;
    }
}
