package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by soyounguensoo on 2017-10-04.
 */

public class ChartActivity extends AppCompatActivity {

    //왼쪽 그래프
    private ImageView chartActLeftChart;

    //오른쪽 그래프

    private ImageView chartActRightChartOne;
    private ImageView chartActRightChartTwo;
    private ImageView chartActRightChartThree;
    private ImageView chartActRightChartFour;

    //상단 메뉴

    private ImageView chartActLogo;
    private ImageView chartActMenu;
    private LinearLayout chartActMenuText;
    private TextView chartActMenuHome;
    private TextView chartActMenuTimeline;
    private TextView chartActMenuMyCourse;
    private TextView chartActMenuMarathon;
    private TextView chartActMenuShoeRack;
    private TextView chartActMenuMoisture;
    private TextView chartActMenuCustom;
    private TextView chartActMenuLED;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_activity);

        chartActLeftChart = (ImageView) findViewById(R.id.chartActLeftChart);

        chartActRightChartOne = (ImageView) findViewById(R.id.chartActRightChartOne);
        chartActRightChartTwo = (ImageView) findViewById(R.id.chartActRightChartTwo);
        chartActRightChartThree = (ImageView) findViewById(R.id.chartActRightChartThree);
        chartActRightChartFour = (ImageView) findViewById(R.id.chartActRightChartFour);

        //메뉴

        chartActLogo = (ImageView) findViewById(R.id.chartActLogo);
        chartActMenu = (ImageView) findViewById(R.id.chartActMenu);
        chartActMenuText = (LinearLayout) findViewById(R.id.chartActMenuText);
        chartActLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chartActLogo.setVisibility(View.GONE);
                chartActMenu.setVisibility(View.VISIBLE);
                chartActMenuText.setVisibility(View.VISIBLE);
                chartActMenuText.bringToFront();
            }
        });
        chartActMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chartActLogo.setVisibility(View.VISIBLE);
                chartActMenu.setVisibility(View.GONE);
                chartActMenuText.setVisibility(View.GONE);
            }
        });
        chartActMenuHome = (TextView) findViewById(R.id.chartActMenuHome);
        chartActMenuHome.setOnClickListener(onClickListener);
        chartActMenuTimeline = (TextView) findViewById(R.id.chartActMenuTimeline);
        chartActMenuTimeline.setOnClickListener(onClickListener);
        chartActMenuMyCourse = (TextView) findViewById(R.id.chartActMenuCourse);
        chartActMenuMyCourse.setOnClickListener(onClickListener);
        chartActMenuMarathon = (TextView) findViewById(R.id.chartActMenuMarathon);
        chartActMenuMarathon.setOnClickListener(onClickListener);
        chartActMenuShoeRack = (TextView) findViewById(R.id.chartActMenuShoerack);
        chartActMenuShoeRack.setOnClickListener(onClickListener);
        chartActMenuMoisture = (TextView) findViewById(R.id.chartActMenuMoisture);
        chartActMenuMoisture.setOnClickListener(onClickListener);
        chartActMenuCustom = (TextView) findViewById(R.id.chartActMenuCustom);
        chartActMenuCustom.setOnClickListener(onClickListener);
        chartActMenuLED = (TextView) findViewById(R.id.chartActMenuLED);
        chartActMenuLED.setOnClickListener(onClickListener);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.chart);
        chartActLeftChart.setAnimation(animation);

        Animation animationRightOne = AnimationUtils.loadAnimation(this,R.anim.chartrightone);
        chartActRightChartOne.setAnimation(animationRightOne);

        Animation animationRightTwo = AnimationUtils.loadAnimation(this,R.anim.chartrighttwo);
        chartActRightChartTwo.setAnimation(animationRightTwo);

        Animation animationRightThree = AnimationUtils.loadAnimation(this,R.anim.chartrightthree);
        chartActRightChartThree.setAnimation(animationRightThree);

        Animation animationRightFour = AnimationUtils.loadAnimation(this,R.anim.chartrightfour);
        chartActRightChartFour.setAnimation(animationRightFour);


    }

    private TextView.OnClickListener onClickListener = new TextView.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.chartActMenuHome:

                    Intent intent = new Intent(ChartActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();

                    break;

                case R.id.chartActMenuTimeline:

                    Intent intent2 = new Intent(ChartActivity.this,TimeActivity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);
                    finish();

                    break;

                case R.id.chartActMenuCourse:

                    Intent intent3 = new Intent(ChartActivity.this,MyCourseActivity.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);
                    finish();

                    break;

                case R.id.chartActMenuMarathon:

                    Intent intent4 = new Intent(ChartActivity.this,MarathonActivity.class);
                    intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent4);
                    finish();

                    break;
                case R.id.chartActMenuShoerack:

                    Intent intent5 = new Intent(ChartActivity.this,ShoesActivity.class);
                    intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent5);
                    finish();

                    break;
                case R.id.chartActMenuMoisture:

                    Intent intent6 = new Intent(ChartActivity.this,MoistureActivity.class);
                    intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent6);
                    finish();

                    break;
                case R.id.chartActMenuCustom:

                    Intent intent7 = new Intent(ChartActivity.this,ShoesCustomActivity.class);
                    intent7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent7);
                    finish();

                    break;
                case R.id.chartActMenuLED:

                    //보류
                    Intent intent8 = new Intent(ChartActivity.this,LedActivity.class);
                    intent8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent8);
                    finish();

                    break;
            }
        }
    };
}
