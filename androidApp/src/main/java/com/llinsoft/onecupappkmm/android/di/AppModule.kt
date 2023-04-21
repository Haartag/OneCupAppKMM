package com.llinsoft.onecupappkmm.android.di

import com.llinsoft.onecupappkmm.domain.firebase.ErrorHandler
import com.llinsoft.onecupappkmm.domain.firebase.FirebaseManager
import com.llinsoft.onecupappkmm.domain.firebase.PasswordChecker
import com.llinsoft.onecupappkmm.domain.serialization.Serialization
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseManager(): FirebaseManager {
        return FirebaseManager()
    }

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler {
        return ErrorHandler()
    }

    @Provides
    @Singleton
    fun providePasswordChecker(): PasswordChecker {
        return PasswordChecker()
    }

    @Provides
    @Singleton
    fun provideSerialization(): Serialization {
        return Serialization()
    }

}