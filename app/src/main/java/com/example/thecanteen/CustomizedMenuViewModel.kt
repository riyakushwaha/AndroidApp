package com.example.thecanteen

import android.util.Log
import androidx.lifecycle.ViewModel

class CustomizedMenuViewModel: ViewModel() {

    init {
        Log.i("CustomizedMenuViewModel", "CustomizedMenuViewModel created!")
    }

    data class FoodMenu(
        val text: String,
        val imageResource: Int,
        val price: String
    )

     val junkfood: List<FoodMenu> = listOf(
        FoodMenu(text = "Burger",
            imageResource = R.drawable.icon,
            price = "Rs. 80"),
        FoodMenu(text = "Sandwich",
            imageResource = R.drawable.icon,
            price = "Rs. 40"),
        FoodMenu(text = "Pasta",
            imageResource = R.drawable.junkfood,
            price = "Rs. 150"),
        FoodMenu(text = "Pizza",
            imageResource = R.drawable.iconwithoutbg,
            price = "Rs. 300"),
        FoodMenu(text = "Chilli Potato",
            imageResource = R.drawable.icon,
            price = "Rs. 80"),
        FoodMenu(text = "Pav Bhaji",
            imageResource = R.drawable.icon,
            price = "Rs. 100"),
        FoodMenu(text = "Noodles",
            imageResource = R.drawable.icon,
            price = "Rs. 100"),
        FoodMenu(text = "French Fries",
            imageResource = R.drawable.icon,
            price = "Rs. 70")
    )

     val drinkss: List<FoodMenu> = listOf(
        FoodMenu(text = "Tea",
            imageResource = R.drawable.icon,
            price = "Rs. 20"),
        FoodMenu(text = "Espresso Martini",
            imageResource = R.drawable.icon,
            price = "Rs. 200"),
        FoodMenu(text = "Pasta",
            imageResource = R.drawable.junkfood,
            price = "Rs. 150"),
        FoodMenu(text = "Pizza",
            imageResource = R.drawable.iconwithoutbg,
            price = "Rs. 300"),
        FoodMenu(text = "Chilli Potato",
            imageResource = R.drawable.icon,
            price = "Rs. 80"),
        FoodMenu(text = "Pav Bhaji",
            imageResource = R.drawable.icon,
            price = "Rs. 100"),
        FoodMenu(text = "Noodles",
            imageResource = R.drawable.icon,
            price = "Rs. 100"),
        FoodMenu(text = "French Fries",
            imageResource = R.drawable.icon,
            price = "Rs. 70")
    )


    override fun onCleared() {
        super.onCleared()
        Log.i("CustomizedMenuViewModel", "CustomizedMenuViewModel destroyed!")
    }
}