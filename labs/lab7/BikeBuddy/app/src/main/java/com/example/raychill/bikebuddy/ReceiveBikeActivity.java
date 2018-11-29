package com.example.raychill.bikebuddy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ReceiveBikeActivity extends Activity {

    private String bikeShop;
    private String bikeShopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_bike);

        Intent intent = getIntent();
        bikeShop = intent.getStringExtra("bikeShopName");
        bikeShopURL = intent.getStringExtra("bikeShopURL");
        Log.i("shop received", bikeShop);
        Log.i("url received", bikeShopURL);

        TextView messageView = findViewById(R.id.bikeShopTextView);
        messageView.setText("You should check out " + bikeShop + ".");

        ImageButton imageButton = findViewById(R.id.imageButton);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                loadWebSite(view);
            }
        };

        imageButton.setOnClickListener(onclick);
    }

    private void loadWebSite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(bikeShopURL));
        startActivity(intent);
    }
}
