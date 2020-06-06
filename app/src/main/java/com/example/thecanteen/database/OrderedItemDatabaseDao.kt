package com.example.thecanteen.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.thecanteen.CustomizedMenuViewModel

@Dao
interface OrderedItemDatabaseDao{
    @Insert
    fun insert(orderedItem: OrderedItem)

    @Query("DELETE from ordered_item_table WHERE name_of_tem = :key")
   fun deleteItem(key: String)

    @Query("SELECT * from ordered_item_table WHERE name_of_tem = :key")
    fun findItem(key: String): Boolean

    @Query("DELETE FROM ordered_item_table")
   fun clear()

    @Query("SELECT * FROM ordered_item_table")
   fun getAllOrderedItems(): List<OrderedItem>
}