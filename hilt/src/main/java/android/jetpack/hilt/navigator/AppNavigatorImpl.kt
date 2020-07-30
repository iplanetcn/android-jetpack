package android.jetpack.hilt.navigator

import android.jetpack.hilt.R
import android.jetpack.hilt.ui.ButtonsFragment
import android.jetpack.hilt.ui.LogsFragment
import androidx.fragment.app.FragmentActivity
import javax.inject.Inject

/**
 * AppNavigatorImpl
 *
 * @author john
 * @since 2020-07-29
 */
class AppNavigatorImpl @Inject constructor(private val activity: FragmentActivity) : AppNavigator {
    override fun navigateTo(screen: Screens) {
        val fragment = when (screen) {
            Screens.BUTTONS -> ButtonsFragment()
            Screens.LOGS -> LogsFragment()
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }

}