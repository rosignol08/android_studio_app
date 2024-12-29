package com.example.projet_johnny

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TimelineAdapter(
    private val events: List<TimelineEvent>,
    private val onItemClick: (TimelineEvent) -> Unit
) : RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder>() {

    class TimelineViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dateTextView: TextView = view.findViewById(R.id.event_date)
        val titleTextView: TextView = view.findViewById(R.id.event_title)
        val descriptionTextView: TextView = view.findViewById(R.id.event_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimelineViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.timeline_item, parent, false)
        return TimelineViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimelineViewHolder, position: Int) {
        val event = events[position]
        holder.dateTextView.text = event.date
        holder.titleTextView.text = event.title
        holder.descriptionTextView.text = event.description

        holder.itemView.setOnClickListener { onItemClick(event) }
    }

    override fun getItemCount(): Int = events.size
}
