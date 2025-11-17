package insostenible.edu.vivemorelia

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import insostenible.edu.vivemorelia.iu.CategoriesScreen
import insostenible.edu.vivemorelia.iu.PlacesScreen
import insostenible.edu.vivemorelia.iu.DetailScreen
import insostenible.edu.vivemorelia.iu.MyCityViewModel

enum class MyCityScreen(@StringRes val title: Int) {
    Categories(title = R.string.categories),
    Places(title = R.string.places),
    Details(title = R.string.details)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityAppBar(
    currentScreen: MyCityScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}

@Composable
fun MyCityApp(
    viewModel: MyCityViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    windowSize: WindowWidthSizeClass
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MyCityScreen.valueOf(
        backStackEntry?.destination?.route ?: MyCityScreen.Categories.name
    )

    Scaffold(
        topBar = {
            MyCityAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MyCityScreen.Categories.name,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(MyCityScreen.Categories.name) {
                CategoriesScreen(
                    categories = uiState.categories,
                    onCategoryClick = {
                        viewModel.selectCategory(it)
                        navController.navigate(MyCityScreen.Places.name)
                    }
                )
            }

            composable(MyCityScreen.Places.name) {
                PlacesScreen(
                    places = uiState.placesForCategory,
                    onPlaceClick = {
                        viewModel.selectPlace(it)
                        navController.navigate(MyCityScreen.Details.name)
                    },
                    onBack = { navController.navigateUp() }
                )
            }

            composable(MyCityScreen.Details.name) {
                DetailScreen(
                    place = uiState.currentPlace,
                    onBack = { navController.navigateUp() }
                )
            }
        }
    }
}
