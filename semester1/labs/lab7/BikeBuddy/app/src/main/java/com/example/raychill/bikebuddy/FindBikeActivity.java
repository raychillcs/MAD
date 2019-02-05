package com.example.raychill.bikebuddy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class FindBikeActivity extends Activity {

    private BikeShop myBikeShop = new BikeShop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_bike);
        Button button = findViewById(R.id.button);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                findBike(view);
            }
        };
        button.setOnClickListener(onclick);
    }

    private void findBike(View view){
        Spinner environmentSpinner = findViewById(R.id.spinner);
        Integer environment = environmentSpinner.getSelectedItemPosition();
        myBikeShop.setBikeShop(environment);
        String suggestedBikeShop = myBikeShop.getBikeShop();
        String suggestedBikeShopURL = myBikeShop.getBikeShopURL();
        Log.i("shop", suggestedBikeShop);
        Log.i("url", suggestedBikeShopURL);

        Intent intent = new Intent(this, ReceiveBikeActivity.class);

        intent.putExtra("bikeShopName", suggestedBikeShop);
        intent.putExtra("bikeShopURL", suggestedBikeShopURL);

        startActivity(intent);
    }
}
