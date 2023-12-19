package ru.anb.tools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.inject
import ru.anb.core.Navigation
import ru.anb.login.ui.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation: Navigation by inject()
        navigation.setUpNavigation(supportFragmentManager, R.id.container)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().replace(R.id.container, LoginFragment())
                .commit()
    }
}