package com.example.thecanteen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.thecanteen.databinding.FragmentCartBinding

class CartFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val binding = DataBindingUtil.inflate<FragmentCartBinding>(inflater, R.layout.fragment_cart, container, false)
        binding.placeorderButton.setOnClickListener{view : View->
            view.findNavController().navigate(CartFragmentDirections.actionCartFragmentToEndFragment()) }

        return binding.root
        }

}
