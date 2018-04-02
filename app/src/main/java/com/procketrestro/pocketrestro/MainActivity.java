package com.procketrestro.pocketrestro;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private SliderLayout slider;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    Button btn_detect_my_location;
    CardView cv_enter_manually;
    String lat;

    String provider;
    protected String latitude, longitude;
    protected boolean gps_enabled, network_enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Slider();
        onClick();
    }//onCreateClose

    public void onClick() {
        btn_detect_my_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleLocation();
            }
        });
        cv_enter_manually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }//onClickClose

    public void initView() {
        context = this;
        slider = (SliderLayout) findViewById(R.id.slider);
        btn_detect_my_location = (Button) findViewById(R.id.btn_detect_my_location);
        cv_enter_manually = (CardView) findViewById(R.id.cv_enter_manually);
    } //   intViewClose

    public void GoogleLocation() {

    }//googleLocationClose


    public void Slider()
    {

        HashMap<String,String> url_maps = new HashMap<String, String>();
        url_maps.put("Hannibal", "http://www.3aceinfotech.com/android_webservices/image1.jpg");
        url_maps.put("Big Bang Theory", "http://www.3aceinfotech.com/android_webservices/image2.jpg");
        url_maps.put("House of Cards", "http://www.3aceinfotech.com/android_webservices/image3.jpg");
        url_maps.put("Game of Thrones", "http://www.3aceinfotech.com/android_webservices/image4.jpg");
        for(String name : url_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra",name);

            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.FlipPage);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        //slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(3000);
      //  slider.addOnPageChangeListener(this);
    }//SliderClose

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        slider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        //Toast.makeText(this,slider.getBundle().get("extra") + "",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
