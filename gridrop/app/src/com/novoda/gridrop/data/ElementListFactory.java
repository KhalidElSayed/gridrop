package com.novoda.gridrop.data;

import com.novoda.gridrop.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zero
 * Date: 1/26/13
 */
public class ElementListFactory {

    public static final int ELEMENT_TYPE_INPUT  =0;
    public static final int ELEMENT_TYPE_LIST   =1;
    public static final int ELEMENT_TYPE_BAR    =2;


    public static List<Object> createElementList(final int elementType){
        switch (elementType){
            case ELEMENT_TYPE_LIST:
                return createListTypes();
            case ELEMENT_TYPE_INPUT:
                return createInputTypes();
            case ELEMENT_TYPE_BAR:
                return createBarTypes();
        }
        return null;
    }

    private static List<Object> createBarTypes() {
        ArrayList<Object> list = new ArrayList<Object>();

        list.add(new Header(R.string.input_elements_header_patterns));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));

        list.add(new Header(R.string.input_elements_header_single_items));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));

        return list;
    }

    private static List<Object> createInputTypes() {
        ArrayList<Object> list = new ArrayList<Object>();

        list.add(new Header(R.string.input_elements_header_patterns));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));

        list.add(new Header(R.string.input_elements_header_single_items));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));

        return list;    }

    private static List<Object> createListTypes() {
        ArrayList<Object> list =new ArrayList<Object>();

        list.add(new Header(R.string.input_elements_header_patterns));
        list.add(new Element(R.string.input_element_textview,R.drawable.app_launcher));
        list.add(new Element(R.string.input_element_textview,R.drawable.app_launcher));

        list.add(new Header(R.string.input_elements_header_single_items));
        list.add(new Element(R.string.input_element_textview, R.drawable.app_launcher));

        return list;
    }
}
