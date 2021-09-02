package com.example.chocolatefactory.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chocolatefactory.R
import com.example.chocolatefactory.common.basicDiffUtil
import com.example.chocolatefactory.common.inflate
import com.example.chocolatefactory.common.loadUrl
import com.example.chocolatefactory.databinding.WorkerItemBinding
import com.example.chocolatefactory.domain.OmpaWorker

class WorkersAdapter(private val listener: (OmpaWorker) -> Unit) :
    RecyclerView.Adapter<WorkersAdapter.ViewHolder>() {

    var workers: List<OmpaWorker> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.worker_item, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = workers[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener(movie) }
    }

    override fun getItemCount(): Int = workers.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = WorkerItemBinding.bind(view)
        fun bind(worker: OmpaWorker) = with(binding) {
            tvFirstName.text = worker.firstName
            tvLastName.text = worker.lastName
            tvGender.text = worker.gender
            ivWorker.loadUrl(worker.image)
        }
    }

}