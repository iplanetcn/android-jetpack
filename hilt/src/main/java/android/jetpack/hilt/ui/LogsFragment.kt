package android.jetpack.hilt.ui

import android.annotation.SuppressLint
import android.jetpack.hilt.R
import android.jetpack.hilt.data.Log
import android.jetpack.hilt.data.LoggerDataSource
import android.jetpack.hilt.databinding.FragmentLogsBinding
import android.jetpack.hilt.di.DatabaseLogger
import android.jetpack.hilt.di.InMemoryLogger
import android.jetpack.hilt.util.DateFormatter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * ButtonsFragment
 *
 * @author john
 * @since 2020-07-29
 */
@AndroidEntryPoint
class LogsFragment : Fragment() {
    private var _binding: FragmentLogsBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    @DatabaseLogger
    @Inject
    lateinit var logger: LoggerDataSource

    @Inject
    lateinit var dateFormatter: DateFormatter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLogsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    override fun onResume() {
        super.onResume()

        logger.getAllLogs { logs ->
            binding.recyclerView.adapter = LogsViewAdapter(logs, dateFormatter)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/**
 * RecyclerView adapter for the logs list.
 */
private class LogsViewAdapter(
    private val logsDataSet: List<Log>,
    private val daterFormatter: DateFormatter
) : RecyclerView.Adapter<LogsViewAdapter.LogsViewHolder>() {

    class LogsViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        return LogsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.text_row_item, parent, false) as TextView
        )
    }

    override fun getItemCount(): Int {
        return logsDataSet.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        val log = logsDataSet[position]
        holder.textView.text = "${log.msg}\n\t${daterFormatter.formatDate(log.timestamp)}"
    }
}
