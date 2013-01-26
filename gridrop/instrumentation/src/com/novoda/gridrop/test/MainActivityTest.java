package com.novoda.gridrop.test;

import android.test.ActivityInstrumentationTestCase2;
import com.novoda.gridrop.*;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void testActivity() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
}

