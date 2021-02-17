package com.murilofb.darkestdungeonproject.models;

public class Provision {
    String itemName;
    int itemDrawable;
    int itemIcon;

    public Provision(String itemName, int itemDrawable) {
        this.itemName = itemName;
        this.itemDrawable = itemDrawable;
    }

    public int getItemDrawable() {
        return itemDrawable;
    }

    public String getItemName() {
        return itemName;
    }
}
