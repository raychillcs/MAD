package com.example.raychill.finalexam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class FindPizzaActivity extends Activity {

    private PizzaShop myPizzaShop = new PizzaShop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pizza);

        Button button = findViewById(R.id.button2);
        View.OnClickListener onclick = new View.OnClickListener(){
            public void onClick(View view){
                receivePizza(view);
            }
        };
        button.setOnClickListener(onclick);
    }

    public void findPizza(View view) {
        //image view
        ImageView pizza = findViewById(R.id.imageView);

        //edit text
        EditText name = findViewById(R.id.editText);
        String nameValue = name.getText().toString();

        //toggle button
        ToggleButton toggle = findViewById(R.id.toggleButton);
        boolean sauce = toggle.isChecked();

        //radio buttons
        RadioGroup crust = findViewById(R.id.radioGroup);
        int crustID = crust.getCheckedRadioButtonId();

        //check boxes
        CheckBox cheeseCheckBox = findViewById(R.id.checkBox);
        boolean cheese = cheeseCheckBox.isChecked();

        CheckBox meatCheckBox = findViewById(R.id.checkBox2);
        boolean meat = meatCheckBox.isChecked();

        CheckBox supCheckBox = findViewById(R.id.checkBox3);
        boolean supreme = supCheckBox.isChecked();

        CheckBox vegCheckBox = findViewById(R.id.checkBox4);
        boolean veggie = vegCheckBox.isChecked();

        //spinner
        Spinner size = findViewById(R.id.spinner);
        String sizeType = String.valueOf(size.getSelectedItem());

        //switch
        Switch glutenSwitch = findViewById(R.id.switch1);
        boolean glutenFree = glutenSwitch.isChecked();

        String sauceString;
        String crustString = "";
        String cheeseString = "";
        String meatString = "";
        String supString = "";
        String vegString = "";
        String sizeString;
        String glutenString = "";

        //toggle buttons
        if (sauce) {
            sauceString = "white sauce";
        } else {
            sauceString = "red sauce";
        }

        //radio buttons
        if (crustID == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please select a type of crust.";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (crustID == R.id.radioButton) {
                crustString = "thick crust";
            }
            else if (crustID == R.id.radioButton2) {
                crustString = "thin crust";
            }
        }

        //check boxes
        if (cheese) {
            cheeseString = " and cheese";
            pizza.setImageResource(R.drawable.pizza_cheese);
        }
        if (meat) {
            meatString = " and meat";
            pizza.setImageResource(R.drawable.pizza_meat);
        }
        if (supreme) {
            supString = " and supreme stuff";
            pizza.setImageResource(R.drawable.pizza_supreme);
        }
        if (veggie) {
            vegString = " and veggies";
            pizza.setImageResource(R.drawable.pizza_veggie);
        }

        //spinner
        switch (sizeType) {
            case "Small":
                sizeString = "small";
                break;
            case "Medium":
                sizeString = "medium";
                break;
            case "Large":
                sizeString = "large";
                break;
            default:
                sizeString = "any size";
        }

        //switch
        if (glutenFree){
            glutenString = "gluten-free";
        }

        //text view
        TextView pizzaCreation = findViewById(R.id.textView2);
        pizzaCreation.setText("The " + nameValue + " is a " + sizeString + " " + crustString + " " + glutenString + " pizza with " + sauceString + cheeseString + meatString + supString + vegString);
    }

    public void receivePizza(View view) {
        Spinner crowdSpinner = findViewById(R.id.spinner);
        Integer crowd = crowdSpinner.getSelectedItemPosition();
        myPizzaShop.setPizzaShop(crowd);
        String suggestedPizzaShop = myPizzaShop.getPizzaShop();
        String suggestedPizzaShopURL = myPizzaShop.getPizzaShopURL();
        Log.i("shop", suggestedPizzaShop);
        Log.i("url", suggestedPizzaShopURL);

        Intent intent = new Intent(this, ReceivePizzaActivity.class);

        intent.putExtra("pizzaShopName", suggestedPizzaShop);
        intent.putExtra("pizzaShopURL", suggestedPizzaShopURL);

        startActivity(intent);
    }
}
