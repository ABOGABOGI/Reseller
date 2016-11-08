package com.sell.reseller.model;

/**
 * Created by Gerbage on 8/30/2016.
 */
public class Home {

    private String name;
    private int number;
    private int thumbnail;

    public Home(){

    }

    public Home (String name,int number, int thumbnail){
        this.name = name;
        this.number = number;
        this.thumbnail = thumbnail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getThumbnail() {
        return thumbnail;
    }


}
