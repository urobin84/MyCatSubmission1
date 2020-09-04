package com.mqr.mycatsubmission1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mqr.mycatsubmission1.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail Ras Kucing"
    }
}