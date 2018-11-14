package com.example.raychill.hungryhelp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findFood(View view) {
        //toggle button
        ToggleButton toggle = findViewById(R.id.toggleButton);
        boolean temperature = toggle.isChecked();

        //spinner
        Spinner ethnicity = findViewById(R.id.spinner);
        String ethnicityType = String.valueOf(ethnicity.getSelectedItem());

        //radio buttons
        RadioGroup foodType = findViewById(R.id.radioGroup);
        int foodType_id = foodType.getCheckedRadioButtonId();

        //check boxes
        CheckBox saltyCheckBox = findViewById(R.id.checkBox);
        boolean salty = saltyCheckBox.isChecked();
        CheckBox sweetCheckBox = findViewById(R.id.checkBox2);
        boolean sweet = sweetCheckBox.isChecked();
        CheckBox sourCheckBox = findViewById(R.id.checkBox3);
        boolean sour = sourCheckBox.isChecked();

        String perfectFood = "";
        String addFood1 = "";
        String addFood2 = "";
        String addFood3 = "";

        if (foodType_id == -1) {
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please select a type of food.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (temperature) { //hot
                switch (ethnicityType) {
                    case "American": //American
                        if (foodType_id == R.id.radioButton) { //meal
                            perfectFood = "A hamburger";
                        } else if (foodType_id == R.id.radioButton2) { //dessert
                            perfectFood = "Apple pie";
                        } else if (foodType_id == R.id.radioButton3) { //drink
                            perfectFood = "Hot Spiced Rum";
                        }
                        break;
                    case "Mexican": //Mexican
                        if (foodType_id == R.id.radioButton) { //meal
                            perfectFood = "A carne asada burrito";
                        } else if (foodType_id == R.id.radioButton2) { //dessert
                            perfectFood = "Sopapillas";
                        } else if (foodType_id == R.id.radioButton3) { //drink
                            perfectFood = "Atole";
                        }
                        break;
                    case "Chinese": //Chinese
                        if (foodType_id == R.id.radioButton) { //meal
                            perfectFood = "Lo mein";
                        } else if (foodType_id == R.id.radioButton2) { //dessert
                            perfectFood = "Lo mai chi";
                        } else if (foodType_id == R.id.radioButton3) { //drink
                            perfectFood = "Green tea";
                        }
                        break;
                    default:
                        perfectFood = "Water";
                }
            }
            else { //cold
                switch (ethnicityType) {
                    case "American": //American
                        if (foodType_id == R.id.radioButton) { //meal
                            perfectFood = "A cobb salad";
                        } else if (foodType_id == R.id.radioButton2) { //dessert
                            perfectFood = "Key lime pie";
                        } else if (foodType_id == R.id.radioButton3) { //drink
                            perfectFood = "Root beer";
                        }
                        break;
                    case "Mexican": //Mexican
                        if (foodType_id == R.id.radioButton) { //meal
                            perfectFood = "Ceviche";
                        } else if (foodType_id == R.id.radioButton2) { //dessert
                            perfectFood = "Flan";
                        } else if (foodType_id == R.id.radioButton3) { //drink
                            perfectFood = "Horchata";
                        }
                        break;
                    case "Chinese": //Chinese
                        if (foodType_id == R.id.radioButton) { //meal
                            perfectFood = "Sichuan Liang Mian";
                        } else if (foodType_id == R.id.radioButton2) { //dessert
                            perfectFood = "Annin tofu";
                        } else if (foodType_id == R.id.radioButton3) { //drink
                            perfectFood = "Soybean milk";
                        }
                        break;
                    default:
                        perfectFood = "Water";
                }
            }

            if (salty) {
                addFood1 = " and salt";
            }
            if (sweet) {
                addFood2 = " and honey";
            }
            if (sour) {
                addFood3 = " and lemon";
            }

            //text view
            TextView sportSelection = findViewById(R.id.foodTextView);
            sportSelection.setText(perfectFood + addFood1 + addFood2 + addFood3);
        }
    }
}
