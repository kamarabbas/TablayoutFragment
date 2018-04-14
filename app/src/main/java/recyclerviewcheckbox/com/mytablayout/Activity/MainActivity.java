package recyclerviewcheckbox.com.mytablayout.Activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import recyclerviewcheckbox.com.mytablayout.Fragment.HomeFragment;
import recyclerviewcheckbox.com.mytablayout.Fragment.MovieFragment;
import recyclerviewcheckbox.com.mytablayout.R;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        getid();
        setViewPager();
    }

    private void setViewPager() {
        tabLayout.setupWithViewPager(viewPager);

        viewPagerAdapter = new ViewPagerAdapter( getSupportFragmentManager() );
        viewPagerAdapter.addFragment( new HomeFragment(), "Home" );
        viewPagerAdapter.addFragment( new MovieFragment(), "Movies" );

        viewPager.setAdapter( viewPagerAdapter );
        viewPager.setOffscreenPageLimit( 2 );
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout ) );
        tabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem( tab.getPosition() );
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        } );
    }


    private void getid() {
        try {
            tabLayout = (TabLayout) findViewById( R.id.tabLayout );
            viewPager = (ViewPager) findViewById( R.id.viewPager );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super( manager );
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get( position );
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add( fragment );
            mFragmentTitleList.add( title );
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get( position );
        }
    }

}

