/**
 * Created by Brian on 15/12/2016.
 */
/**
 *
 */

var gaugeChart = AmCharts.makeChart("chartdiv",
    {
        "type": "serial",
        "categoryField": "category",
        "startDuration": 1,
        "categoryAxis": {
            "gridPosition": "start"
        },
        "trendLines": [],
        "graphs": [
            {
                "balloonText": "[[title]] of [[category]]:[[value]]",
                "fillAlphas": 1,
                "id": "AmGraph-1",
                "labelText": "[[value]]",
                "title": "Watts Total",
                "type": "column",
                "valueField": "coluna"
            }
        ],
        "guides": [],
        "valueAxes": [
            {
                "id": "ValueAxis-1",
                "title": "Axis title"
            }
        ],
        "allLabels": [],
        "balloon": {},
        "legend": {
            "enabled": true,
            "useGraphSettings": true
        },
        "titles": [
            {
                "id": "Title-1",
                "size": 15,
                "text": "Chart Title"
            }
        ],
        "dataProvider": []
    }
);

//setInterval( getWattAtual, 3000 );
function gerarColunas() {
    if (gaugeChart) {
        var lista = ["Jeneiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"];
        var watt = 0;
        for(var x = 0; x < lista.length; x++){
            gaugeChart.dataProvider.push(
                {
                    category: (lista[x]),
                    coluna: watt
                }
            );
        };
    }
}

//setInterval(getWattAtual, 3000);

function getWattsPeriodo() {
    $.ajax({
        url : 'http://localhost:8080/api/getconsumo',
        dataType : 'json',
        success : function(data) {
            var totalItems = data.length;
            //alert('Watts: ' + data[totalItems-1].totalWatts);
            var value = data[totalItems-1].totalWatts;
            if (gaugeChart) {
                var lista = ["Jeneiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"];
                var watt = 0;
                for(var x = 0; x < lista.length; x++){
                    gaugeChart.dataProvider.push(
                        {
                            category: (lista[x]),
                            coluna: watt
                        }
                    );
                };
            }
        },
        error : function() {
            $("#wattsBig").text('Falha na comunicação. Nenhum dado recebido')
        }
    });
}

//window.onload = gerarColunas();
window.onload = getWattsPeriodo();
