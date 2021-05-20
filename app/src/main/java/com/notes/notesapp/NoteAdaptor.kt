package com.notes.notesapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class NoteAdaptor(private val listener:IAdaptor) : RecyclerView.Adapter<NoteAdaptor.NoteViewHolder>() {

    private val allNotes = ArrayList<Notes>()

    class NoteViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val textView : TextView = itemView.findViewById(R.id.text)
        val deleteButton : ImageView = itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        val viewHolder = NoteViewHolder(view)
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClick(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = allNotes[position]
        holder.textView.text = currentItem.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateData(newData : List<Notes>){
        allNotes.clear()
        allNotes.addAll(newData)
        notifyDataSetChanged()
    }
}

interface IAdaptor{
    fun onItemClick(note : Notes)
}