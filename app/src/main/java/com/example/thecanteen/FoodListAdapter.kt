package com.example.thecanteen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodListAdapter(private val data: List<CustomizedMenuViewModel.FoodMenu>): RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.name.text = item.text
        holder.price.text = item.price
        holder.image.setImageResource(item.imageResource)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.food_list_view, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView  = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)
        val image : ImageView =  itemView.findViewById(R.id.quality_image)
    }

    interface onItemClickListener{
      fun onClick(item: CustomizedMenuViewModel.FoodMenu, position: Int )
    }


}