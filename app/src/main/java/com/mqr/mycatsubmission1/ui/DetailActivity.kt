package com.mqr.mycatsubmission1.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mqr.mycatsubmission1.R
import com.mqr.mycatsubmission1.model.Cat
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.backBtn

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = getColor(R.color.colorPrimary)

        //hide Action Bar
        supportActionBar?.hide()

        //recive cat serialize
        val model: Cat = intent.getSerializableExtra("detail") as Cat

        //set Cat Name
        cat_name.setText(model.catName.toString())

        //set Main Image
        setImage(model.image, main_image)

        //set Description
        description_cat.setText(model.description.toString())

        //click icon back
        backBtn.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })

    }

    private fun setImage(img: Int, image: ImageView) {
        Glide.with(this)
            .load(img)
            .apply(RequestOptions().override(400, 300))
            .into(image)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}