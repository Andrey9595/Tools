package com.example.favorites.ui

import android.view.LayoutInflater
import com.example.root.databinding.FragmentFavoritBinding
import ru.anb.core.BaseFragment

class FavoritesFragment : BaseFragment<FragmentFavoritBinding>() {
    override fun initBinding(inflater: LayoutInflater) = FragmentFavoritBinding.inflate(inflater)

}