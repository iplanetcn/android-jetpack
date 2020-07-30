package android.jetpack.hilt.di

import android.jetpack.hilt.navigator.AppNavigator
import android.jetpack.hilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * NavigationModule
 *
 * @author john
 * @since 2020-07-29
 */
@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}