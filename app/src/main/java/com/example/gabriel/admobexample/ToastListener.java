package com.example.gabriel.admobexample;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

/**
 * Created by Gabriel on 05/06/2017.
 */

public class ToastListener extends AdListener{

    private Context mContext;

    public ToastListener(Context context){

        this.mContext=context;

    }


    public ToastListener() {
        super();
    }

    @Override
    public void onAdClosed() {
        super.onAdClosed();
        Toast.makeText(mContext,"onAdClosed() - The user returned to the application",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAdFailedToLoad(int i) {
        super.onAdFailedToLoad(i);
        String err_description;

        switch (i){
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                err_description="OnAdFailedToLoad(ERROR_CODE_INTERNAL_ERROR)";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                err_description="OnAdFailedToLoad(ERROR_CODE_INVALID_REQUEST)";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                err_description="OnAdFailedToLoad(ERROR_CODE_NETWORK_ERROR)";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                err_description="OnAdFailedToLoad(ERROR_CODE_NO_FILL)";
                break;
            default:
                err_description="OnAdFailedToLoad(default) - "+i;
                break;
        }

        Toast.makeText(mContext,err_description,Toast.LENGTH_LONG).show();



    }

    @Override
    public void onAdLeftApplication() {
        super.onAdLeftApplication();
        Toast.makeText(mContext,"onAdLeftApplication() - The ad opened another app (for example a browser)",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAdOpened() {
        super.onAdOpened();
        Toast.makeText(mContext,"onAdOpened() - The user clicked on the ad",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
        Toast.makeText(mContext,"On Load ()",Toast.LENGTH_LONG).show();

    }
}
