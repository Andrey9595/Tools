package ru.anb.login.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.anb.login.ui.email.LoginWithEmailFragment
import ru.anb.login.ui.phone.LoginWithPhoneFragment

class LoginAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val list: List<Fragment> = listOf(LoginWithEmailFragment(), LoginWithPhoneFragment())

    override fun getItemCount() = list.size


    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}