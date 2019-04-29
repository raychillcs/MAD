package com.example.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textView);

        queue = Volley.newRequestQueue(this);

        jsonParse();
    }

    private void jsonParse() {

        String url = "https://api.myjson.com/bins/19exuk";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("contacts");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject contact = jsonArray.getJSONObject(i);

                                String firstName = contact.getString("firstname");
                                String lastName = contact.getString("lastname");
                                String phoneNumber = contact.getString("phone");
                                String emailAddress = contact.getString("email");

                                result.append(firstName + " " + lastName + ", " + String.valueOf(phoneNumber) + ", " + emailAddress + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(request);
    }
}
