package com.learanda.memorynotes.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learanda.memorynotes.R
import com.learanda.memorynotes.framework.ListViewModel

class ListFragment : Fragment() {

    private lateinit var addNote: View
    private lateinit var notesListView: RecyclerView
    private lateinit var loadingView: ProgressBar
    private val notesListAdapter = NotesListAdapter(arrayListOf())
    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNote = requireView().findViewById(R.id.addNote)
        notesListView = requireView().findViewById(R.id.notesListView)
        loadingView = requireView().findViewById(R.id.loadingView)
        notesListView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notesListAdapter
        }

        addNote.setOnClickListener { goToNoteDetails() }

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.notes.observe(viewLifecycleOwner, Observer {notesList ->
            loadingView.visibility = View.GONE
            notesListView.visibility = View.VISIBLE
            notesListAdapter.updatesNotes(notesList.sortedByDescending { it.updateTime })
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }

    private fun goToNoteDetails(id: Long = 0L) {
        val action = ListFragmentDirections.actionGoToNote().setNoteId(id)
        findNavController(notesListView).navigate(action)
    }
}
