package com.example.thecanteen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CustomizedMenuViewModel: ViewModel() {

    var wantedItem: String =""
    var wantedItemPrice: String =""
    var navigateNow =  MutableLiveData<Boolean>()

    init {
        Log.i("CustomizedMenuViewModel", "CustomizedMenuViewModel created!")
navigateNow.value = false
    }

    data class FoodMenu(
        val text: String,
        val imageResource: Int,
        val price: String
    )

     val fastfood: List<FoodMenu> = listOf(
        FoodMenu(text = "Burger",
            imageResource = R.drawable.burger,
            price = "80"),
        FoodMenu(text = "Sandwich",
            imageResource = R.drawable.sandwich,
            price = "40"),
        FoodMenu(text = "Pasta",
            imageResource = R.drawable.pasta,
            price = "150"),
        FoodMenu(text = "Pizza",
            imageResource = R.drawable.pizza,
            price = "300"),
        FoodMenu(text = "Chilli Potato",
            imageResource = R.drawable.chillipotato,
            price = "80"),
        FoodMenu(text = "Pav Bhaji",
            imageResource = R.drawable.pav,
            price = "100"),
        FoodMenu(text = "Noodles",
            imageResource = R.drawable.chow,
            price = "100"),
        FoodMenu(text = "Macroni",
            imageResource = R.drawable.macroni,
            price = "70"),
         FoodMenu(text = "Spring Roll",
             imageResource = R.drawable.springroll,
             price = "300"),
         FoodMenu(text = "Momos",
             imageResource = R.drawable.momos,
             price = "80")

    )

     val beverage: List<FoodMenu> = listOf(
        FoodMenu(text = "Tea",
            imageResource = R.drawable.tea,
            price = "20"),
        FoodMenu(text = "Coffee",
            imageResource = R.drawable.coffee,
            price = "200"),
        FoodMenu(text = "Mango Juice",
            imageResource = R.drawable.mangojuice,
            price = "150")
    )


    override fun onCleared() {
        super.onCleared()
        Log.i("CustomizedMenuViewModel", "CustomizedMenuViewModel destroyed!")
    }
}