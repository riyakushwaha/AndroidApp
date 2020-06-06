package com.example.thecanteen.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ordered_item_table")
data class OrderedItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="order_of_item")
    var order_of_item: Int,

    @ColumnInfo(name = "name_of_tem")
    var name_of_item: String,

    @ColumnInfo(name = "price_of_item")
    var price_of_item: String
)