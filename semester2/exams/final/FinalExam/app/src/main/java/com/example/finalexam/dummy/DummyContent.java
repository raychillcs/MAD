package com.example.finalexam.dummy;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.finalexam.ItemListActivity;
import com.example.finalexam.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

//    public static void jsonParse() {
//
//        RequestQueue queue;
//        queue = Volley.newRequestQueue(DummyContent.this);
//
//        String url = "https://creative.colorado.edu/~apierce/samples/data/yelp_restaurants.json";
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray jsonArray = response.getJSONArray("restaurants");
//
//                            for (int i = 0; i < jsonArray.length(); i++) {
//                                JSONObject contact = jsonArray.getJSONObject(i);
//
//                                String name = contact.getString("name");
//                                String url = contact.getString("url");
//
//                                addItem();
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//        queue.add(request);
//    }

    static {
        // Add some sample items.
        addItem(new DummyItem("1", "Avery Brewing",
                "https://www.averybrewing.com/"));
        addItem(new DummyItem("2", "Rincon Argentina",
                "https://www.rinconargentinoboulder.com"));
        addItem(new DummyItem("3", "The Buff",
                "https://www.buffrestaurant.com/"));
        addItem(new DummyItem("4", "The Kitchen",
                "https://www.thekitchenbistros.com/location/boulder-colorado/"));
        addItem(new DummyItem("5", "BlackBelly Market",
                "https://www.blackbelly.com/"));
    }

//    static {
//        // Add some sample items.
//        for (int i = 1; i <= COUNT; i++) {
//            addItem(createDummyItem(i));
//        }
//    }

    public static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

//    private static DummyItem createDummyItem(int position) {
//        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
//    }

//    private static String makeDetails(int position) {
//        StringBuilder builder = new StringBuilder();
//        builder.append("Details about Item: ").append(position);
//        for (int i = 0; i < position; i++) {
//            builder.append("\nMore details information here.");
//        }
//        return builder.toString();
//    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String name;
        public final String url;

        public DummyItem(String id, String name, String url) {
            this.id = id;
            this.name = name;
            this.url = url;
        }

//        public String getId() {
//            return id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getUrl() {
//            return url;
//        }

        @Override
        public String toString() {
            return name;
        }

    }
}
