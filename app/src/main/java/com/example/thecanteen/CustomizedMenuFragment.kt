package com.example.thecanteen

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.thecanteen.database.OrderedItem
import com.example.thecanteen.database.OrderedItemDatabase
import com.example.thecanteen.databinding.FragmentCustomizedMenuBinding

private lateinit var binding: FragmentCustomizedMenuBinding
private lateinit var viewModel: CustomizedMenuViewModel
private lateinit var viewModelFactory: CustomizedMenuViewModelFactory
class CustomizedMenuFragment : Fragment(), FoodListAdapter.onFoodItemClickListener{

    var sum : Int =0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_customized_menu, container, false)

//        binding.viewcartButton.setOnClickListener{view: View ->
//            view.findNavController().navigate(CustomizedMenuFragmentDirections.actionCustomizedMenuFragmentToCartFragment()) }

        binding.viewcartButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER"){
            view: View->
            if(sum===0){
                view.findNavController().navigate(CustomizedMenuFragmentDirections.actionCustomizedMenuFragmentToNothingSelectedFragment())
            }
            else{
                view.findNavController().navigate(CustomizedMenuFragmentDirections.actionCustomizedMenuFragmentToCartFragment(sum))
            }
        }


        val application = requireNotNull(this.activity).application
        val dataSource = OrderedItemDatabase.getInstance(application).orderedItemDatabaseDao
        viewModelFactory = CustomizedMenuViewModelFactory((CustomizedMenuFragmentArgs.fromBundle(arguments!!).foodtype), dataSource, application)
        viewModel =  ViewModelProviders.of(this, viewModelFactory).get(CustomizedMenuViewModel::class.java)

        viewModel.onClear()
//        Toast.makeText(context, "For now, you can select only one item.", Toast.LENGTH_LONG).show()

        if(viewModel.foodType==="fastfood")
        {
            val adapter = FoodListAdapter(viewModel.fastfood, this)
            binding.foodList.adapter =  adapter
        }

        else if(viewModel.foodType==="beverage")
        {
            val adapter = FoodListAdapter(viewModel.beverage, this)
            binding.foodList.adapter =  adapter
        }

        return binding.root
    }


    override fun onItemClick(item: CustomizedMenuViewModel.FoodMenu, position: Int, holder: FoodListAdapter.ViewHolder) {
        viewModel.wantedItem = item.text
        viewModel.wantedItemPrice = item.price
        sum += item.price.toInt()
        val newOrder = OrderedItem(position ,item.text, item.price)
        holder.itemView.setBackgroundColor(Color.parseColor("#f7f7f7"))
        viewModel.addItem(newOrder)


    }

}