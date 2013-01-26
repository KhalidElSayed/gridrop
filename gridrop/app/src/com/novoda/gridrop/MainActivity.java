package com.novoda.gridrop;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.example.android.swipedismiss.SwipeDismissTouchListener;
import com.novoda.gridrop.ui.fragments.ClearDialogFragment;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends SherlockFragmentActivity {

    private static final int REQUEST_CODE_ADD = 0;
    public static final String EXTRA_LAYOUT_IDS = "layoutIds";

    private LinearLayout container;
    private LinearLayout footerContainer;
    private LayoutInflater inflater;
    private Button addUiElementButton;
    private ScrollView scrollView;
    private View intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        container = (LinearLayout) findViewById(R.id.container);
        footerContainer = (LinearLayout) findViewById(R.id.container_footer);
        scrollView = (ScrollView) findViewById(R.id.scrollview);
        intro = (View) findViewById(R.id.intro);
      //  addUiElementButton = (Button) findViewById(R.id.btn_add);
        inflater = LayoutInflater.from(this);
        
        inflate(new int[] { R.layout.item_bar_section, R.layout.item_input_spinner, R.layout.item_input_edittext, R.layout.item_input_checkbox, R.layout.item_input_toogle });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_clear) {
            ClearDialogFragment.newInstance().show(getSupportFragmentManager(), null);
            return true;
        } else if (id == R.id.menu_share) {
            share();
            return true;
        } else if (id == R.id.menu_about) {
            Intent i = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(i);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    public void inflate(View view) {
        Intent i = new Intent(MainActivity.this, ItemSelectionActivity.class);
        startActivityForResult(i, REQUEST_CODE_ADD);
    }

    public void clear() {
        Animation fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        fadeOut.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                container.removeAllViews();
                if (intro.getVisibility() == View.GONE) {
                    intro.setVisibility(View.VISIBLE);
                }
            }
        });
        container.startAnimation(fadeOut);

    }

    public void removeItem(View view) {
        container.removeView(view);
        if (container.getChildCount() == 0) {
            intro.setVisibility(View.VISIBLE);
        }
    }

    public void share() {
        new ScreenshotTask() {
            protected void onPreExecute() {
                addUiElementButton.setVisibility(View.GONE);
            };

            protected void onPostExecute(File result) {
                addUiElementButton.setVisibility(View.VISIBLE);
                try {
                    if (result != null) {
                        launchGallery(Uri.fromFile(result));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.execute(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_ADD) {
            if (data != null && data.hasExtra(EXTRA_LAYOUT_IDS)) {
                ArrayList<Integer> selectedIds=data.getIntegerArrayListExtra(EXTRA_LAYOUT_IDS);
                //int[] ids = data.getIntArrayExtra(EXTRA_LAYOUT_IDS);
                inflate(selectedIds);
            }
        }
    }

    private void launchGallery(Uri uri) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(uri, "image/png");
        startActivity(intent);
    }

    public void inflate(ArrayList<Integer> ids) {
        final int size= ids.size();
        int[] res=new int[size];
        for(int i=0;i<size;i++){
            res[i]=ids.get(i);
        }
        inflate(res);
    }

    public void inflate(int[] ids) {
        if (intro.getVisibility() == View.VISIBLE) {
            intro.setVisibility(View.GONE);
        }
        if (ids != null) {
            for (int id : ids) {
                if(id>0){
                    View item = inflater.inflate(id, null);
                    item.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT));

                    // TODO determine which ids to add at the bottom
                    if (id == 0) {
                        footerContainer.addView(item);
                    } else {
                        container.addView(item);
                    }
                    item.startAnimation(getViewAddedAnimation());

                    // Create a generic swipe-to-dismiss touch listener.
                    item.setOnTouchListener(new SwipeDismissTouchListener(item, null,
                            new SwipeDismissTouchListener.OnDismissCallback() {
                                @Override
                                public void onDismiss(View view, Object token) {
                                    removeItem(view);
                                }
                            }));
                }

            }
            scrollView.post(new Runnable() {

                @Override
                public void run() {
                    scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                }
            });
        }
    }

    private Animation getViewAddedAnimation() {
        Animation a = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        return a;
    }

    class ScreenshotTask extends AsyncTask<Activity, Void, File> {
        private static final String SAVE_FOLDER = "/DCIM/gridrop";
        private static final String PNG_SUFFIX = ".png";

        @Override
        protected File doInBackground(Activity... params) {
            try {
                File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + SAVE_FOLDER);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File file = new File(dir.getAbsolutePath(), System.currentTimeMillis() + PNG_SUFFIX);
                FileOutputStream out = new FileOutputStream(file);

                Screenshot s = new Screenshot(params[0]);
                Bitmap b = s.snap();
                b.compress(CompressFormat.PNG, 100, out);

                return file;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
