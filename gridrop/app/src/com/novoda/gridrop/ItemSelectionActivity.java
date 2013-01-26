package com.novoda.gridrop;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class ItemSelectionActivity extends SherlockFragmentActivity {

	private ViewPager mPager;

	// private

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_item_selection);

		mPager = (ViewPager) findViewById(R.id.activity_item_selection_pager);

	}

}
