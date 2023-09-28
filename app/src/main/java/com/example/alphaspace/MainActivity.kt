package com.example.alphaspace

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.alphaspace.Model.data.screens_set
import com.example.alphaspace.Model.viewModel.AlphaViewModel
import com.example.alphaspace.screens.fullScreen.LoadingScreen.LoadingScreen
import com.example.alphaspace.screens.mainScreens.buyScreen.BuyScreen
import com.example.alphaspace.screens.fullScreen.SignInScreen.SignInScreen
import com.example.alphaspace.screens.fullScreen.setUpScreen.SetUpScreen
import com.example.alphaspace.screens.mainScreens.historyScreen.HistoryScreen
import com.example.alphaspace.screens.mainScreens.open_closeScreen.Open_CloseScreen
import com.example.alphaspace.screens.mainScreens.profileScreen.Profilecreen
import com.example.alphaspace.screens.mainScreens.settingsScreen.SettingScreen
import com.example.alphaspace.screens.mainScreens.statisticsScreen.StatisticsScreen
import com.example.alphaspace.screens.mainScreens.storeScreen.StoreScreen
import com.example.alphaspace.ui.theme.AlphaSpaceTheme
import com.example.alphaspace.ui.theme.color3
import com.example.alphaspace.ui.theme.color4
import com.example.alphaspace.ui.theme.color5
import com.example.alphaspace.ui.theme.navigationRail_backgroundColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<AlphaViewModel>(
        factoryProducer = {
            return@viewModels object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    if(modelClass.isAssignableFrom(AlphaViewModel::class.java)){
                        return AlphaViewModel(this@MainActivity) as T
                    }
                    else
                        throw java.lang.IllegalArgumentException("can't create that viewModel class (AlphaViewModel class)")
                }
            }
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {


            AlphaSpaceTheme {

                setUpUI()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = color3,
                ) {

                    when(viewModel.screenHandler.screen){

                        screens_set.mainScreen->{
                            MainScreen(viewModel)
                        }

                        screens_set.signInScreen->{
                            SignInScreen(
                                onDone = {
//                                signIn = true
                                } ,
                                googleSignInBtn = {googleAccount->

                                    if (googleAccount != null){

                                        viewModel.connectHandler.setAccount(googleAccount)
                                        viewModel.changeScreen(screens_set.loading_checkForSetUp)

                                        checkUserExistence((viewModel.connectHandler.googleSignInAccount?.id)?:""){isExist->
                                            if (isExist){
                                                viewModel.changeScreen(screens_set.mainScreen)
                                            }
                                            else{
                                                viewModel.changeScreen(screens_set.setUpScreen)
                                            }
                                        }

                                    }
                                }
                            )
                        }

                        screens_set.loading_checkForSetUp->{
                            LoadingScreen(
                                viewModel = viewModel
                            )

                            LaunchedEffect(key1 =  viewModel.connectHandler.googleSignInAccount?.id){

                                async { delay(1500) }.await()

                                viewModel.getUserByGoogleAccountId(viewModel.connectHandler.googleSignInAccount?.id ?: ""){user->
                                    if (user != null){
                                        viewModel.setUser(user)
                                        viewModel.screenHandler.setAppScreen(screens_set.mainScreen)
                                    }
                                    else{
                                        viewModel.screenHandler.setAppScreen(screens_set.setUpScreen
                                        )
                                    }
                                }
                            }

                        }

                        screens_set.setUpScreen->{
                            SetUpScreen(
                                viewModel = viewModel
                            )
                        }

                    }

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
                color = color3 ,
                darkIcons = useDarkIcons
            )

            // setStatusBarColor() and setNavigationBarColor() also exist

            onDispose {}
        }
    }


    fun checkUserExistence(googleAccountId : String , callBack : (isExist : Boolean)->Unit){
        GlobalScope.launch {

            async { delay(1500) }.await()

            viewModel.getUserByGoogleAccountId(googleAccountId){user->
                if (user != null){
                    callBack(true)
                }
                else{
                    callBack(false)
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    viewModel : AlphaViewModel
) {

    /***************       context         ******************/
    val context = LocalContext.current
    /********************************************************/

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
            color = color3
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

                                    viewModel.signOut()

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
                composable("profile") {
                    Profilecreen(
                        viewModel
                    )
                }
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

        val context = LocalContext.current
        MainScreen(
            viewModel = viewModel(
                factory = object :ViewModelProvider.Factory{
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        if(modelClass.isAssignableFrom(AlphaViewModel::class.java)){
                            return AlphaViewModel(context) as T
                        }
                        else
                            throw java.lang.IllegalArgumentException("can't create that viewModel class (AlphaViewModel class)")
                    }
                }
            )
        )
    }
}
