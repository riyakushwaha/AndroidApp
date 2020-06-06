package com.example.thecanteen.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [OrderedItem:: class], version =  2, exportSchema = false)
abstract class OrderedItemDatabase: RoomDatabase(){

    abstract val orderedItemDatabaseDao: OrderedItemDatabaseDao

   companion object{
       @Volatile
       private var INSTANCE: OrderedItemDatabase? = null
       fun getInstance(context: Context): OrderedItemDatabase{
           synchronized(this) {
               var instance = INSTANCE
               if (instance == null) {
                   instance = Room.databaseBuilder(
                       context.applicationContext,
                       OrderedItemDatabase:: class.java,
                   "order_database"
                   ).allowMainThreadQueries().build()
                   INSTANCE = instance
               }
return instance
           }
   }
}
}