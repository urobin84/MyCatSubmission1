package com.mqr.mycatsubmission1.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.mqr.mycatsubmission1.R
import kotlinx.android.synthetic.main.activity_about.*


class AboutActivity : AppCompatActivity() {

    var layoutparams: RelativeLayout.LayoutParams? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = getColor(R.color.colorPrimary)

        //hide Action Bar
        supportActionBar?.hide()

        Glide.with(this)
            .load(this.getResources().getIdentifier("robin", "drawable", this.getPackageName()))
            .into(img_item_photo_about)

        backBtn.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}