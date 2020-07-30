package android.jetpack.hilt.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter
import javax.inject.Inject

/**
 * DateFormatter
 *
 * @author john
 * @since 2020-07-29
 */
class DateFormatter @Inject constructor() {
    private val formatter = SimpleDateFormat("yyyy-MMM-dd HH:mm:ss", Locale.CHINESE)

    fun formatDate(timestamp: Long): String {
        return formatter.format(Date(timestamp))
    }
}