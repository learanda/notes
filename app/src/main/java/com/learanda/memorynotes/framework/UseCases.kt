package com.learanda.memorynotes.framework

import com.learanda.core.usecase.AddNote
import com.learanda.core.usecase.GetAllNotes
import com.learanda.core.usecase.GetNote
import com.learanda.core.usecase.RemoveNote

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)
