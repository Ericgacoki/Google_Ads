package com.ericg.ads

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ), 2
        )

        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED

            &&

            ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {

            supportActionBar?.title = "Google test Ads"
            Toast.makeText(this, "You need Internet to see Ads", LENGTH_LONG).show()


            MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713")
            adView1.loadAd(AdRequest.Builder().build())
            adView2.loadAd(AdRequest.Builder().build())
            textViewAdType.setOnClickListener {
                Toast.makeText(this, " 480x60 Ads ", LENGTH_LONG).show()
            }
            arrowForward.setOnClickListener {
                Toast.makeText(this, "Other Ads", LENGTH_LONG).show()
                startActivity(Intent(this, AdsType2::class.java))
            }
        }
        else{
            Toast.makeText(this, " Permission denied", LENGTH_LONG).show()
        }

    }
}
