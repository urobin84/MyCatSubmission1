package com.mqr.mycatsubmission1.ui

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mqr.mycatsubmission1.R
import com.mqr.mycatsubmission1.model.Cat
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //actionbar
        val actionbar = supportActionBar
        //set Title
        actionbar?.title = "Detail Ras Kucing"
        //set back button
        actionbar?.setDisplayHomeAsUpEnabled(true)

        //recive cat serialize
        val model: Cat = intent.getSerializableExtra("detail") as Cat

        //set Cat Name
        cat_name.setText(model.catName.toString())

        //set Main Image
        setImage(model.image, main_image)

        //set Karakter Image body
        setImage(R.drawable.bodycat, icon_bodycat)

        //set Karakter Image body
        setImage(R.drawable.coralcat, icon_coral)

        //set Karakter Image foot
        setImage(R.drawable.footcat, icon_footcat)

        //set Karakter Image balance
        setImage(R.drawable.catbalace, icon_catbalance)

        //set Description
        description_cat.setText(model.description.toString())

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