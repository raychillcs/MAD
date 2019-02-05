package com.example.raychill.lockout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void unlock(View view){
        TextView result = findViewById(R.id.textView2);
        EditText code = findViewById(R.id.editText);
        String codeValue = code.getText().toString();
        if (codeValue.equals("5555")){
            result.setText("Passcode confirmed: App unlocked.");
            ImageView lock = findViewById(R.id.imageView);
            lock.setImageResource(R.drawable.unlocked);
        }
        else{
            result.setText("Invalid passcode.");
        }
    }
}
