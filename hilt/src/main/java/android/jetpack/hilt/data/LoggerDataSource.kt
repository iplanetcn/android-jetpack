package android.jetpack.hilt.data


/**
 * LoggerDataSource
 *
 * @author john
 * @since 2020-07-29
 */
interface LoggerDataSource {
    fun addLog(msg: String)
    fun getAllLogs(callback: (List<Log>) -> Unit)
    fun removeLogs()
}