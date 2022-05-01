package com.guy.class22b_and_7;

public class Liqueur {

    private String name = "";
    private String image = "";
    private double price = 0.0;
    private int ml = 0;
    private int alc = 0;

    private int amount = 0;

    public Liqueur() { }

    public String getName() {
        return name;
    }

    public Liqueur setName(String name) {
        this.name = name;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Liqueur setImage(String image) {
        this.image = image;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Liqueur setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getMl() {
        return ml;
    }

    public Liqueur setMl(int ml) {
        this.ml = ml;
        return this;
    }

    public int getAlc() {
        return alc;
    }

    public Liqueur setAlc(int alc) {
        this.alc = alc;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public Liqueur setAmount(int amount) {
        this.amount = amount;
        return this;
    }
    public void addAmount(int amount) {
        this.amount += amount;
    }
}
