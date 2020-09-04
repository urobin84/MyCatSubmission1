package com.mqr.mycatsubmission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        //actionbar
        val actionbar = supportActionBar
        supportActionBar?.title = "About"
        //set back button
        actionbar?.setDisplayHomeAsUpEnabled(true)

        Glide.with(this)
            .load(this.getResources().getIdentifier("robin", "drawable", this.getPackageName()))
//            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
//            .apply(RequestOptions().override(55, 55))
            .into(img_item_photo_about)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}