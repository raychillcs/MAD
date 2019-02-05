package com.example.raychill.bikebuddy;

public class BikeShop {
    private String bikeShop;
    private String bikeShopURL;

    private void setBikeInfo(Integer bikeEnvironment){
        switch (bikeEnvironment){
            case 0: //City streets
                bikeShop="road bicycles";
                bikeShopURL="https://www.trekbikes.com/us/en_US/bikes/road-bikes/c/B200/";
                break;
            case 1: //Sidewalks
                bikeShop="city bicycles";
                bikeShopURL="https://www.citygrounds.com/collections/city-bikes";
                break;
            case 2: //Mountains
                bikeShop="downhill bicycles";
                bikeShopURL="https://bicyclewarehouse.com/collections/downhill-bikes";
                break;
            case 3: //Parks
                bikeShop="BMX bicycles";
                bikeShopURL="https://www.danscomp.com/bmx/Bikes/";
                break;
            case 4: //The circus
                bikeShop="a unicycle";
                bikeShopURL="http://www.sun.bike/unicycles/";
                break;
            default:
                bikeShop="none";
                bikeShopURL="https://www.google.com/search?q=boulder+bike+shops&oq=boulder+bik&aqs=chrome.0.0l6.5079j0j1&sourceid=chrome&ie=UTF-8";
        }
    }

    public void setBikeShop(Integer bikeEnvironment){

        setBikeInfo(bikeEnvironment);
    }

    public void setBikeShopURL(Integer bikeEnvironment){

        setBikeInfo(bikeEnvironment);
    }

    public String getBikeShop(){

        return bikeShop;
    }

    public String getBikeShopURL(){

        return bikeShopURL;
    }
}
