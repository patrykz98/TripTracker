package com.example.fragmentdemo

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentdemo.databinding.CardViewBinding
import com.example.fragmentdemo.databinding.FragmentHomeBinding

class RecyclerViewAdapter(
    private val data: List<DataObject>
    ): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private lateinit var binding: CardViewBinding
    private val items: MutableList<CardView>

    init{
        this.items = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvTitle.text = data[position].title

        items.add(holder.cardItem)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder
    internal constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        val tvTitle: TextView = itemView.findViewById(R.id.tvCard)
//        val tvTitle: TextView =
        val cardItem: CardView = itemView.findViewById(R.id.card_item)
    }

}

