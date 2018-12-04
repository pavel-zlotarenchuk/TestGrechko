
package com.tanat.testgrechko.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Left")
    @Expose
    private int left;
    @SerializedName("Top")
    @Expose
    private int top;
    @SerializedName("Width")
    @Expose
    private int width;
    @SerializedName("Height")
    @Expose
    private int height;
    @SerializedName("Corner")
    @Expose
    private int corner;
    @SerializedName("ShapeType")
    @Expose
    private int shapeType;
    @SerializedName("ShapeOrient")
    @Expose
    private int shapeOrient;
    @SerializedName("Color")
    @Expose
    private int color;
    @SerializedName("Style")
    @Expose
    private int style;
    @SerializedName("FrameColor")
    @Expose
    private int frameColor;
    @SerializedName("FontColor")
    @Expose
    private int fontColor;
    @SerializedName("Bills")
    @Expose
    private List<Bill> bills = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCorner() {
        return corner;
    }

    public void setCorner(int corner) {
        this.corner = corner;
    }

    public int getShapeType() {
        return shapeType;
    }

    public void setShapeType(int shapeType) {
        this.shapeType = shapeType;
    }

    public int getShapeOrient() {
        return shapeOrient;
    }

    public void setShapeOrient(int shapeOrient) {
        this.shapeOrient = shapeOrient;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getFrameColor() {
        return frameColor;
    }

    public void setFrameColor(int frameColor) {
        this.frameColor = frameColor;
    }

    public int getFontColor() {
        return fontColor;
    }

    public void setFontColor(int fontColor) {
        this.fontColor = fontColor;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

}
