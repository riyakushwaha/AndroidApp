package com.example.thecanteen

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.thecanteen.databinding.FragmentCustomizedMenuBinding
import com.example.thecanteen.CustomizedMenuFragment as CustomizedMenuFragment1

private lateinit var binding: FragmentCustomizedMenuBinding

class CustomizedMenuFragment : Fragment(), FoodListAdapter.onFoodItemClickListener{

    private lateinit var viewModel: CustomizedMenuViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    binding = DataBindingUtil.inflate(inflater, R.layout.fragment_customized_menu, container, false)
    binding.viewcartButton.setOnClickListener{view: View ->
        view.findNavController().navigate(CustomizedMenuFragmentDirections.actionCustomizedMenuFragmentToCartFragment(
            viewModel.wantedItem, viewModel.wantedItemPrice
        )) }

    val args = CustomizedMenuFragmentArgs.fromBundle(arguments!!)
//    Toast.makeText(context, "FoodType: ${args.foodtype}", Toast.LENGTH_SHORT).show()
        Toast.makeText(context, "For now, you can select only one item.", Toast.LENGTH_LONG).show()

    viewModel =  ViewModelProviders.of(this).get(CustomizedMenuViewModel::class.java)

    if(args.foodtype==="fastfood")
    {
        val adapter = FoodListAdapter(viewModel.fastfood, this)
        binding.foodList.adapter =  adapter
    }
    else if(args.foodtype==="beverage")
    {
        val adapter = FoodListAdapter(viewModel.beverage, this)
        binding.foodList.adapter =  adapter
    }

    return binding.root
    }


    override fun onItemClick(item: CustomizedMenuViewModel.FoodMenu, position: Int, holder: FoodListAdapter.ViewHolder) {
    viewModel.wantedItem = item.text
        viewModel.wantedItemPrice = item.price
        holder.itemView.setBackgroundColor(Color.parseColor("#f7f7f7"))
    }

}