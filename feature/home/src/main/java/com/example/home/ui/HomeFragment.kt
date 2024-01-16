package com.example.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.adapterdelegates.CompositeAdapter
import com.example.home.databinding.FragmentHomeBinding
import com.example.home.ui.model.ToolsGroupModel
import ru.anb.core.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentHomeBinding.inflate(inflater)

    val listModel = listOf<ToolsGroupModel>(
        ToolsGroupModel(
            "test",
            "https://www.atorus.ru/sites/default/files/upload/image/News/56149/Club_Priv%C3%A9_by_Belek_Club_House.jpg",
            "name"
        ),
        ToolsGroupModel(
            "test2",
            "https://www.atorus.ru/sites/default/files/upload/image/News/56149/Club_Priv%C3%A9_by_Belek_Club_House.jpg",
            "name2"
        )
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CompositeAdapter.Builder()
            .addDelegate(ToolsGroupDelegate())
            .build()
        binding.toolsList.adapter = adapter
        adapter.submitList(listModel)
    }
}