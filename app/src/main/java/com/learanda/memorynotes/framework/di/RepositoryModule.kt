package com.learanda.memorynotes.framework.di

import android.app.Application
import com.learanda.core.repository.NoteRepository
import com.learanda.memorynotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun providesRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}