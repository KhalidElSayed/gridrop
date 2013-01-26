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
        list.add(new Element(R.string.input_group_address, R.drawable.inputs_group_address));
        list.add(new Element(R.string.input_group_choice, R.drawable.inputs_group_choice));
        list.add(new Element(R.string.input_group_message, R.drawable.inputs_group_message));

        list.add(new Header(R.string.input_elements_header_single_items));
        list.add(new Element(R.string.inputs_single_checkbox, R.drawable.inputs_single_checkbox,R.layout.item_input_checkbox));
        list.add(new Element(R.string.inputs_single_headline, R.drawable.inputs_single_headline));
        list.add(new Element(R.string.inputs_single_input, R.drawable.inputs_single_input,R.layout.item_input_edittext));
        list.add(new Element(R.string.inputs_single_spinner, R.drawable.inputs_single_spinner,R.layout.item_input_spinner));
        list.add(new Element(R.string.inputs_single_text, R.drawable.inputs_single_text));

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
