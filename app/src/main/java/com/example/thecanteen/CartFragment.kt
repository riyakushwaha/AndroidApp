package com.example.thecanteen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Transformation
import androidx.annotation.MainThread
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Transformations
import androidx.lifecycle.Transformations.map
import androidx.navigation.findNavController
import androidx.room.FtsOptions
import com.example.thecanteen.database.OrderedItem
import com.example.thecanteen.database.OrderedItemDatabase
import com.example.thecanteen.database.OrderedItemDatabaseDao
import com.example.thecanteen.databinding.FragmentCartBinding
import kotlinx.android.synthetic.main.cart_item_view.*

private lateinit var binding: FragmentCartBinding
class CartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)

        binding.placeorderButton.setOnClickListener{view : View->
            view.findNavController().navigate(CartFragmentDirections.actionCartFragmentToEndFragment())
        }

        var args = CartFragmentArgs.fromBundle(arguments!!)
        binding.tp.text = "Rs. ${args.total}"


        val application = requireNotNull(this.activity).application
        val dataSource = OrderedItemDatabase.getInstance(application).orderedItemDatabaseDao


        val orders =dataSource.getAllOrderedItems()
        val adapter = CartListAdapter()
        binding.cartList.adapter = adapter
        adapter.data = orders

        return binding.root
    }

}












//val args = CartFragmentArgs.fromBundle(arguments!!)
//        binding.item1namebox.text = args.wantedFood
//        val price = "Rs. " + args.foodPrice
//        binding.item1pricebox.text = price
//        binding.totalprice.text = price