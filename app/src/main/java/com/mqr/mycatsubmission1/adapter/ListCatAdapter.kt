package com.mqr.mycatsubmission1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mqr.mycatsubmission1.R
import com.mqr.mycatsubmission1.model.Cat
import com.mqr.mycatsubmission1.ui.DetailActivity
import com.mqr.mycatsubmission1.ui.MainActivity


class ListCatAdapter(val listCat: ArrayList<Cat>) : RecyclerView.Adapter<ListCatAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var idCat: TextView = itemView.findViewById(R.id.tv_item_id)
        var CreatedCat: TextView = itemView.findViewById(R.id.tv_item_created)
        var image: ImageView = itemView.findViewById(R.id.img_item_photo)
        var rootItem: LinearLayout = itemView.findViewById(R.id.root_item)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.item_row_cat,
            viewGroup,
            false
        )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val cat = listCat[position]
        val mContext = holder.itemView.context

        Glide.with(holder.itemView.context)
            .load(cat.image)
            .apply(RequestOptions().override(78, 78))
            .into(holder.image)
        holder.idCat.text = cat.catName
        holder.CreatedCat.text = cat.description

        holder.rootItem.setOnClickListener(View.OnClickListener {
            val details = cat
            val i = Intent(mContext, DetailActivity::class.java)
            i.putExtra("detail", details)
            mContext.startActivity(i)
        })
    }

    override fun getItemCount(): Int {
        return listCat.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Cat)
    }

}