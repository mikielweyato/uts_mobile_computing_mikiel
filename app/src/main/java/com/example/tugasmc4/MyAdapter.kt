package com.example.tugasmc4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter (private  val  namaList : ArrayList<ItemData>) :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private lateinit var mListener: onItemClickListener

    interface  onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }
    class MyViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val gambar : ImageView = itemView.findViewById(R.id.img_item_photo)
        val judul : TextView = itemView.findViewById(R.id.tv_jdl)
        val harga : TextView = itemView.findViewById(R.id.harga)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_data,parent, false)
       return MyViewHolder(itemView, mListener)

    }

    override fun getItemCount(): Int {
    return namaList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = namaList[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.judul.text = currentItem.judul
        holder.harga.text = currentItem.hrg


    }
}