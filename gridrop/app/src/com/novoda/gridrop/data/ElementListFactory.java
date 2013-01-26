package com.novoda.gridrop.data;

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
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private static Map<Integer, List<Integer>> createInputTypes() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private static Map<Integer, List<Integer>> createListTypes() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
