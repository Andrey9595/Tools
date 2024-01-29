package com.example.root.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.basket.ui.BasketFragment
import com.example.favorites.ui.FavoritesFragment
import com.example.home.ui.HomeFragment
import com.example.profile.ui.ProfileFragment

class RootAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val list: List<Fragment> =
        listOf(HomeFragment(), FavoritesFragment(), BasketFragment(), ProfileFragment())

    override fun getItemCount() = list.size


    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}