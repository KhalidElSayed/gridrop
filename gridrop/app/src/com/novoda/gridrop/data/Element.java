package com.novoda.gridrop.data;

/**
 * Author: zero
 * Date: 1/26/13
 */
public class Element {
    public Element(int name, int image) {
        this.name = name;
        this.image = image;
    }

    public Element(int name, int image, int layoutId) {
        this.name = name;
        this.image = image;
        this.layoutId = layoutId;
    }

    public int name;
    public int image;
    public int layoutId;
}
