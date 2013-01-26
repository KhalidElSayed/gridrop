package com.novoda.gridrop;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.novoda.gridrop.ui.adapters.ItemSelectionPagerAdapter;

public class ItemSelectionActivity extends SherlockFragmentActivity {

	private ViewPager pager;
	private ItemSelectionPagerAdapter adapter;

	private List<Integer> selectedLayouts = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_selection);

		pager = (ViewPager) findViewById(R.id.activity_item_selection_pager);

		adapter = new ItemSelectionPagerAdapter(getSupportFragmentManager());
		pager.setAdapter(adapter);
	}

	public void addLayoutId(Integer resId) {
		if (!selectedLayouts.contains(resId)) {
			selectedLayouts.add(resId);
		}
	}

	public void removeLayoutId(Integer resId) {
		selectedLayouts.remove(resId);
	}

}
