package android.jetpack.hilt.data

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * LogDao
 *
 * @author john
 * @since 2020-07-29
 */
@Dao
interface LogDao {

    @Query("select * from logs order by id desc")
    fun getAll(): List<Log>

    @Insert
    fun insertAll(vararg logs: Log)

    @Query("delete from logs")
    fun nukeTable()

    @Query("select * from logs order by id desc")
    fun selectAllLogsCursor(): Cursor

    @Query("select * from logs where id = :id")
    fun selectLogById(id: Long): Cursor?
}