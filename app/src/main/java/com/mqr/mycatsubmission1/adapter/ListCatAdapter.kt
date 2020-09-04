package com.mqr.mycatsubmission1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mqr.mycatsubmission1.model.Cat
import com.mqr.mycatsubmission1.R

class ListCatAdapter(val listCat: ArrayList<Cat>) : RecyclerView.Adapter<ListCatAdapter.ListViewHolder>(){

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var idCat: TextView = itemView.findViewById(R.id.tv_item_id)
        var CreatedCat: TextView = itemView.findViewById(R.id.tv_item_created)
        var image: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_cat, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val cat = listCat[position]
        Glide.with(holder.itemView.context)
            .load(cat.image)
            .apply(RequestOptions().override(55, 55))
            .into(holder.image)
        holder.idCat.text = cat.catName
        holder.CreatedCat.text = cat.description

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listCat[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listCat.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Cat)
    }

}