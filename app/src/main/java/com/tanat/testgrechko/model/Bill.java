
package com.tanat.testgrechko.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bill {

    @SerializedName("ID")
    @Expose
    private int iD;
    @SerializedName("Number")
    @Expose
    private int number;
    @SerializedName("Opened")
    @Expose
    private String opened;
    @SerializedName("Total")
    @Expose
    private double total;
    @SerializedName("OpenUser")
    @Expose
    private String openUser;

    public int getID() {
        return iD;
    }

    public void setID(int iD) {
        this.iD = iD;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOpened() {
        return opened;
    }

    public void setOpened(String opened) {
        this.opened = opened;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getOpenUser() {
        return openUser;
    }

    public void setOpenUser(String openUser) {
        this.openUser = openUser;
    }

}
