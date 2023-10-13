package com.example.alphaspace.screens.mainScreens.statisticsScreen.sections

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.example.alphaspace.ui.theme.CustomWhite0
import com.example.alphaspace.ui.theme.categoryIcons_background
import com.example.alphaspace.ui.theme.color4
import com.example.alphaspace.ui.theme.iconColor_border_p1

@Composable
fun StatisticsGraph(
    modifier : Modifier = Modifier
) {

    val pointsData: List<Point> =
        listOf(Point(0f, 40f), Point(1f, 90f), Point(2f, 0f), Point(3f, 60f), Point(4f, 10f),Point(5f, 40f), Point(6f, 90f), Point(7f, 0f), Point(8f, 60f), Point(9f, 10f),Point(10f, 40f), Point(11f, 90f), Point(12f, 0f), Point(13f, 60f), Point(14f, 10f))

    val xAxisData = AxisData.Builder()
        .axisStepSize(100.dp)
        .backgroundColor(CustomWhite0)
        .steps(pointsData.size - 1 )
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(20.dp)
        .build()

    val yAxisData = AxisData.Builder()
        .backgroundColor(CustomWhite0)
        .steps((pointsData.size % 10) )
        .labelData { i -> i.toString() }
        .labelAndAxisLinePadding(20.dp)
        .build()

    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData,
                    LineStyle(
                        width = 3F,
                        color = categoryIcons_background
                    ),
                    IntersectionPoint(
                        iconColor_border_p1
                    ),
                    SelectionHighlightPoint(
                        color = iconColor_border_p1
                    ),
                    ShadowUnderLine(
                        color = iconColor_border_p1
                    ),
                    SelectionHighlightPopUp(
                        backgroundColor = color4
                    )
                )
            ),
        ),
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(),
        backgroundColor = CustomWhite0,
        isZoomAllowed = true,
        paddingRight = 0.dp,
        paddingTop = 40.dp,
        bottomPadding = 8.dp,
        containerPaddingEnd = 26.dp
    )


    Surface(
        color = CustomWhite0,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(2.dp , color = iconColor_border_p1),
        shadowElevation = 6.dp,
        modifier = modifier
    ) {
        Box(
            modifier = modifier.padding(start = 16.dp)
        ) {
            LineChart(
                modifier = Modifier
                    .fillMaxSize(1f)
                    .height(300.dp),
                lineChartData = lineChartData
            )
        }
    }
}

@Preview(widthDp = 700 , heightDp = 400)
@Composable
fun StatisticsGraph_preview() {
    StatisticsGraph()
}