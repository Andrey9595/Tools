package ru.anb.tools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.anb.login.ui.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction().replace(R.id.container, LoginFragment())
                .commit()
    }
}