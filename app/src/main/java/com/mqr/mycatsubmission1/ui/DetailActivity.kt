package com.mqr.mycatsubmission1.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mqr.mycatsubmission1.R
import com.mqr.mycatsubmission1.model.Cat
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    var imgShare = ""
    var txtShare = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = getColor(R.color.colorPrimary)

        //hide Action Bar
        supportActionBar?.hide()

        //recive cat serialize
        val model: Cat = intent.getSerializableExtra("detail") as Cat

        //get nama file from id drawable
        val namaFile = getNamaFileFromDrawable(model.image)

        imgShare = namaFile
        txtShare = model.catName

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

        btn_share.setOnClickListener(View.OnClickListener {
            shareToWhatsApps(imgShare, txtShare)
        })

    }

    private fun getNamaFileFromDrawable(idResource: Int): String {
        val value = TypedValue()
        resources.getValue(idResource, value, true)
        val st = value.string.toString().split("/").toTypedArray()
        val n =  st[2].toString().split(".")
        return n[0].toString()

    }

    private fun shareToWhatsApps(imgShare: String, txtShare: String) {
        val uriImage = Uri.parse("android.resource://"+ this.packageName + "/drawable/$imgShare") as Uri
        val i = Intent()
        i.setAction(Intent.ACTION_SEND)
        i.setType("image/*")
        i.putExtra(Intent.EXTRA_STREAM, uriImage)
        i.putExtra(Intent.EXTRA_TEXT, txtShare)
        val chooser = Intent.createChooser(i, "Kirim Gambar")
        startActivity(chooser)
        i.setPackage("com.whatsapp")
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