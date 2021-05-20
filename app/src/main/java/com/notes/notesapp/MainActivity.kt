package com.notes.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), IAdaptor {

    private lateinit var adaptor: NoteAdaptor
    private lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adaptor = NoteAdaptor(this)
        recyclerView.adapter = adaptor

        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {
            adaptor.updateData(it)
        })
    }

    fun noteAdd(view: View) {
        val intent = Intent(this,AddNoteActivity::class.java)
        startActivity(intent)
    }

    override fun onItemClick(note: Notes) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text} deleted",Toast.LENGTH_LONG).show()
    }
}