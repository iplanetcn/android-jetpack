package android.jetpack.hilt.di

import android.content.Context
import android.jetpack.hilt.data.AppDataBase
import android.jetpack.hilt.data.LogDao
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * DataBaseModule
 *
 * @author john
 * @since 2020-07-29
 */
@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) : AppDataBase {
        return Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "logging.db"
        ).build()
    }

    @Provides
    fun provideLogDao(database:  AppDataBase): LogDao {
        return database.logDao()
    }
}