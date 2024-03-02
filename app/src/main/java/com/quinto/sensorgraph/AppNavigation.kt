package com.quinto.sensorgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.quinto.sensorgraph.AppDestinations.SENSOR_DETAIL_ROUTE
import com.quinto.sensorgraph.AppDestinations.SENSOR_LIST_ROUTE
import com.quinto.sensorgraph.AppDestinations.SENSOR_NAME_KEY
import com.quinto.sensorgraph.model.SensorViewModel
import com.quinto.sensorgraph.view.SensorGraphView
import com.quinto.sensorgraph.view.SensorList

private object AppDestinations {
    const val SENSOR_LIST_ROUTE = "sensorList"
    const val SENSOR_DETAIL_ROUTE = "sensorDetail"
    const val SENSOR_NAME_KEY = "sensorName"
}

@Composable
fun AppNavigation(
    viewModelMap: Map<String, SensorViewModel>,
    startDestination: String = SENSOR_LIST_ROUTE,
) {
    val sensorNames = viewModelMap.keys.toList()
    val navController = rememberNavController()
    val actions = remember(navController) { AppActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            SENSOR_LIST_ROUTE
        ) {
            SensorList(
                selectedSensor = actions.selectedSensor,
                sensorNames = sensorNames
            )
        }
        composable(
            "{$SENSOR_DETAIL_ROUTE}/{$SENSOR_NAME_KEY}",
            arguments = listOf(
                navArgument(SENSOR_NAME_KEY) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val viewModel: SensorViewModel = viewModelMap[arguments.getString(SENSOR_NAME_KEY)]!!
            SensorGraphView(viewModel)
        }
    }
}

private class AppActions(
    navController: NavHostController
) {
    val selectedSensor: (String) -> Unit = { sensorName: String ->
        navController.navigate("{$SENSOR_DETAIL_ROUTE}/$sensorName")
    }
}
