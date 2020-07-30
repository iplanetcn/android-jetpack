package android.jetpack.hilt.ui

import android.jetpack.hilt.data.LoggerDataSource
import android.jetpack.hilt.data.LoggerLocalDataSource
import android.jetpack.hilt.databinding.FragmentButtonsBinding
import android.jetpack.hilt.di.DatabaseLogger
import android.jetpack.hilt.di.InMemoryLogger
import android.jetpack.hilt.navigator.AppNavigator
import android.jetpack.hilt.navigator.Screens
import android.jetpack.hilt.util.DateFormatter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.logging.Logger
import javax.inject.Inject

/**
 * ButtonsFragment
 *
 * @author john
 * @since 2020-07-29
 */
@AndroidEntryPoint
class ButtonsFragment : Fragment() {
    private var _binding: FragmentButtonsBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    @DatabaseLogger
    @Inject lateinit var logger: LoggerDataSource
    @Inject lateinit var navigator: AppNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentButtonsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.button1.setOnClickListener {
            logger.addLog("Interaction with 'Button 1'")
        }

        binding.button2.setOnClickListener {
            logger.addLog("Interaction with 'Button 2'")
        }

        binding.button3.setOnClickListener {
            logger.addLog("Interaction with 'Button 3'")
        }

        binding.allLogs.setOnClickListener {
            navigator.navigateTo(Screens.LOGS)
        }

        binding.deleteLogs.setOnClickListener {
            logger.removeLogs()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}