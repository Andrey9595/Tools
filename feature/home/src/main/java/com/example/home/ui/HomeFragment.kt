package com.example.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.adapterdelegates.CompositeAdapter
import com.example.cloudservice.CloudServiceImpl
import com.example.cloudservice.ProvideDatabase
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.ui.model.ToolsGroupModel
import kotlinx.coroutines.launch
import ru.anb.core.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cloudService = CloudServiceImpl(ProvideDatabase.Base(requireActivity().application))
        val flow = cloudService.subscribeToListOf(ToolsGroupModel::class.java, "groups")
        val adapter = CompositeAdapter.Builder()
            .addDelegate(ToolsGroupDelegate())
            .build()
        binding.toolsList.adapter = adapter
        viewLifecycleOwner.lifecycleScope.launch {
            flow.collect() {
                adapter.submitList(it)
            }
        }
    }
}