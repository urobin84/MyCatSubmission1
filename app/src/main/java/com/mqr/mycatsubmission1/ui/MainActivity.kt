package com.mqr.mycatsubmission1.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mqr.mycatsubmission1.R
import com.mqr.mycatsubmission1.adapter.ListCatAdapter
import com.mqr.mycatsubmission1.data.CatData
import com.mqr.mycatsubmission1.model.Cat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var rvCats: RecyclerView
    private var list: ArrayList<Cat> = arrayListOf()
    private var listResult: ArrayList<Cat> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //hide Action Bar
        supportActionBar?.hide()

        btn_About.setOnClickListener(View.OnClickListener {
            goToProfile()
        })

        rvCats = findViewById(R.id.rv_cats)
        rvCats.setHasFixedSize(true)

        dataSearch.addTextChangedListener(textWatcher)

        list.addAll(CatData.listData)
        showRecyclerList(list)
    }

    private fun showRecyclerList(list: ArrayList<Cat>) {
        rvCats.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCatAdapter(list)
        rvCats.adapter = listHeroAdapter
    }

    private fun goToProfile() {
        val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(moveIntent)
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            // not used
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            //not used
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            //output.text = s
            //Toast.makeText(applicationContext, "Maximum Limit Reached "+s.toString(), Toast.LENGTH_SHORT).show()

            listResult.clear()
            for (data in list) {
                if (data.catName.toLowerCase().contains(s.toString().toLowerCase())) {
                    listResult.add(data)
                }
            }
            showRecyclerList(listResultB)
        }


    }


}