package com.novoda.gridrop.data;

import com.novoda.gridrop.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: zero
 * Date: 1/26/13
 */
public class ElementListFactory {

    public static final int ELEMENT_TYPE_INPUT  =0;
    public static final int ELEMENT_TYPE_LIST   =1;
    public static final int ELEMENT_TYPE_BAR    =2;


    public static Map<Integer, List<Integer>> createElementList(final int elementType){
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

    private static Map<Integer, List<Integer>>createBarTypes() {
        HashMap<Integer,List<Integer>> listWithHeaders=new HashMap<Integer, List<Integer>>();

        List<Integer> patterns=new ArrayList<Integer>();
        patterns.add(R.layout.dummy_list_element);
        patterns.add(R.layout.dummy_list_element);
        patterns.add(R.layout.dummy_list_element);
        listWithHeaders.put(R.string.input_elements_header_patterns,patterns);

        List<Integer> singleItems=new ArrayList<Integer>();
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        
        listWithHeaders.put(R.string.input_elements_header_single_items,singleItems);


        return listWithHeaders;
    }

    private static Map<Integer, List<Integer>> createInputTypes() {
        HashMap<Integer, List<Integer>> listWithHeaders = new HashMap<Integer, List<Integer>>();

        List<Integer> patterns = new ArrayList<Integer>();
        patterns.add(R.layout.dummy_list_element);
        patterns.add(R.layout.dummy_list_element);
        patterns.add(R.layout.dummy_list_element);
        listWithHeaders.put(R.string.input_elements_header_patterns, patterns);

        List<Integer> singleItems = new ArrayList<Integer>();
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);

        listWithHeaders.put(R.string.input_elements_header_single_items, singleItems);


        return listWithHeaders;
    }

    private static Map<Integer, List<Integer>> createListTypes() {
        HashMap<Integer, List<Integer>> listWithHeaders = new HashMap<Integer, List<Integer>>();

        List<Integer> patterns = new ArrayList<Integer>();
        patterns.add(R.layout.dummy_list_element);
        patterns.add(R.layout.dummy_list_element);
        patterns.add(R.layout.dummy_list_element);
        listWithHeaders.put(R.string.input_elements_header_patterns, patterns);

        List<Integer> singleItems = new ArrayList<Integer>();
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);
        singleItems.add(R.layout.dummy_list_element);

        listWithHeaders.put(R.string.input_elements_header_single_items, singleItems);


        return listWithHeaders;
    }
}
