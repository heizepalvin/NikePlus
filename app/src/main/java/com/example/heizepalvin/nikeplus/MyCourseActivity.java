package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.bakerj.infinitecards.AnimationTransformer;
import com.bakerj.infinitecards.CardItem;
import com.bakerj.infinitecards.InfiniteCardView;
import com.bakerj.infinitecards.ZIndexTransformer;
import com.bakerj.infinitecards.transformer.DefaultCommonTransformer;
import com.bakerj.infinitecards.transformer.DefaultTransformerToBack;
import com.bakerj.infinitecards.transformer.DefaultTransformerToFront;
import com.bakerj.infinitecards.transformer.DefaultZIndexTransformerCommon;

import org.w3c.dom.Text;

import java.lang.reflect.Field;

/**
 * Created by soyounguensoo on 2017-09-19.
 */

public class MyCourseActivity extends AppCompatActivity {

    private InfiniteCardView mCardView;
    private BaseAdapter mAdapter;
    private int[] resId = {R.drawable.coursethree, R.drawable.coursefive, R.drawable.courseone, R.drawable.coursefour, R.drawable.coursetwo};

    private NumberPicker numberPicker;

    //메뉴

    private ImageView myCourseActLogo;
    private ImageView myCourseActMenu;
    private LinearLayout myCourseActMenuText;
    private TextView myCourseActMenuHome;
    private TextView myCourseActMenuTimeline;
    private TextView myCourseActMenuGraph;
    private TextView myCourseActMenuMarathon;
    private TextView myCourseActMenuMoisture;
    private TextView myCourseActMenuShoeRack;
    private TextView myCourseActMenuCustom;
    private TextView myCourseActMenuLed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycourse_activity);

        //메뉴

        myCourseActLogo = (ImageView) findViewById(R.id.myCourseActLogo);
        myCourseActMenu = (ImageView) findViewById(R.id.myCourseActMenu);
        myCourseActMenuText = (LinearLayout) findViewById(R.id.myCourseActMenuText);
        myCourseActLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myCourseActLogo.setVisibility(View.GONE);
                myCourseActMenu.setVisibility(View.VISIBLE);
                myCourseActMenuText.setVisibility(View.VISIBLE);
                myCourseActMenuText.bringToFront();

            }
        });

        myCourseActMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCourseActLogo.setVisibility(View.VISIBLE);
                myCourseActMenu.setVisibility(View.GONE);
                myCourseActMenuText.setVisibility(View.GONE);
            }
        });

        myCourseActMenuHome = (TextView) findViewById(R.id.myCourseActMenuHome);
        myCourseActMenuHome.setOnClickListener(onClickListener);
        myCourseActMenuTimeline = (TextView) findViewById(R.id.myCourseActMenuTimeline);
        myCourseActMenuTimeline.setOnClickListener(onClickListener);
        myCourseActMenuGraph = (TextView) findViewById(R.id.myCourseActMenuGraph);
        myCourseActMenuGraph.setOnClickListener(onClickListener);
        myCourseActMenuMarathon = (TextView) findViewById(R.id.myCourseActMenuMarathon);
        myCourseActMenuMarathon.setOnClickListener(onClickListener);
        myCourseActMenuMoisture = (TextView) findViewById(R.id.myCourseActMenuMoisture);
        myCourseActMenuMoisture.setOnClickListener(onClickListener);
        myCourseActMenuShoeRack = (TextView) findViewById(R.id.myCourseActMenuShoerack);
        myCourseActMenuShoeRack.setOnClickListener(onClickListener);
        myCourseActMenuCustom = (TextView) findViewById(R.id.myCourseActMenuCustom);
        myCourseActMenuCustom.setOnClickListener(onClickListener);
        myCourseActMenuLed = (TextView) findViewById(R.id.myCourseActMenuLed);
        myCourseActMenuLed.setOnClickListener(onClickListener);

        mCardView = (InfiniteCardView) findViewById(R.id.myCourseActView);
        mAdapter = new MyAdapter(resId);
        mCardView.setAdapter(mAdapter);

//        initButton();

        numberPicker = (NumberPicker) findViewById(R.id.myCoursePicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(20);
        numberPicker.setValue(3);
        numberPicker.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        setDividerColor(numberPicker,Color.TRANSPARENT);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/Uniform-Bold.otf");
        setTypeface(numberPicker,typeface);

        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                if(newVal == 3){
                    if(oldVal < newVal){
                        setStyle1();
                        mCardView.bringCardToFront(1);
                    } else {
                        setStyle1();
                        mCardView.bringCardToFront(mAdapter.getCount()-1);
                    }
                } else if(newVal == 4){
                    if(oldVal < newVal){
                        setStyle1();
                        mCardView.bringCardToFront(1);
                    } else {
                        setStyle1();
                        mCardView.bringCardToFront(mAdapter.getCount()-1);
                    }
                } else if(newVal == 7){
                    if(oldVal < newVal){
                        setStyle1();
                        mCardView.bringCardToFront(1);
                    } else {
                        setStyle1();
                        mCardView.bringCardToFront(mAdapter.getCount()-1);
                    }
                } else if(newVal == 8){
                    if(oldVal < newVal){
                        setStyle1();
                        mCardView.bringCardToFront(1);
                    } else {
                        setStyle1();
                        mCardView.bringCardToFront(mAdapter.getCount()-1);
                    }
                } else if(newVal == 15){
                    if(oldVal < newVal){
                        setStyle1();
                        mCardView.bringCardToFront(1);
                    } else {
                        setStyle1();
                        mCardView.bringCardToFront(mAdapter.getCount()-1);
                    }
                } else {
                    mCardView.bringCardToFront(0);
                }


            }
        });

    }

    private TextView.OnClickListener onClickListener = new TextView.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){

                case R.id.myCourseActMenuHome:

                    Intent intent = new Intent(MyCourseActivity.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                    break;
                case R.id.myCourseActMenuTimeline:

                    Intent intent2 = new Intent(MyCourseActivity.this,TimeActivity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent2);

                    break;
                case R.id.myCourseActMenuGraph:

                    Intent intent3 = new Intent(MyCourseActivity.this,ChartActivity.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent3);

                    break;
                case R.id.myCourseActMenuMarathon:

                    Intent intent4 = new Intent(MyCourseActivity.this,MarathonActivity.class);
                    intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent4);

                    break;
                case R.id.myCourseActMenuMoisture:

                    Intent intent5 = new Intent(MyCourseActivity.this,MoistureActivity.class);
                    intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent5);

                    break;
                case R.id.myCourseActMenuShoerack:

                    Intent intent6 = new Intent(MyCourseActivity.this,ShoesActivity.class);
                    intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent6);

                    break;
                case R.id.myCourseActMenuCustom:

                    Intent intent7 = new Intent(MyCourseActivity.this,ShoesCustomActivity.class);
                    intent7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent7);

                    break;
                case R.id.myCourseActMenuLed:

                    Intent intent8 = new Intent(MyCourseActivity.this,LedActivity.class);
                    intent8.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent8);

                    break;
            }
        }
    };

    public void setTypeface(NumberPicker picker, Typeface typeface){

        try{

            Field field = NumberPicker.class.getDeclaredField("mSelectorWheelPaint");
            field.setAccessible(true);
            ((Paint)field.get(picker)).setTypeface(typeface);

        }catch (NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        }

        int count = picker.getChildCount();
        for(int i = 0; i< count; i++){
            View view = picker.getChildAt(i);
            if(view instanceof TextView){
                ((TextView)view).setTypeface(typeface);
            }
        }
    }

    private void setDividerColor(NumberPicker picker, int color){
        java.lang.reflect.Field[] pickerFields = NumberPicker.class.getDeclaredFields();
        for(java.lang.reflect.Field pf : pickerFields){
            if(pf.getName().equals("mSelectionDivider")){
                pf.setAccessible(true);
                try{
                    ColorDrawable colorDrawble = new ColorDrawable(color);
                    pf.set(picker,colorDrawble);
                }catch (IllegalAccessException | Resources.NotFoundException e) {
                    e.printStackTrace();
                }

                break;
            }
        }
    }


//    private void initButton(){
//
//        findViewById(R.id.pre).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setStyle1();
//                Log.e("피커",mAdapter.getCount() -1 +"");
//                mCardView.bringCardToFront(mAdapter.getCount() -1);
//                Log.e("피커",mAdapter.getCount() -1 +"");
//            }
//        });
//
//        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                setStyle2();
//                mCardView.bringCardToFront(1);
//            }
//        });
//    }

    private void setStyle1(){
        mCardView.setClickable(true);
        mCardView.setAnimType(InfiniteCardView.ANIM_TYPE_FRONT);
        mCardView.setAnimInterpolator(new LinearInterpolator());
        mCardView.setTransformerToFront(new DefaultTransformerToFront());
        mCardView.setTransformerToBack(new DefaultTransformerToBack());
        mCardView.setZIndexTransformerToBack(new DefaultZIndexTransformerCommon());

    }

    private void setStyle2(){
        mCardView.setClickable(false);
        mCardView.setAnimType(InfiniteCardView.ANIM_TYPE_FRONT_TO_LAST);
        mCardView.setAnimInterpolator(new OvershootInterpolator(-8));
        mCardView.setTransformerToFront(new DefaultCommonTransformer());
        mCardView.setTransformerToBack(new AnimationTransformer() {
            @Override
            public void transformAnimation(View view, float fraction, int cardWidth, int cardHeight, int fromPosition, int toPosition) {
                int positionCount = fromPosition - toPosition;
                float scale = (0.8f - 0.1f * fromPosition) + (0.1f * fraction * positionCount);
                view.setScaleX(scale);
                view.setScaleY(scale);
                if (fraction < 0.5) {
                    view.setTranslationX(cardWidth * fraction * 1.5f);
                    view.setRotationY(-45 * fraction);
                } else {
                    view.setTranslationX(cardWidth * 1.5f * (1f - fraction));
                    view.setRotationY(-45 * (1 - fraction));
                }
            }

            @Override
            public void transformInterpolatedAnimation(View view, float fraction, int cardWidth, int cardHeight, int fromPosition, int toPosition) {
                int positionCount = fromPosition - toPosition;
                float scale = (0.8f - 0.1f * fromPosition) + (0.1f * fraction * positionCount);
                view.setTranslationY(-cardHeight * (0.8f - scale) * 0.5f - cardWidth * (0.02f *
                        fromPosition - 0.02f * fraction * positionCount));
            }
        });
        mCardView.setZIndexTransformerToBack(new ZIndexTransformer() {
            @Override
            public void transformAnimation(CardItem card, float fraction, int cardWidth, int cardHeight, int fromPosition, int toPosition) {
                if (fraction < 0.5f) {
                    card.zIndex = 1f + 0.01f * fromPosition;
                } else {
                    card.zIndex = 1f + 0.01f * toPosition;
                }
            }

            @Override
            public void transformInterpolatedAnimation(CardItem card, float fraction, int cardWidth, int cardHeight, int fromPosition, int toPosition) {

            }
        });
    }


    private class MyAdapter extends BaseAdapter{

        private int[] resIds = {};

        MyAdapter (int[] resIds){
            this.resIds = resIds;
        }

        @Override
        public int getCount() {
            return resIds.length;
        }

        @Override
        public Object getItem(int position) {
            return resIds[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){

                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycourse_item, parent, false);
            }

                convertView.setBackgroundResource(resIds[position]);

            return convertView;
        }
    }
}

