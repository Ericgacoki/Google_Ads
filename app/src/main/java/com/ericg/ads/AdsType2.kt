package com.ericg.ads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_ads_type2.*
import java.util.*

class AdsType2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ads_type2)

        supportActionBar?.title = "Fullscreen Ad"

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/6300978111")
        adView3.loadAd(AdRequest.Builder().build())
    }
}
