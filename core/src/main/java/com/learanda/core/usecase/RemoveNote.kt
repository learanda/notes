package com.learanda.core.usecase

import com.learanda.core.data.Note
import com.learanda.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.removeNote(note)
}