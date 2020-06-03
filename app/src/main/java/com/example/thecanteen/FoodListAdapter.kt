package com.example.thecanteen

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodListAdapter(private val data: List<CustomizedMenuViewModel.FoodMenu>, var clickListener: onFoodItemClickListener): RecyclerView.Adapter<FoodListAdapter.ViewHolder>() {

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//      val item = data[position]
//        holder.name.text = item.text
//        holder.price.text = item.price
//        holder.image.setImageResource(item.imageResource)
        holder.initialize(data.get(position), clickListener, holder)

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

        fun initialize(item: CustomizedMenuViewModel.FoodMenu, action: onFoodItemClickListener, holder: ViewHolder){
            name.text = item.text
            price.text = "Rs. "+item.price
            image.setImageResource(item.imageResource)

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition, holder)
            }
        }

    }

    interface onFoodItemClickListener{
      fun onItemClick(item: CustomizedMenuViewModel.FoodMenu, position: Int, holder:ViewHolder )

    }


}