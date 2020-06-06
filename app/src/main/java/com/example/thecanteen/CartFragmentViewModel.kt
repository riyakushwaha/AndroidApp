package com.example.thecanteen

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.thecanteen.database.OrderedItem
import com.example.thecanteen.database.OrderedItemDatabaseDao
import kotlinx.coroutines.*


class CartFragmentViewModel( dataSource: OrderedItemDatabaseDao,
                            application: Application): AndroidViewModel(application) {
    val database = dataSource
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var orders = database.getAllOrderedItems()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
        Log.i("CustomizedMenuViewModel", "CustomizedMenuViewModel destroyed!")
    }
}