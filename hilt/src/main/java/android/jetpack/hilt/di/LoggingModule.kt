package android.jetpack.hilt.di

import android.jetpack.hilt.data.LoggerDataSource
import android.jetpack.hilt.data.LoggerInMemoryDataSource
import android.jetpack.hilt.data.LoggerLocalDataSource
import androidx.room.Query
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import java.util.logging.Logger
import javax.inject.Qualifier
import javax.inject.Singleton

/**
 * LoggingModule
 *
 * @author john
 * @since 2020-07-29
 */
@Qualifier
annotation class InMemoryLogger

@Qualifier
annotation class DatabaseLogger

@InstallIn(ApplicationComponent::class)
@Module
abstract class LoggingDatabaseModule {
    @DatabaseLogger
    @Singleton
    @Binds
    abstract fun bindDatabaseLogger(impl: LoggerLocalDataSource) : LoggerDataSource
}

@InstallIn(ActivityComponent::class)
@Module
abstract class LoggingInMemoryModule {
    @InMemoryLogger
    @ActivityScoped
    @Binds
    abstract fun bindInMemoryLogger(impl: LoggerInMemoryDataSource) : LoggerDataSource
}