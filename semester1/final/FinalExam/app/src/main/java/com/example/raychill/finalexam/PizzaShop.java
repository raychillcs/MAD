package com.example.raychill.finalexam;

public class PizzaShop {
    private String pizzaShop;
    private String pizzaShopURL;

    private void setPizzaInfo(Integer pizzaInt){
        switch (pizzaInt){
            case 0:
                pizzaShop="Domino's for small pizzas";
                pizzaShopURL="https://www.dominos.com/en/";
                break;
            case 1:
                pizzaShop="Boss Lady for medium pizzas";
                pizzaShopURL="https://bossladypizza.com/";
                break;
            case 2:
                pizzaShop="Cosmos for large pizzas";
                pizzaShopURL="http://cosmospizza.com/";
                break;
            default:
                pizzaShop="none";
                pizzaShopURL="https://www.google.com/search?ei=4X0VXI_XGefujwSx0azoBg&q=boulder+pizza+shops&oq=boulder+pizza+shops&gs_l=psy-ab.3..33i299l2.2002.6184..6416...0.0..0.294.1556.16j1j2......0....1..gws-wiz.......0j0i71j0i131j0i67j0i131i67j0i10j0i22i30j0i8i13i30.kC_VzqH0KH4";
        }
    }

    public void setPizzaShop(Integer pizzaInt){

        setPizzaInfo(pizzaInt);
    }

    public void setPizzaShopURL(Integer pizzaInt){

        setPizzaInfo(pizzaInt);
    }

    public String getPizzaShop(){

        return pizzaShop;
    }

    public String getPizzaShopURL(){

        return pizzaShopURL;
    }
}
