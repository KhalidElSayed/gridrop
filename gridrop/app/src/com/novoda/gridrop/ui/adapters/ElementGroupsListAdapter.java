package com.novoda.gridrop.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.novoda.gridrop.R;

import java.util.List;
import java.util.Map;

/**
 * Author: zero
 * Date: 1/26/13
 */
public class ElementGroupsListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private Map<Integer, List<Integer>> data;
    private LayoutInflater inflater;

    public ElementGroupsListAdapter(final Context context,final Map<Integer, List<Integer>> data){
        this.context=context;
        this.data=data;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int i) {
        final List<Integer>group=data.get(fetchGroupKeyForPosition(i));
        if(group==null){
            android.util.Log.v("Adapter","group is null for pos#"+i);
            android.util.Log.v("Adapter","data:\n"+data.toString());
        }
        return group.size();
    }

    @Override
    public Object getGroup(int i) {
        return data.get(i);
    }

    @Override
    public Object getChild(int group, int child) {
        return data.get(fetchGroupKeyForPosition(group)).get(child);
    }

    @Override
    public long getGroupId(int i) {
        return fetchGroupKeyForPosition(i);
    }

    @Override
    public long getChildId(int group, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int group, boolean b, View view, ViewGroup viewGroup) {
        if(view==null){
            view=inflater.inflate(R.layout.list_header,null);
        }
        TextView tv=(TextView)view.findViewById(R.id.listHeaderTitle);
        tv.setText(getTextForGroup(group));

        return  view;
    }

    @Override
    public View getChildView(int group, int child, boolean b, View view, ViewGroup viewGroup) {
        return inflater.inflate(data.get(group).get(child),null);
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private int getTextForGroup(final int group){
        Integer[] keys = new Integer[data.keySet().size()];
        data.keySet().toArray(keys);
        return keys[group];
    }


    private Integer fetchGroupKeyForPosition(int pos) {
        Integer[] keys = new Integer[data.keySet().size()];
        data.keySet().toArray(keys);
        return keys[pos];
    }


}
