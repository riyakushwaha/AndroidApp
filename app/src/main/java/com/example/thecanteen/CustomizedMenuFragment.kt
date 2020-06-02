package com.example.thecanteen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.thecanteen.databinding.FragmentCustomizedMenuBinding

class CustomizedMenuFragment : Fragment(){

    private lateinit var viewModel: CustomizedMenuViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    val binding = DataBindingUtil.inflate<FragmentCustomizedMenuBinding>(inflater, R.layout.fragment_customized_menu, container, false)
    binding.viewcartButton.setOnClickListener{view: View ->
        view.findNavController().navigate(R.id.action_customizedMenuFragment_to_cartFragment) }

    val args = CustomizedMenuFragmentArgs.fromBundle(arguments!!)
    Toast.makeText(context, "FoodType: ${args.foodtype}", Toast.LENGTH_SHORT).show()

    viewModel =  ViewModelProviders.of(this).get(CustomizedMenuViewModel::class.java)

    if(args.foodtype==="junkfood")
    {
        val adapter = FoodListAdapter(viewModel.junkfood)
        binding.foodList.adapter =  adapter
    }
    else if(args.foodtype==="drinks")
    {
        val adapter = FoodListAdapter(viewModel.drinkss)
        binding.foodList.adapter =  adapter
    }

    return binding.root
    }



}