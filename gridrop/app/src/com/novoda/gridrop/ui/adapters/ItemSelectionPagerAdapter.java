package com.novoda.gridrop.ui.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.novoda.gridrop.data.ElementListFactory;
import com.novoda.gridrop.ui.fragments.ElementListFragment;

public class ItemSelectionPagerAdapter extends FragmentPagerAdapter {

	private static final String[] TITLES = { "LISTS", "INPUTS", "BARS" };

	public ItemSelectionPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {

		Bundle b = new Bundle();

		if (position == 0) {
			b.putInt(ElementListFragment.ARG_ELEMENT_TYPE, ElementListFactory.ELEMENT_TYPE_LIST);
		} else if (position == 1) {
			b.putInt(ElementListFragment.ARG_ELEMENT_TYPE, ElementListFactory.ELEMENT_TYPE_INPUT);
		} else if (position == 2) {
			b.putInt(ElementListFragment.ARG_ELEMENT_TYPE, ElementListFactory.ELEMENT_TYPE_BAR);
		}

		Fragment f = new ElementListFragment();
		f.setArguments(b);

		return f;
	}

	@Override
	public int getCount() {
		return TITLES.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return TITLES[position];
	}

}
