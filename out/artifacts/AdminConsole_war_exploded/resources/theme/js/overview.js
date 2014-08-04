/**
 * Created by Rix on 7/12/14.
 */

$(document).ready(function()
    {
        var chart;

        var statistics = $("#statistics").text();
        var chartData = $.parseJSON(statistics);

        AmCharts.ready(function () {
            // SERIAL CHART
            chart = new AmCharts.AmSerialChart();
            chart.pathToImages = "../amcharts/images/";
            chart.dataProvider = chartData;
            chart.categoryField = "date";
            chart.startDuration = 1;

            chart.handDrawn = true;
            chart.handDrawnScatter = 3;

            // AXES
            // category
            var categoryAxis = chart.categoryAxis;
            categoryAxis.gridPosition = "start";

            // value
            var valueAxis = new AmCharts.ValueAxis();
            valueAxis.axisAlpha = 0;
            chart.addValueAxis(valueAxis);

            // GRAPHS
            // column graph
            var graph1 = new AmCharts.AmGraph();
            graph1.type = "column";
            graph1.title = "Protocols";
            graph1.lineColor = "#a668d5";
            graph1.valueField = "protocols";
            graph1.lineAlpha = 1;
            graph1.fillAlphas = 1;
            graph1.dashLengthField = "dashLengthColumn";
            graph1.alphaField = "alpha";
            graph1.balloonText = "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b> [[additional]]</span>";
            chart.addGraph(graph1);

            // line
            var graph2 = new AmCharts.AmGraph();
            graph2.type = "line";
            graph2.title = "Devices";
            graph2.lineColor = "#fcd202";
            graph2.valueField = "devices";
            graph2.lineThickness = 3;
            graph2.bullet = "round";
            graph2.bulletBorderThickness = 3;
            graph2.bulletBorderColor = "#fcd202";
            graph2.bulletBorderAlpha = 1;
            graph2.bulletColor = "#ffffff";
            graph2.dashLengthField = "dashLengthLine";
            graph2.balloonText = "<span style='font-size:13px;'>[[title]] in [[category]]:<b>[[value]]</b> [[additional]]</span>";
            chart.addGraph(graph2);

            // LEGEND
            var legend = new AmCharts.AmLegend();
            legend.useGraphSettings = true;
            chart.addLegend(legend);

            // WRITE
            chart.write("chartdiv");
        });
    }
);