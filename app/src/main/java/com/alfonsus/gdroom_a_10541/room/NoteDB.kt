package com.alfonsus.gdroom_a_10541.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alfonsus.gdroom_a_10541.dao.NoteDAO
import com.alfonsus.gdroom_a_10541.entity.Note
import java.util.*

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDB: RoomDatabase() {
    abstract fun noteDAO() : NoteDAO

    companion object{

        @Volatile private  var instance : NoteDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?:
        synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDB::class.java,"note12345.db"
        ).build()
    }
}