package android.jetpack.hilt.navigator

/**
 * AppNavigator
 *
 * @author john
 * @since 2020-07-29
 */

enum class Screens {
    BUTTONS,
    LOGS
}

interface AppNavigator {
    fun navigateTo(screens: Screens)
}