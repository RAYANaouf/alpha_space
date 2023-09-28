package com.example.alphaspace.screens.mainScreens.statisticsScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.alphaspace.screens.mainScreens.statisticsScreen.sections.CalendarSection
import com.example.alphaspace.screens.mainScreens.statisticsScreen.sections.InteractionSection
import com.example.alphaspace.screens.mainScreens.statisticsScreen.sections.StatisticsGraph
import com.example.alphaspace.screens.mainScreens.statisticsScreen.sections.StatisticsInfo

@Composable
fun StatisticsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 26.dp , end = 26.dp , top = 16.dp , bottom = 16.dp)
    ){

        StatisticsGraph(
            modifier = Modifier
                .align(Alignment.TopStart)
                .fillMaxHeight(0.6f)
                .fillMaxWidth(0.7f)
                .padding(end = 12.dp)
        )

        StatisticsInfo(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .fillMaxHeight(0.5f)
                .fillMaxWidth(0.3f)
        )

        CalendarSection(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .fillMaxHeight(0.5f)
                .fillMaxWidth(0.3f)
                .padding(top = 16.dp)
        )

        InteractionSection(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .fillMaxHeight(0.4f)
                .fillMaxWidth(0.7f)
                .padding(top = 16.dp , end = 16.dp)
        )

    }
}

@Preview(widthDp = 1200 , heightDp = 800)
@Composable
fun StatisticsScreen_preview() {
    StatisticsScreen()
}
