package com.vinnorman.getitdone.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.vinnorman.getitdone.R
import com.vinnorman.getitdone.data.model.Task
import com.vinnorman.getitdone.databinding.ActivityMainBinding
import com.vinnorman.getitdone.databinding.DialogAddTaskBinding
import com.vinnorman.getitdone.ui.components.TabButton
import com.vinnorman.getitdone.ui.tasks.TasksFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setupViewPager(tabs, pager)
            fab.setOnClickListener { showAddTaskDialog() }
            setContentView(root)
        }
    }

    private fun setupViewPager(tabs: TabLayout, pager: ViewPager2) {
        pager.adapter = PagerAdapter(this@MainActivity)
        TabLayoutMediator(tabs, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.icon_star_filled)
                }

                pager.adapter!!.itemCount - 1 -> {
                    tab.customView = TabButton(this).apply {
                        text = "Add List"
                        setIconResource(R.drawable.icon_add)
                        setTextColor(ContextCompat.getColor(context, R.color.black))
                    }
                }

                else -> {
                    tab.text = "Tasks"
                }
            }

        }.attach()
    }

    private fun showAddTaskDialog() {
        DialogAddTaskBinding.inflate(layoutInflater).apply {
            val dialog = BottomSheetDialog(this@MainActivity)
            dialog.setContentView(root)

            buttonShowDetails.setOnClickListener {
                editTextTaskDetails.visibility =
                    if (editTextTaskDetails.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            }

            buttonSave.setOnClickListener {
                val task = Task(
                    title = editTextTaskTitle.text.toString(),
                    description = editTextTaskDetails.text.toString()
                )
                viewModel.createTask(task)
                dialog.dismiss()
            }

            dialog.show()
        }
    }

    inner class PagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

        override fun getItemCount() = 3

        override fun createFragment(position: Int): Fragment {
            return TasksFragment()
        }

    }

}