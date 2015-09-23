package com.yunongtong.yunong.opengl_es_dome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;

import java.util.List;

/**
 * Created by Administrator on 2015/7/7.
 */
public class ThemeTestActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private DrawerLayout mDrawerLayout;

    private Toolbar mToolbar;

    private LeftMenuFragment mLeftMenuFragment;
    private ContentFragment mCurrentFragment;

    private String mTitle;

    private static final String TAG = "toolbar";
    private static final String KEY_TITLLE = "key_title";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.theme_test_layout);

        initToolBar();
        
        initViews();


        restoreTitle(savedInstanceState);

        FragmentManager fm = getSupportFragmentManager();
        mCurrentFragment = (ContentFragment) fm.findFragmentByTag(mTitle);
        if(mCurrentFragment == null){
            mCurrentFragment = ContentFragment.newInstance(mTitle);
            fm.beginTransaction().add(R.id.id_content_container,mCurrentFragment,mTitle).commit();
        }

        mLeftMenuFragment = (LeftMenuFragment) fm.findFragmentById(R.id.id_menu_container);
        if(mLeftMenuFragment == null){
            mLeftMenuFragment = new LeftMenuFragment();
            fm.beginTransaction().add(R.id.id_menu_container,mLeftMenuFragment).commit();
        }
        List<Fragment>  fragments = fm.getFragments();
        if(fragments !=null&& fragments.size()!=0)
        for (Fragment fragment : fragments){
            if(fragment == mCurrentFragment|| fragment==mLeftMenuFragment) continue;
            fm.beginTransaction().hide(fragment).commit();
        }

        mLeftMenuFragment.setOnMenuItemSelectedListener(new LeftMenuFragment.OnMenuItemSelectedListener() {
            @Override
            public void menuItemSelected(String title) {
                FragmentManager fm = getSupportFragmentManager();
                ContentFragment fragment = (ContentFragment) getSupportFragmentManager().findFragmentByTag(title);
                if (fragment == mCurrentFragment) {
                    mDrawerLayout.closeDrawer(Gravity.LEFT);
                    return;
                }
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.hide(mCurrentFragment);

                if (fragment == null) {
                    fragment = ContentFragment.newInstance(title);
                    transaction.add(R.id.id_content_container, fragment, title);
                } else {
                    transaction.show(fragment);
                }
                transaction.commit();

                mCurrentFragment = fragment;
                mTitle = title;
                mToolbar.setTitle(mTitle);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
    }

    private void restoreTitle(Bundle savedInstanceState) {
        if (savedInstanceState != null)
            mTitle = savedInstanceState.getString(KEY_TITLLE);

        if (TextUtils.isEmpty(mTitle)) {
            mTitle = getResources().getStringArray(
                    R.array.array_left_menu)[0];
        }

        mToolbar.setTitle(mTitle);
    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolbar,R.string.open,R.string.close);
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    private void initToolBar() {
        Toolbar toolbar = mToolbar = (Toolbar) findViewById(R.id.id_toolbar);
        // App Logo
         toolbar.setLogo(R.mipmap.ic_launcher);
        // Title
        toolbar.setTitle(getResources().getStringArray(R.array.array_left_menu)[0]);
        // Sub Title
        // toolbar.setSubtitle("Sub title");

//        toolbar.setTitleTextAppearance();


        setSupportActionBar(toolbar);


        //Navigation Icon
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_more);
        /*
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });*/
    }

}
