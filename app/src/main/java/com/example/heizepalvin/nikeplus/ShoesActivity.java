package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by soyounguensoo on 2017-09-18.
 */

public class ShoesActivity extends AppCompatActivity{

    public ViewPager vp;
    private ImageView logoMenu;
    private ImageView menuList;
    private LinearLayout menuText;
    private LinearLayout ll;

    //텍스트메뉴

    private TextView menuListHome;
    private TextView menuListTimeline;
    private TextView menuListMarathon;
    private TextView menuListMarathonCourse;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoes_list_activity);

        logoMenu = (ImageView) findViewById(R.id.shoesListActLogo);
        menuList = (ImageView) findViewById(R.id.shoesListActMenu);
        menuText = (LinearLayout) findViewById(R.id.shoesListActMenuText);
        ll = (LinearLayout) findViewById(R.id.ll);

        //텍스트 메뉴

        menuListHome = (TextView) findViewById(R.id.shoesListActMenuHome);
        menuListTimeline = (TextView) findViewById(R.id.shoesListActMenuTimeline);
        menuListMarathon = (TextView) findViewById(R.id.shoesListActMenuMarathon);
        menuListMarathonCourse = (TextView) findViewById(R.id.shoesListActMenuCourse);

        logoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll.bringToFront();
                logoMenu.setVisibility(View.GONE);
                menuList.setVisibility(View.VISIBLE);
                menuText.setVisibility(View.VISIBLE);

            }
        });

        menuList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoMenu.setVisibility(View.VISIBLE);
                logoMenu.bringToFront();
                menuList.setVisibility(View.GONE);
                menuText.setVisibility(View.GONE);
            }
        });

        menuListHome.setOnClickListener(onClickListener);
        menuListTimeline.setOnClickListener(onClickListener);
        menuListMarathon.setOnClickListener(onClickListener);
        menuListMarathonCourse.setOnClickListener(onClickListener);

        vp = (ViewPager) findViewById(R.id.vp);

        vp.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(2);
        vp.setClipToPadding(false);
        vp.setPadding(200,0,200,0);
        vp.setPageMargin(getResources().getDisplayMetrics().widthPixels/-5);
        vp.setOffscreenPageLimit(2);


        vp.setPageTransformer(true,new ZoomOutPageTransFormer());
    }

    private TextView.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.shoesListActMenuHome:
                    Intent intent = new Intent(ShoesActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.shoesListActMenuTimeline:
                    Intent intent2 = new Intent(ShoesActivity.this,TimeActivity.class);
                    startActivity(intent2);
                    finish();
                    break;
                case R.id.shoesListActMenuMarathon:
                    Intent intent3 = new Intent(ShoesActivity.this,MarathonActivity.class);
                    startActivity(intent3);
                    finish();
                    break;
                case R.id.shoesListActMenuCourse:
                    Intent intent4 = new Intent(ShoesActivity.this,MarathonPlayActivity.class);
                    startActivity(intent4);
                    finish();
                    break;
            }
        }
    };


    private class pagerAdapter extends FragmentStatePagerAdapter{

        public pagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){

                case 0:
                    return new ShoesFragmentFirst();
                case 1:
                    return new ShoesFragmentSecond();
                case 2:
                    return new ShoesFragmentThird();
                case 3:
                    return new ShoesFragmentFourth();
                case 4:
                    return new ShoesFragmentFifth();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            Log.e("뭔데이건",position+"");

            return super.instantiateItem(container, position);
        }
    }
}
