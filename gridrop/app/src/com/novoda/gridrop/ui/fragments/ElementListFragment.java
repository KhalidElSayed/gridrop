package com.novoda.gridrop.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.novoda.gridrop.R;
import com.novoda.gridrop.data.ElementListFactory;
import com.novoda.gridrop.ui.adapters.ElementGroupsListAdapter;

/**
 * Author: zero
 * Date: 1/26/13
 */
public class ElementListFragment extends Fragment {

    public static final String ARG_ELEMENT_TYPE = "ARG_ELEMENT_TYPE";
    private ExpandableListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.element_list_frag,container,false);

        listView= (ExpandableListView) view.findViewById(android.R.id.list);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final int elementType=getArguments().getInt(ARG_ELEMENT_TYPE);

        ElementGroupsListAdapter adapter = new ElementGroupsListAdapter(
                getActivity().getApplicationContext(),
                ElementListFactory.createElementList(elementType)
        );

        setListAdapter(adapter);


    }


    private void setListAdapter(final ExpandableListAdapter adapter) {
        this.listView.setAdapter(adapter);
    }


}
