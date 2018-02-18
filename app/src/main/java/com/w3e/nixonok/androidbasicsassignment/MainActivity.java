package com.w3e.nixonok.androidbasicsassignment;

import android.support.v7.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

public class MainActivity extends AppCompatActivity implements  ProfileFragment.OnFragmentInteractionListener, FragmentRecyclerView.OnFragmentInteractionListener, CameraFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, FragmentRecyclerView.newInstance());
        transaction.commit();

        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

// Create items
        AHBottomNavigationItem resyclerViewTabButton = new AHBottomNavigationItem(R.string.app_home, R.drawable.ic_home_black_24dp, R.color.colorPrimary);
        AHBottomNavigationItem cameraViewTabButton = new AHBottomNavigationItem(R.string.app_camera_test, R.drawable.ic_camera_black_24px, R.color.colorCamera);
        AHBottomNavigationItem aboutPageTabButton = new AHBottomNavigationItem(R.string.app_profile, R.drawable.ic_assignment_ind_black_24px, R.color.colorAbout);

// Add items
        bottomNavigation.addItem(resyclerViewTabButton);
        bottomNavigation.addItem(cameraViewTabButton);
        bottomNavigation.addItem(aboutPageTabButton);

// Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));

// Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(true);

// Enable the translation of the FloatingActionButton
        //bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);

// Change colors
        bottomNavigation.setAccentColor(Color.parseColor("#F63D2B"));
        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));

// Force to tint the drawable (useful for font with icon for example)
        bottomNavigation.setForceTint(true);

// Display color under navigation bar (API 21+)
// Don't forget these lines in your style-v21
// <item name="android:windowTranslucentNavigation">true</item>
// <item name="android:fitsSystemWindows">true</item>
        bottomNavigation.setTranslucentNavigationEnabled(true);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

// Manage titles
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        //Setting up Action bar color using # color code.


// Use colored navigation with circle reveal effect
        bottomNavigation.setColored(true);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {

            Fragment currentFragment;
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {



                switch (position) {
                    case 0:
                        currentFragment = FragmentRecyclerView.newInstance();
                        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
                            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

                            ActionBar actionbar = getSupportActionBar();
                            actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#795548")));
                            actionbar.setTitle("W3Engineers");
                        }
                        break;
                    case 1:
                        currentFragment = CameraFragment.newInstance();
                        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorCameraDark));
                            getWindow().setStatusBarColor(getResources().getColor(R.color.colorCameraDark));

                            ActionBar actionbar = getSupportActionBar();
                            actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#9C27B0")));
                            actionbar.setTitle("Camera Intent");
                        }
                        break;
                    case 2:
                        currentFragment = ProfileFragment.newInstance();
                        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorAboutDark));
                            getWindow().setStatusBarColor(getResources().getColor(R.color.colorAboutDark));

                            ActionBar actionbar = getSupportActionBar();
                            actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4CAF50")));
                            actionbar.setTitle("About Developer");
                        }
                        break;
                }

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, currentFragment);
                transaction.commit();
                return true;
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
