package com.novoda.gridrop.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.novoda.gridrop.R;
import com.novoda.gridrop.ui.fragments.ElementListFragment;

/**
 * Author: zero
 * Date: 1/26/13
 */
public class TestActivity extends SherlockFragmentActivity {

    public  void onCreate(final Bundle icicle){
        super.onCreate(icicle);
        setContentView(R.layout.test_acv);
        FragmentTransaction t=getSupportFragmentManager().beginTransaction();
        t.add(R.id.container, new ElementListFragment()).commit();
    }
}
