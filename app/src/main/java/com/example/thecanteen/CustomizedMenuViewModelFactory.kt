package com.example.thecanteen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.thecanteen.database.OrderedItemDatabaseDao
import javax.sql.DataSource

class CustomizedMenuViewModelFactory(private val foodtype: String,
    private val dataSource: OrderedItemDatabaseDao,
                                     private val application: Application
                                     ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CustomizedMenuViewModel::class.java)) {
            return CustomizedMenuViewModel(foodtype, dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


