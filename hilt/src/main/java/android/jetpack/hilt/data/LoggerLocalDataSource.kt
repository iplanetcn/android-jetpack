package android.jetpack.hilt.data

import android.os.Handler
import android.os.Looper
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject

/**
 * LoggerLocalDataSource
 *
 * @author john
 * @since 2020-07-29
 */
class LoggerLocalDataSource @Inject constructor(private val logDao: LogDao) : LoggerDataSource {
    private val executorService: ExecutorService = Executors.newFixedThreadPool(4)
    private val mainThreadHandler by lazy { Handler(Looper.getMainLooper()) }

    override fun addLog(msg: String) {
        executorService.execute {
            logDao.insertAll(Log(msg, System.currentTimeMillis()))
        }
    }

    override fun getAllLogs(callback: (List<Log>) -> Unit) {
       executorService.execute {
           val logs = logDao.getAll()
           mainThreadHandler.post{ callback(logs) }
       }
    }

    override fun removeLogs() {
        executorService.execute {
            logDao.nukeTable()
        }
    }
}