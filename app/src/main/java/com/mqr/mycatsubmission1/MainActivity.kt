package com.mqr.mycatsubmission1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvCats: RecyclerView
    private var list: ArrayList<Cat> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_profil){
            goToProfile()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun goToProfile() {
        val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(moveIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Ras Kucing"

        rvCats = findViewById(R.id.rv_cats)
        rvCats.setHasFixedSize(true)

        list.addAll(CatData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCats.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListCatAdapter(list)
        rvCats.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListCatAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Cat) {
                showSelectedCat(data)
            }
        })
    }

    private fun showSelectedCat(cat: Cat) {
        Toast.makeText(this, "Kamu memilih " + cat.id, Toast.LENGTH_SHORT).show()
    }
}