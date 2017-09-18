package com.example.heizepalvin.nikeplus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by soyounguensoo on 2017-09-18.
 */

public class ShoesFragmentSecond extends Fragment {

    public ShoesFragmentSecond(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.shoes_fragment_second,container,false);



        return layout;

    }
}
