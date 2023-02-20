package com.example.mobilebank.di.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNavigatorDispatcher @Inject constructor() : AppNavigationHandler, AppNavigator {

    override val navigation = MutableSharedFlow<NavigationArgs>()
    override suspend fun back() = navigator {
        pop()
    }

    override suspend fun navigateTo(screen: AppScreen) = navigator {
        push(screen)
    }

    override suspend fun navigateTo(screens: List<AppScreen>) = navigator {
        push(screens)
    }

    override suspend fun replaceAll(screen: AppScreen) = navigator {
        replaceAll(screen)
    }

    override suspend fun <T : AppScreen> backUntil(clazz: Class<T>) = navigator {
        popUntil {
            it::class == clazz
        }
    }

    private suspend fun navigator(navigationArgs: NavigationArgs) {
        navigation.emit(navigationArgs)
    }
}