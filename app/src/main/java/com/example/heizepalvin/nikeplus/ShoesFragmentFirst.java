package com.example.heizepalvin.nikeplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by soyounguensoo on 2017-09-18.
 */

public class ShoesFragmentFirst extends Fragment {

    private ImageView shoesOne;

    public ShoesFragmentFirst(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {

        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.shoes_fragment_first,container,false);

        shoesOne = (ImageView) layout.findViewById(R.id.shoesFragmentFirstImg);
        shoesOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(layout.getContext(),ShoesCustomActivity.class);
                startActivity(intent);
            }
        });

        return layout;

    }
}
