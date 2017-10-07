package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
    private TextView menuListGraph;
    private TextView menuListMoisture;
    private TextView menuListCustom;
    private TextView menuListLed;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shoes_list_activity);

        logoMenu = (ImageView) findViewById(R.id.marathonPlayActLogo);
        menuList = (ImageView) findViewById(R.id.shoesListActMenu);
        menuText = (LinearLayout) findViewById(R.id.shoesListActMenuText);
        ll = (LinearLayout) findViewById(R.id.ll);

        //텍스트 메뉴

        menuListHome = (TextView) findViewById(R.id.shoesListActMenuHome);
        menuListTimeline = (TextView) findViewById(R.id.shoesListActMenuTimeline);
        menuListMarathon = (TextView) findViewById(R.id.shoesListActMenuMarathon);
        menuListMarathonCourse = (TextView) findViewById(R.id.shoesListActMenuCourse);
        menuListGraph = (TextView) findViewById(R.id.shoesListActMenuGraph);
        menuListMoisture = (TextView) findViewById(R.id.shoesListActMenuMoisture);
        menuListCustom = (TextView) findViewById(R.id.shoesListActMenuCustom);
        menuListLed = (TextView) findViewById(R.id.shoesLIstActMenuLed);

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
        menuListGraph.setOnClickListener(onClickListener);
        menuListMoisture.setOnClickListener(onClickListener);
        menuListCustom.setOnClickListener(onClickListener);
        menuListLed.setOnClickListener(onClickListener);

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
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.shoesListActMenuTimeline:
                    Intent intent2 = new Intent(ShoesActivity.this,TimeActivity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);
                    finish();
                    break;
                case R.id.shoesListActMenuMarathon:
                    Intent intent3 = new Intent(ShoesActivity.this,MarathonActivity.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);
                    finish();
                    break;
                case R.id.shoesListActMenuCourse:
                    Intent intent4 = new Intent(ShoesActivity.this,MyCourseActivity.class);
                    intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent4);
                    finish();
                    break;

                case R.id.shoesListActMenuGraph:

                    Intent intent5 = new Intent(ShoesActivity.this,ChartActivity.class);
                    intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent5);
                    finish();

                    break;

                case R.id.shoesListActMenuMoisture:

                    Intent intent6 = new Intent(ShoesActivity.this,MoistureActivity.class);
                    intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent6);
                    finish();
                    break;
                case R.id.shoesListActMenuCustom:

                    Intent intent7 = new Intent(ShoesActivity.this,ShoesCustomActivity.class);
                    intent7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(intent7);
                    finish();
                    break;
                case R.id.shoesLIstActMenuLed:

                    Intent intent8 = new Intent(ShoesActivity.this,LedActivity.class);
                    intent8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent8);
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
