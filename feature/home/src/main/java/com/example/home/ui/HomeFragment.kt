package com.example.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.adapterdelegates.CompositeAdapter
import com.example.home.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.anb.core.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    private val viewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CompositeAdapter.Builder()
            .addDelegate(ToolsGroupDelegate())
            .build()
        binding.toolsList.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.collect {
                    it.update(binding)
                }
            }
        }

    }
}