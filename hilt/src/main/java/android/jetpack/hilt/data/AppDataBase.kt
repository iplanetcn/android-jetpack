package android.jetpack.hilt.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * AppDataBase
 *
 * @author john
 * @since 2020-07-29
 */
@Database(entities = arrayOf(Log::class), version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun logDao() : LogDao
}