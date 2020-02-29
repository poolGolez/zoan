package com.example.zoan.loan.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Loan::class], version = 1, exportSchema = false)
abstract class ZoanDatabase : RoomDatabase() {

    abstract val loanDatabaseDao: LoanDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: ZoanDatabase? = null

        fun getInstance(context: Context): ZoanDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ZoanDatabase::class.java,
                        "zoan_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}