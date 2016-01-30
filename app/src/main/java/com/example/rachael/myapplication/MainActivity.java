package com.example.rachael.myapplication;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    //Declare the widgets
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates a new toolbar and generates the toolbar.xml file
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //supports the widget
        setSupportActionBar(toolbar);
        //displays the actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /** Creates the 'swipe' part of the screen (where text and data goes)
            this is taken from the activity.xml file      **/

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        /** Creates the 'Tab' part of the screen (where text and data goes)
         this is taken from the activity.xml file    **/
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        // sets the tabs up with the viewpager- tabs sit above
        tabLayout.setupWithViewPager(viewPager);
    }

    /** declare each fragment class as a new fragment(This is going to set the
        ViewPager text and then the tab name**/
    OneFragment Fragmentone = new OneFragment();
    TwoFragment Fragmenttwo = new TwoFragment();
    ThreeFragment Fragmentthree = new ThreeFragment();
    FourFragment Fragmentfour = new FourFragment();
    FiveFragment Fragmentfive = new FiveFragment();
    SixFragment Fragmentsix = new SixFragment();

    /** Sets the params needed **/
    private void setupViewPager(ViewPager viewPager) {

        /** Declares a new viewpager adapter variable**/
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Stores the selected fragment info in the adaptor
        adapter.addFrag(Fragmentone, "Progress");
        adapter.addFrag(Fragmenttwo, "Routines");
        adapter.addFrag(Fragmentthree, "Affirmations");
        adapter.addFrag(Fragmentfour, "Goals");
        adapter.addFrag(Fragmentfive, "Reflection");
        adapter.addFrag(Fragmentsix, "Achievements");

        //gets the adaptor variable
        viewPager.setAdapter(adapter);
    }

    //This class handles the Viewpager and the Fragment
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
