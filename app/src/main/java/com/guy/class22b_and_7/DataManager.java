package com.guy.class22b_and_7;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList<Liqueur> generateliqueurs() {
        ArrayList<Liqueur> liqueurs = new ArrayList<>();
                
        liqueurs.add(new Liqueur()
                .setImage("img_crown_royal")
                .setPrice(50.0)
                .setAlc(40)
                .setMl(700)
        );
        liqueurs.add(new Liqueur()
                .setImage("img_gordons")
                .setPrice(50.0)
                .setAlc(40)
                .setMl(700)
        );
        liqueurs.add(new Liqueur()
                .setImage("img_hennessy")
                .setPrice(50.0)
                .setAlc(40)
                .setMl(700)
        );
        liqueurs.add(new Liqueur()
                .setImage("img_jagermeister")
                .setPrice(50.0)
                .setAlc(40)
                .setMl(700)
        );
        liqueurs.add(new Liqueur()
                .setImage("img_wild_turkey")
                .setPrice(50.0)
                .setAlc(40)
                .setMl(700)
        );

        for (Liqueur liqueur : liqueurs) {
            String n = liqueur.getImage();
            n = n.substring(4, n.length());
            n = n.replaceAll("_", " ");
            n = n.substring(0, 1).toUpperCase() + n.substring(1);
            liqueur.setName(n);
        }

        return liqueurs;
    }

    public static ArrayList<Item> generateItems() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Brazil"));
        items.add(new Item("China"));
        items.add(new Item("Egypt"));
        items.add(new Item("France"));
        items.add(new Item("Germany"));
        items.add(new Item("India"));
        items.add(new Item("Indonesia"));
        items.add(new Item("Iran"));
        items.add(new Item("Italy"));
        items.add(new Item("Japan"));
        items.add(new Item("Korea"));
        items.add(new Item("Mexico"));
        items.add(new Item("Pakistan"));
        items.add(new Item("Russia"));
        items.add(new Item("Saudi Arabia"));
        items.add(new Item("Spain"));
        items.add(new Item("Taiwan"));
        items.add(new Item("Thailand"));
        items.add(new Item("Turkey"));

        return items;
    }
}
