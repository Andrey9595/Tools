package com.example.home.ui

import android.widget.Toast
import com.example.adapterdelegates.CompositeAdapter
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.ui.model.ToolsGroupUiModel
import ru.anb.core.UiState

interface HomeUiState : UiState<FragmentHomeBinding> {

    class Initial : HomeUiState {
        override fun update(binding: FragmentHomeBinding) = Unit

    }

    class Success(private val data: List<ToolsGroupUiModel>) : HomeUiState {
        override fun update(binding: FragmentHomeBinding) {
//            binding.progressbar.root.visibility = View.INVISIBLE
            (binding.toolsList.adapter as CompositeAdapter).submitList(data)
        }
    }

    class Loading : HomeUiState {
        override fun update(binding: FragmentHomeBinding) {
//            binding.progressbar.root.visibility = View.VISIBLE
        }
    }

    class Error(private val message: String) : HomeUiState {
        override fun update(binding: FragmentHomeBinding) {
//            binding.progressbar.root.visibility = View.INVISIBLE
            Toast.makeText(binding.root.context, message, Toast.LENGTH_SHORT).show()
        }
    }
}