package com.example.raychill.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ReceivePizzaActivity extends Activity {

    private String pizzaShop;
    private String pizzaShopURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_pizza);

        Intent intent = getIntent();
        pizzaShop = intent.getStringExtra("pizzaShopName");
        pizzaShopURL = intent.getStringExtra("pizzaShopURL");
        Log.i("shop received", pizzaShop);
        Log.i("url received",pizzaShopURL);

        TextView messageView = findViewById(R.id.textView);
        messageView.setText("You should check out " + pizzaShop);

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
        intent.setData(Uri.parse(pizzaShopURL));
        startActivity(intent);
    }
}
