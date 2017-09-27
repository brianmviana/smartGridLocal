/**
 * 
 */

var gaugeChart = AmCharts.makeChart("chartdiv", {
	"type" : "gauge",
	"faceBorderAlpha" : -7,
	"theme" : "default",
	"arrows" : [ {
		"id" : "GaugeArrow-1"
	} ],
	"axes" : [ {
		"bottomText": "kilowatts",
		"bottomTextYOffset": -20,
		"endValue": 300,
		"id": "GaugeAxis-1",
		"valueInterval": 30,
		"bands" : [ {
			"color" : "#00CC00",
			"endValue" : 90,
			"id" : "GaugeBand-1",
			"startValue" : 0
		}, {
			"color" : "#ffac29",
			"endValue" : 160,
			"id" : "GaugeBand-2",
			"startValue" : 90
		}, {
			"color" : "#ea3838",
			"endValue" : 300,
			"id" : "GaugeBand-3",
			"innerRadius" : "95%",
			"startValue" : 160
		} ]
	} ],
	"allLabels" : [],
	"balloon" : {
		"animationDuration" : 0
	},
	"titles" : [ {
		"id" : "Title-1",
		"size" : 15,
		"text" : "Consumo em kW"
	} ]
});

setInterval( getWattAtual, 3000 );

function getWattAtual() {
	$.ajax({
		//web
		//url : 'https://smartgrid-web.herokuapp.com/api/getconsumo',
		//local
		url : 'http://localhost:8080/api/getconsumo',
		dataType : 'json',
		success : function(data) {
			var totalItems = data.length;
			//alert('Watts: ' + data[totalItems-1].totalWatts);
			var value = data[totalItems-1].totalWatts;
			if (gaugeChart) {
				if (gaugeChart.arrows) {
					if (gaugeChart.arrows[0]) {
						if (gaugeChart.arrows[0].setValue) {
							gaugeChart.arrows[0].setValue(value);
							gaugeChart.axes[0].setBottomText(value + " kW");
							$("#wattsBig").text(value + 'kW de consumo');
						}
					}
				}
			}
		},
		error : function() {
			$("#wattsBig").text('Falha na comunicação. Nenhum dado recebido')
		}
	});
}

window.onload = getWattAtual;
