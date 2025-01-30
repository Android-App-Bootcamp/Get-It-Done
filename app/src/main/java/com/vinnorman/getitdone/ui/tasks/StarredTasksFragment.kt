package com.vinnorman.getitdone.ui.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.vinnorman.getitdone.data.model.Task
import com.vinnorman.getitdone.databinding.FragmentStarredTasksBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class StarredTasksFragment : Fragment(), TasksAdapter.TaskUpdatedListener {

    private lateinit var binding: FragmentStarredTasksBinding
    private val viewModel: StarredTasksViewModel by viewModel()

    private val adapter = TasksAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStarredTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        fetchAllTasks()
    }

    fun fetchAllTasks() {
        lifecycleScope.launch {
            viewModel.starredTasks.collectLatest {
                adapter.setTasks(it)
            }
        }
    }

    override fun onTaskUpdated(task: Task) {
        viewModel.updateTask(task)
    }

}