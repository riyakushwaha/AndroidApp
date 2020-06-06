package com.example.thecanteen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.thecanteen.database.OrderedItem

class CartListAdapter(): RecyclerView.Adapter<CartListAdapter.ViewHolder>() {

    var data =  listOf<OrderedItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.cart_item_view, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    val name: TextView  = itemView.findViewById(R.id.itemnamebox)
    val cost: TextView = itemView.findViewById(R.id.itempricebox)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = data[position]
       holder.name.text = item.name_of_item
        holder.cost.text = "Rs. "+ item.price_of_item

    }

    }


