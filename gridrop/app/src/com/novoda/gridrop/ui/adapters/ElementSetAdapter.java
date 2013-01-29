package com.novoda.gridrop.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.novoda.gridrop.R;
import com.novoda.gridrop.data.Element;
import com.novoda.gridrop.data.Header;

import java.util.List;

/**
 * Author: zero Date: 1/26/13
 */
public class ElementSetAdapter extends BaseAdapter {

    private Context context;
    private List<Object> elementSets;
    private LayoutInflater inflater;

    public ElementSetAdapter(Context context, List<Object> objects) {
        this.context = context;
        this.elementSets = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return elementSets.size();
    }

    @Override
    public Object getItem(int position) {
        return elementSets.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0; // To change body of implemented methods us File | Settings | File Templates.
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        android.util.Log.v("ADAPTER", "GETVIEW FOR " + pos);
        Object object = elementSets.get(pos);

        if (object != null && object instanceof Element) {
            view = getElement((Element) object);

        } else if (object != null && object instanceof Header) {

            view = getHeader((Header) object);
        }

        return view;
    }

    private View getHeader(Header header) {

        View view = inflater.inflate(R.layout.list_header, null);

        TextView tv = (TextView) view.findViewById(R.id.listHeaderTitle);
        tv.setText(header.title);

        return view;
    }

    private View getElement(final Element element) {

        View view = inflater.inflate(R.layout.list_element, null);

        if (element != null) {
            TextView tv = (TextView) view.findViewById(R.id.name);
            tv.setText(element.name);
            ImageView iv = (ImageView) view.findViewById(R.id.image);
            iv.setImageResource(element.image);
        }
        return view;
    }

    @Override
    public boolean isEnabled(int position) {

        Object object = elementSets.get(position);

        if (object != null && object instanceof Element) {
            return true;
        }

        return false;
    }

}
