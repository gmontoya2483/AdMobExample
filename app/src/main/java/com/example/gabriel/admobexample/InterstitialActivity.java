package com.example.gabriel.admobexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class InterstitialActivity extends AppCompatActivity {

    private Button mShowButton;
    private InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        mShowButton=(Button) findViewById(R.id.showButton);
        mShowButton.setEnabled(false);

    }


    public void loadInterstitial(View view){
        mShowButton.setEnabled(false);
        mShowButton.setText(getResources().getString(R.string.interstitial_loading));


        mInterstitial=new InterstitialAd(this);
        mInterstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitial.setAdListener(new ToastListener(this){
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                mShowButton.setText(getString(R.string.interstitial_show));
                mShowButton.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }
        });

        AdRequest adRequest=new AdRequest.Builder().build();
        mInterstitial.loadAd(adRequest);
    }



    public void showInterstitial(View view){

        if(mInterstitial.isLoaded()){
            mInterstitial.show();
        }

        mShowButton.setText(getString(R.string.interstitial_not_ready));
        mShowButton.setEnabled(false);

    }
}
