package com.notes.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class AddNoteActivity : AppCompatActivity() {

    private lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        val btn : Button = findViewById(R.id.addNote)
        btn.setOnClickListener{
            getNoteAdded()
        }
    }

    private fun getNoteAdded(){
        val editText : EditText = findViewById(R.id.input)
        val note = editText.text.toString()
        val intent = Intent(this@AddNoteActivity,MainActivity::class.java)
        if(note.isNotEmpty()){
            viewModel.insertNote(Notes(note))
            startActivity(intent)
            Toast.makeText(this,"$note added",Toast.LENGTH_LONG).show()
        }
    }
}