package ru.anb.tools

import org.koin.dsl.bind
import org.koin.dsl.module
import ru.anb.core.Navigation
import ru.anb.core.NavigationImpl

fun mainModule() = module {

    single { NavigationImpl() } bind Navigation::class
}
