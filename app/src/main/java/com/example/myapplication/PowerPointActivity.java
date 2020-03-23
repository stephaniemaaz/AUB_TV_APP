package com.example.myapplication;

import androidx.viewpager2.widget.ViewPager2;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;

// for a one image display, the image can be treated similarly to a powerpoint.
public class PowerPointActivity extends Activity {
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Timber.i("onCreate in Power Point Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_pager_main);
        TextView mTextTitle = findViewById(R.id.fragment_pager_main_title);
        mTextTitle.setText(R.string.filler_title);
        TextView mTextDescription = findViewById(R.id.fragment_pager_main_about);
        mTextDescription.setText(R.string.filler_text_short);
        LinearLayout mLayout = findViewById(R.id.fragment_pager_main_child);
        mLayout.setBackgroundResource(R.color.Transparent_black);
        viewPager2 = findViewById(R.id.fragment_pager_viewPager2);
        setUpPagerAdapter();

    }
    /**
     * set up adapter same like you do for RecyclerView or other components
     */
    private void setUpPagerAdapter() {
        Timber.i("setUpPagerAdapter in Power Point Activity");
        MyPowerpointAdapter pagerAdapter = new MyPowerpointAdapter(fetchDummyData());
        viewPager2.setAdapter(pagerAdapter);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }
    /**
     * @return this method will return dummy data in form of list
     */
    private List<Powerpoint> fetchDummyData() {
        Timber.i("fetchDummyData in Power Point Activity");
        List<Powerpoint> powerpointList = new ArrayList<>();
        String[] dummyArrDescriptions = getResources().getStringArray(R.array.array_str_descriptions_for_powerPoints);
        String[] dummyArrTitles = getResources().getStringArray(R.array.array_str_titles_for_powerPoints);
        for (int index = 0; index < dummyArrTitles.length; ++index) {
//            if (index == 0) {
//                Powerpoint powerpoint = new Powerpoint(dummyArrTitles[index], dummyArrDescriptions[index], R.drawable.powersample1);
//            } else {
            Powerpoint powerpoint = new Powerpoint(R.drawable.ppt_image);
//            }
            powerpointList.add(powerpoint);
        }
        return powerpointList;
    }

    /**
     * this method handles slideshow navigation
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT: {
                Timber.i("10 changed it");
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
                Toast.makeText(PowerPointActivity.this, "Left pressed!", Toast.LENGTH_SHORT).show();
                break;
            }
            case KeyEvent.KEYCODE_DPAD_RIGHT: {
                Timber.i("11 changed it");
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
                Toast.makeText(PowerPointActivity.this, "Right pressed!", Toast.LENGTH_SHORT).show();
                break;
            }
//            Cancelling event due to no window focus: KeyEvent. It seems like there is something wrong here and its late so I will sleep :}
            case KeyEvent.KEYCODE_BACK: {
                Timber.i("12 changed it");
                Toast.makeText(PowerPointActivity.this, "Back pressed!", Toast.LENGTH_SHORT).show();
                super.onBackPressed();
                break;
            }
            // todo: Set up animation for text : fading in, fading out
            case KeyEvent.KEYCODE_ENTER: {
                Timber.i("13 changed it");
                if (findViewById(R.id.fragment_pager_main_child).isShown()) {
                    findViewById(R.id.fragment_pager_main_child).setVisibility(View.INVISIBLE);
                    LinearLayout mLayout = findViewById(R.id.fragment_pager_main_child);
                    Animation outFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                    mLayout.startAnimation(outFade);
                    mLayout.startAnimation(outFade);
                    break;
                } else {
                    LinearLayout mLayout = findViewById(R.id.fragment_pager_main_child);
                    Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                    mLayout.startAnimation(aniFade);
                    mLayout.startAnimation(aniFade);
                    findViewById(R.id.fragment_pager_main_child).setVisibility(View.VISIBLE);
                    break;
                }
            }
        }
        return false;
    }
}


