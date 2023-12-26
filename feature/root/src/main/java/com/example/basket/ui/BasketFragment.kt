package com.example.basket.ui

import android.view.LayoutInflater
import com.example.root.databinding.FragmentBasketBinding
import ru.anb.core.BaseFragment

class BasketFragment: BaseFragment<FragmentBasketBinding>() {

    override fun initBinding(inflater: LayoutInflater) = FragmentBasketBinding.inflate(inflater)

}