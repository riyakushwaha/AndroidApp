package com.example.thecanteen


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.thecanteen.database.OrderedItem
import com.example.thecanteen.database.OrderedItemDatabaseDao
import kotlinx.coroutines.*


class CustomizedMenuViewModel(foodtype: String, dataSource: OrderedItemDatabaseDao,
                        application: Application): AndroidViewModel(application) {

    var foodType = foodtype
    val database = dataSource
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

     fun addItem(newOrder: OrderedItem){
        uiScope.launch {
            insert(newOrder)
        }
    }

    private suspend fun insert(order: OrderedItem){
        withContext(Dispatchers.IO){
            database.insert(order)
            Log.i("Database", "ItemAdded")
        }
    }

    fun onClear(){
        uiScope.launch {
            clear()
        }
    }

    private suspend fun clear(){
        withContext(Dispatchers.IO){
            database.clear()
            Log.i("Database", "All values deleted")
        }
    }
//    fun findItem(key: String): Boolean{
//        var entryfound :Boolean = false
//        uiScope.launch{
//            entryfound = findItemInDataBase(key)
//        }
//        return entryfound
//    }
//
//    private suspend fun findItemInDataBase(key: String): Boolean{
//        var entry:Boolean = false
//        withContext(Dispatchers.IO){
//            entry  = database.findItem(key)
//            Log.i("Database", "Finding Item in Database")
//        }
//        return entry
//    }
//
//    fun deleteItem(key: String){
//        uiScope.launch {
//           delete(key)
//        }
//    }
//
//    private suspend fun delete(key: String){
//        withContext(Dispatchers.IO){
//            database.deleteItem(key)
//            Log.i("Database", "ItemDeleted")
//        }
//    }

    ///////////////////////////////////////////////////////////////////////
    var wantedItem: String =""
    var wantedItemPrice: String =""

    init {
        Log.i("CustomizedMenuViewModel", "CustomizedMenuViewModel created!")
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
        viewModelJob.cancel()
        Log.i("database", "job cancelled!")
    }


}