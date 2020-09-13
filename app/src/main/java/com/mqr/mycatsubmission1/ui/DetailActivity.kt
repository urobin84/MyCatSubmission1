package com.mqr.mycatsubmission1.ui

import android.Manifest
import android.app.Activity
import android.app.AlertDialog.*
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mqr.mycatsubmission1.R
import com.mqr.mycatsubmission1.model.Cat
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    val MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123

    var imgShare = 0
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

        imgShare = model.image.toInt()
        txtShare = model.catName.toString()

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

            shareToWhatsApps(model.image, txtShare)

        })

    }

    private fun shareToWhatsApps(imgDrawable: Int, txtShare: String) {
        var imageUri: Uri? = null
        try {
            imageUri = Uri.parse(
                MediaStore.Images.Media.insertImage(
                    contentResolver,
                    BitmapFactory.decodeResource(resources, imgDrawable), null, null
                )
            )
        } catch (e: NullPointerException) {
            Log.d("PATH DRAWABLE TEST MQR = ", e.toString())
            Toast.makeText(this, "Gambar tidak bisa di share", Toast.LENGTH_SHORT).show()
        }
        val whatsappIntent = Intent(Intent.ACTION_SEND)
        whatsappIntent.type = "/"
        whatsappIntent.putExtra(Intent.EXTRA_STREAM, imageUri)
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, txtShare)
        whatsappIntent.setPackage("com.whatsapp")

        try {
            startActivity(whatsappIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(this, "Whatsapp belum di-install.", Toast.LENGTH_SHORT).show()
        }
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

    fun checkPermissionREAD_EXTERNAL_STORAGE(
        context: Context?
    ): Boolean {
        val currentAPIVersion = Build.VERSION.SDK_INT
        return if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (context?.let {
                    ContextCompat.checkSelfPermission(
                        it,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                } != PackageManager.PERMISSION_GRANTED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        (context as Activity?)!!,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                ) {
                    showDialog(
                        "External storage", context,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                } else {
                    ActivityCompat
                        .requestPermissions(
                            (context as Activity?)!!,
                            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                            MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
                        )
                }
                false
            } else {
                true
            }
        } else {
            true
        }
    }

    private fun showDialog(
        msg: String, context: Context?,
        permission: String
    ) {
        val alertBuilder = Builder(context)
        alertBuilder.setCancelable(true)
        alertBuilder.setTitle("Permission necessary")
        alertBuilder.setMessage("$msg permission is necessary")
        alertBuilder.setPositiveButton(android.R.string.yes,
            DialogInterface.OnClickListener { dialog, _ ->
                ActivityCompat.requestPermissions(
                    (context as Activity?)!!, arrayOf(permission),
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE
                )
            })
        val alert: android.app.AlertDialog? = alertBuilder.create()
        alert?.show()
    }
}