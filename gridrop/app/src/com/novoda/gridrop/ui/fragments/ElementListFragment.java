package com.novoda.gridrop.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.novoda.gridrop.R;
import com.novoda.gridrop.data.ElementListFactory;
import com.novoda.gridrop.ui.adapters.ElementSetAdapter;

/**
 * Author: zero
 * Date: 1/26/13
 */
public class ElementListFragment extends ListFragment {

    public static final String ARG_ELEMENT_TYPE = "ARG_ELEMENT_TYPE";
    private ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        android.util.Log.v("FRAG","ONCREATEVIEW");
        View view=inflater.inflate(R.layout.element_list_frag,null);

        listView= (ListView) view.findViewById(android.R.id.list);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int elementType = ElementListFactory.ELEMENT_TYPE_INPUT;
        if(getArguments()!=null ){
            elementType=getArguments().getInt(ARG_ELEMENT_TYPE,ElementListFactory.ELEMENT_TYPE_INPUT);

        }
        ElementSetAdapter adapter=new ElementSetAdapter(
                getActivity().getApplicationContext(),
                ElementListFactory.createElementList(elementType)
        );

        setListAdapter(adapter);


    }

}
