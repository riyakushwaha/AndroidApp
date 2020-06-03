package com.example.thecanteen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.thecanteen.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(
            inflater, R.layout.fragment_menu, container, false)
        
        binding.junkfoodButton.setOnClickListener{view: View ->
            view.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToCustomizedMenuFragment("fastfood"))

        }

        binding.drinksButton.setOnClickListener{view: View ->
        view.findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToCustomizedMenuFragment("beverage"))}
        return binding.root
    }


}