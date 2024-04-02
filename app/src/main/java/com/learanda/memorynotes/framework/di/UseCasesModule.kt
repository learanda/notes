package com.learanda.memorynotes.framework.di

import com.learanda.core.repository.NoteRepository
import com.learanda.core.usecase.AddNote
import com.learanda.core.usecase.GetAllNotes
import com.learanda.core.usecase.GetNote
import com.learanda.core.usecase.GetWordCount
import com.learanda.core.usecase.RemoveNote
import com.learanda.memorynotes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}