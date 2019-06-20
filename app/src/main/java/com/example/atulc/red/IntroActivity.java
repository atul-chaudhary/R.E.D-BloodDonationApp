package com.example.atulc.red;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.atulc.blackspot_sih.R;
import com.github.paolorotolo.appintro.AppIntro2;

public class IntroActivity extends AppIntro2 {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(SampleSlide.newInstance(R.layout.slide1));
        addSlide(SampleSlide.newInstance(R.layout.slide2));
        addSlide(SampleSlide.newInstance(R.layout.slide3));
        //addSlide(SampleSlide.newInstance(R.layout.slide4));
        showSkipButton(false);

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }
}
