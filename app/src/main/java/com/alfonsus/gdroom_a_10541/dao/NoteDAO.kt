package com.alfonsus.gdroom_a_10541.dao

import androidx.room.*
import com.alfonsus.gdroom_a_10541.entity.Note

@Dao
interface NoteDAO {

    @Insert
    suspend fun addNote(note : Note)

    @Update
    suspend fun updateNode(note : Note)

    @Delete
    suspend fun deleteNote(note : Note)

    @Query("Select * From note")
    suspend fun getNotes() : List<Note>

    @Query("Select * From note WHERE id =:note_id")
    suspend fun getNote(note_id:Int) : List<Note>

}