package android.jetpack.hilt.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Log
 *
 * @author john
 * @since 2020-07-29
 */
@Entity(tableName = "logs")
data class Log(val msg: String, val timestamp: Long) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}