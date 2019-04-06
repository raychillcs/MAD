package com.example.catdex;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    private String name;
    private int imageResourceID;

    private Cat(String newname, int newID){
        this.name = newname;
        this.imageResourceID = newID;
    }

    public static List<Cat> cats = new ArrayList<Cat>(){{
        add(new Cat("American Shorthair", R.drawable.american_shorthair));
        add(new Cat("British Shorthair", R.drawable.british_shorthair));
        add(new Cat("Cymric", R.drawable.cymric));
        add(new Cat("Maine Coon", R.drawable.maine_coon));
        add(new Cat("Persian", R.drawable.persian));
        add(new Cat("Ragamuffin", R.drawable.ragamuffin));
        add(new Cat("Savannah", R.drawable.savannah));
        add(new Cat("Siamese", R.drawable.siamese));
    }};

    public String getName(){
        return name;
    }

    public int getImageResourceID(){
        return imageResourceID;
    }

    public String toString(){
        return this.name;
    }
}
