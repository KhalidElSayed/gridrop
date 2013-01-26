package com.novoda.gridrop;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.novoda.gridrop.ui.adapters.ItemSelectionPagerAdapter;

public class ItemSelectionActivity extends SherlockFragmentActivity {

	private ViewPager pager;
	private ItemSelectionPagerAdapter adapter;

	private ArrayList<Integer> selectedLayouts = new ArrayList<Integer>();

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

	public void onCancelClicked(View view) {
		setResult(RESULT_CANCELED);
		finish();
	}

	public void onInsertClicked(View view) {
		Intent returnIntent = new Intent();
		returnIntent.putIntegerArrayListExtra(MainActivity.EXTRA_LAYOUT_IDS, selectedLayouts);
		setResult(RESULT_OK, returnIntent);
		finish();
	}

}
