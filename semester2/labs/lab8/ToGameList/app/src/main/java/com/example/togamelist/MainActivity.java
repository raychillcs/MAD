package com.example.togamelist;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    private Realm realm;
    private GameAdapter gameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();

        RealmResults<Game> games = realm.where(Game.class).findAll();

        gameAdapter = new GameAdapter(games, this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setAdapter(gameAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = new LinearLayout(MainActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                final EditText gameEditText = new EditText(MainActivity.this);
                gameEditText.setHint("Game name");
                layout.addView(gameEditText);
                final EditText platformEditText = new EditText(MainActivity.this);
                platformEditText.setHint("Platform name");
                layout.addView(platformEditText);

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Add Game");
                dialog.setView(layout);
                dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final String newGameName = gameEditText.getText().toString();
                        final String newPlatformName = platformEditText.getText().toString();

                        if (!newGameName.isEmpty()) {
                            addGame(UUID.randomUUID().toString(), newGameName, newPlatformName);
                        }
                    }
                });
                dialog.setNegativeButton("Cancel", null);
                dialog.show();
            }
        });
    }

    public void addGame(final String newId, final String newGame, final String newPlatform){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Game newgame = realm.createObject(Game.class, newId);
                newgame.setGame_name(newGame);
                newgame.setPlatform_name(newPlatform);
            }
        });
    }

    public void changeGamePlayed(final String gameId) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Game game = realm.where(Game.class).equalTo("id", gameId).findFirst();
                game.setPlayed(!game.getPlayed());
            }
        });
    }

    private void changeGame(final String gameId, final String game_name, final String platform_name) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Game game = realm.where(Game.class).equalTo("id", gameId).findFirst();
                game.setGame_name(game_name);
                game.setPlatform_name(platform_name);
            }
        });
    }

    public void editGame(final String gameId){
        LinearLayout layout = new LinearLayout(MainActivity.this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Game game = realm.where(Game.class).equalTo("id", gameId).findFirst();

        final EditText gameEditText = new EditText(MainActivity.this);
        gameEditText.setText(game.getGame_name());
        layout.addView(gameEditText);
        final EditText platformEditText = new EditText(MainActivity.this);
        platformEditText.setText(game.getPlatform_name());
        layout.addView(platformEditText);

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Edit Game");
        dialog.setView(layout);
        dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                final String updatedGameName = gameEditText.getText().toString();
                final String updatedPlatformName = platformEditText.getText().toString();
                if(!updatedGameName.isEmpty()) {
                    changeGame(gameId, updatedGameName, updatedPlatformName);
                }
            }
        });
        dialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                deleteGame(gameId);
            }
        });
        dialog.create();
        dialog.show();
    }

    private void deleteGame(final String gameId) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(Game.class).equalTo("id", gameId)
                        .findFirst()
                        .deleteFromRealm();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

}
