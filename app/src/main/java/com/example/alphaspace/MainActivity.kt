package com.example.alphaspace

import android.annotation.SuppressLint
import android.graphics.Color.parseColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alphaspace.screens.buyScreen.BuyScreen
import com.example.alphaspace.screens.historyScreen.HistoryScreen
import com.example.alphaspace.screens.open_closeScreen.Open_CloseScreen
import com.example.alphaspace.screens.profileScreen.Profilecreen
import com.example.alphaspace.screens.settingsScreen.SettingScreen
import com.example.alphaspace.screens.statisticsScreen.StatisticsScreen
import com.example.alphaspace.screens.storeScreen.StoreScreen
import com.example.alphaspace.ui.theme.AlphaSpaceTheme
import com.example.alphaspace.ui.theme.color4
import com.example.alphaspace.ui.theme.navigationRail_backgroundColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AlphaSpaceTheme {

                setUpUI()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }

    @Composable
    fun setUpUI(){
        // Remember a SystemUiController
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = !isSystemInDarkTheme()

        DisposableEffect(systemUiController, useDarkIcons) {
            // Update all of the system bar colors to be transparent, and use
            // dark icons if we're in light theme
            systemUiController.setSystemBarsColor(
                color = color4,
                darkIcons = useDarkIcons
            )

            // setStatusBarColor() and setNavigationBarColor() also exist

            onDispose {}
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    var screens = listOf("profile","statistic","buy","about","settings","close")

    /***************       set up          *****************/

    var navigationRailItemColors = NavigationRailItemDefaults.colors(
        selectedIconColor = color4
    )
    var selectedItem by remember {
        mutableStateOf("profile")
    }

    // Set up the Navigation component
    val navController = rememberNavController()

    /*******************************************************/

    Scaffold { padding ->
        Row() {
            Surface(
//                shape = RoundedCornerShape(topEnd = 8.dp , topStart = 8.dp, bottomEnd = 8.dp, bottomStart = 8.dp ),
                shadowElevation = 8.dp,
//                modifier = Modifier.padding(top = 12.dp , bottom = 12.dp, start = 12.dp)
//                    .shadow(
//                        12.dp,
//
//                    ),
            ) {
                NavigationRail(
                    containerColor = navigationRail_backgroundColor,
                    header = {
                        Box (
                            modifier = Modifier
                                .weight(0.2f)
                        )
                        {
                            NavigationRailItem(
                                icon = { Image(painter = painterResource(id = R.drawable.alpha), contentDescription ="" ) },
                                selected = navController.currentBackStackEntry?.destination?.route == "profile" ,
                                onClick = {
                                    navController.navigate("profile"){
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        popUpTo(navController.graph.startDestinationId)
                                        // Avoid multiple copies of the same destination when
                                        // reselecting the same item
                                        launchSingleTop = true
                                        // Restore state when reselecting a previously selected item
                                        restoreState = true
                                    }
                                },
                                colors = navigationRailItemColors,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    },
                    content = {

                        Spacer(modifier = Modifier.weight(0.1f))

                        NavigationRailItem(
                            icon = { Image(painter = painterResource(id = R.drawable.phone_store), contentDescription = "" , modifier = Modifier.size(45.dp)) },
                            selected = navController.currentBackStackEntry?.destination?.route == "store" ,
                            onClick = {
                                navController.navigate("store"){
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    popUpTo(navController.graph.startDestinationId)
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            },
                            colors = navigationRailItemColors,
                            modifier = Modifier.weight(0.09f)
                        )
                        NavigationRailItem(
                            icon = { Image(painter = painterResource(id = R.drawable.statistics), contentDescription = "", modifier = Modifier.size(40.dp)) },
                            selected = navController.currentBackStackEntry?.destination?.route == "statistics"  ,
                            onClick = {
                                navController.navigate("statistics"){
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    popUpTo(navController.graph.startDestinationId)
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            } ,
                            colors = navigationRailItemColors,
                            modifier = Modifier.weight(0.09f)
                        )
                        NavigationRailItem(
                            icon = { Image(painter = painterResource(id = R.drawable.box), contentDescription = "", modifier = Modifier.size(40.dp)) },
                            selected = navController.currentBackStackEntry?.destination?.route == "buy"  ,
                            onClick = {
                                navController.navigate("buy") {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    popUpTo(navController.graph.startDestinationId)
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            },
                            colors = navigationRailItemColors,
                            modifier = Modifier.weight(0.09f)
                        )
                        NavigationRailItem(
                            icon = { Image(painter = painterResource(id = R.drawable.history), contentDescription = "", modifier = Modifier.size(40.dp)) },
                            selected = navController.currentBackStackEntry?.destination?.route == "history" ,
                            onClick = {
                                navController.navigate("history"){
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    popUpTo(navController.graph.startDestinationId)
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            },
                            colors = navigationRailItemColors,
                            modifier = Modifier.weight(0.09f)
                        )
                        NavigationRailItem(
                            icon = { Image(painter = painterResource(id = R.drawable.setting), contentDescription = "", modifier = Modifier.size(40.dp)) },
                            selected = navController.currentBackStackEntry?.destination?.route == "settings"  ,
                            onClick = {
                                navController.navigate("settings"){
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    popUpTo(navController.graph.startDestinationId)
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }

                            },
                            colors = navigationRailItemColors,
                            modifier = Modifier.weight(0.09f)
                        )

                        Box (
                            modifier = Modifier.weight(0.15f)
                        )
                        {

                        }
                        NavigationRailItem(
                            icon = { Image(painter = painterResource(id = R.drawable.closed), contentDescription = "", modifier = Modifier.size(40.dp)) },
                            selected = navController.currentBackStackEntry?.destination?.route == "open_close"  ,
                            onClick = {
                                navController.navigate("open_close") {
                                    // Pop up to the start destination of the graph to
                                    // avoid building up a large stack of destinations
                                    popUpTo(navController.graph.startDestinationId)
                                    // Avoid multiple copies of the same destination when
                                    // reselecting the same item
                                    launchSingleTop = true
                                    // Restore state when reselecting a previously selected item
                                    restoreState = true
                                }
                            },
                            colors = navigationRailItemColors,
                            modifier = Modifier.weight(0.1f)
                        )
                    }
                    )
            }


            // Content area for the screens
            NavHost(
                navController = navController,
                startDestination = "profile",
                modifier = Modifier
                    .fillMaxSize()
            ) {
                composable("profile") { Profilecreen() }
                composable("store") { StoreScreen() }
                composable("statistics") { StatisticsScreen() }
                composable("buy") { BuyScreen() }
                composable("history") { HistoryScreen() }
                composable("settings") { SettingScreen() }
                composable("open_close") { Open_CloseScreen() }
            }

        }
    }
}

@Preview(showBackground = true , widthDp = 1200 , heightDp = 800)
@Composable
fun GreetingPreview() {
    AlphaSpaceTheme {
        MainScreen()
    }
}
