package ru.anb.tools

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.root.ui.RootFragment
import org.koin.android.ext.android.inject
import ru.anb.core.Navigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation: Navigation by inject()
        navigation.setUpNavigation(supportFragmentManager, R.id.container)
        if (savedInstanceState == null)
            navigation.goTo(RootFragment::class.java)
    }
}