package com.example.klbs.apnarestaurants.model;

/**
 * Created by KLBS on 4/14/2017.
 */

public class RowItem {
    private int imageId;
    private String title;
    private String desc;

    public int getAllitem() {
        return allitem;
    }

    public void setAllitem(int allitem) {
        this.allitem = allitem;
    }

    private int allitem;

    private  int countitem;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total;



    private String plus;
    private String minus;

    public RowItem(int imageId, String title, String desc,int total,int countitem,int allitem) {
        this.imageId = imageId;
        this.title = title;
        this.desc = desc;
        this.total=total;
        this.countitem=countitem;
        this.plus=plus;
        this.minus=minus;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return title + "\n" + desc;
    }
    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }
    public int getCountitem() {
        return countitem;
    }

    public void setCountitem(int countitem) {
        this.countitem = countitem;
    }
}