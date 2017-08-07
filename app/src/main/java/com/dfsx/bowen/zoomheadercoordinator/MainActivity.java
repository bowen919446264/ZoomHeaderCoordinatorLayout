package com.dfsx.bowen.zoomheadercoordinator;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.dfsx.bowen.zoomheadercoordinator.util.PixelUtil;
import com.dfsx.bowen.zoomheadercoordinator.view.IPullZoom;
import com.dfsx.bowen.zoomheadercoordinator.view.SimpleViewPagerIndicator;
import com.dfsx.bowen.zoomheadercoordinator.view.ZoomHeaderCoordinatorLayout;

public class MainActivity extends FragmentActivity implements IPullZoom {

    private String[] mTitles = new String[]{"简介", "评价", "相关"};
    private SimpleViewPagerIndicator mIndicator;
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private TabFragment[] mFragments = new TabFragment[mTitles.length];
    private ZoomHeaderCoordinatorLayout coordinatorLayout;
    private AppBarLayout appBarLayout;
    private View zoomView;

    private int headerOffSetSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initDatas();
        initEvents();
    }

    private void initEvents() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                mIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initDatas() {
        mIndicator.setTitles(mTitles);

        for (int i = 0; i < mTitles.length; i++) {
            mFragments[i] = (TabFragment) TabFragment.newInstance(mTitles[i]);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments[position];
            }

        };

        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
    }

    private void initViews() {
        mIndicator = (SimpleViewPagerIndicator) findViewById(R.id.id_stickynavlayout_indicator);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        coordinatorLayout = (ZoomHeaderCoordinatorLayout) findViewById(R.id.main_content);
        zoomView = findViewById(R.id.scroll_snap_view);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);

        coordinatorLayout.setPullZoom(zoomView, PixelUtil.dp2px(this, 200),
                PixelUtil.dp2px(this, 300), this);
        //        zoomHelper = PullZoomHelper.getInstance();
        //        zoomHelper.initData(zoomView, PixelUtil.dp2px(this, 200), this);
        //        coordinatorLayout.setOnTouchListener(new View.OnTouchListener() {
        //            @Override
        //            public boolean onTouch(View v, MotionEvent event) {
        //                return zoomHelper.onZoomTouch(event);
        //            }
        //        });
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                headerOffSetSize = verticalOffset;
            }
        });
    }

    @Override
    public boolean isReadyForPullStart() {
        return headerOffSetSize == 0;
    }

    @Override
    public void onPullZooming(int newScrollValue) {

    }

    @Override
    public void onPullZoomEnd() {

    }
}
