<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="authenticated"/>
    <title>Shelter Counts</title>
    <link rel="stylesheet" href="${resource(dir:'js/lib/apexcharts', file:'apexcharts.css')}" />
    <script src="${resource(dir:'js/lib/apexcharts', file:'apexcharts.js')}" type="text/javascript"></script>
</head>
<body>
<style>
.update-entry-btn{
    display:block;
}
.shelter-data{
    margin:10px auto 20px auto;
}
table{
    width:100%;
}
table th{
    color:#90A4AE;
    padding-bottom: 20px;
}

table td{
    line-height:1.6em;
    font-size:21px !important;
    padding:5px 0px 10px 0px;
}
a{
    text-decoration: none !important;
    border-bottom:dotted 2px #428bca !important;
}
.daily-count{
    font-size:31px;
    font-family: roboto-black !important;
}
</style>

<h2>${shelter.name}</h2>

<g:if test="${flash.message}">
    <div class="notify" role="status">${flash.message}</div>
</g:if>

<g:if test="${dailyCounts}">

    <div id="chart"></div>

    <table class="table">
        <thead>
        <tr>
            <th>Date</th>

            <th>Count</th>

            <th></th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${dailyCounts}" status="i" var="dailyCount">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td>${dailyCount.dateEntered}</td>

                <td style="text-align: center">${dailyCount.total}</td>

                <td style="text-align: center">
                    <g:link uri="/dailyCount/edit/${dailyCount.id}">Edit</g:link> &check;
                </td>

            </tr>
        </g:each>
        </tbody>
    </table>

</g:if>
<g:else>
    <br/>
    <p>No numbers entered for this shelter.</p>
</g:else>

<script>




    function loadGraph(){
        $.ajax({
            url: "/z/data/counts/${shelter.id}",
            success: populateGraph,
            error: $.noop
        })
    }

    function populateGraph(data){
        var options = {
            series: [{
                name: 'Count',
                data: data.counts
            }],
            chart: {
                height: 350,
                type: 'bar',
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        position: 'top', // top, center, bottom
                    },
                }
            },
            dataLabels: {
                enabled: true,
                formatter: function (val) {
                    return val;
                },
                offsetY: -20,
                style: {
                    fontSize: '12px',
                    colors: ["#304758"]
                }
            },

            xaxis: {
                categories: data.labels,
                position: 'bottom',
                axisBorder: {
                    show: false
                },
                axisTicks: {
                    show: false
                },
                crosshairs: {
                    fill: {
                        type: 'gradient',
                        gradient: {
                            colorFrom: '#D8E3F0',
                            colorTo: '#BED1E6',
                            stops: [0, 100],
                            opacityFrom: 0.4,
                            opacityTo: 0.5,
                        }
                    }
                },
                tooltip: {
                    enabled: false,
                }
            },
            yaxis: {
                axisBorder: {
                    show: false
                },
                axisTicks: {
                    show: false,
                },
                labels: {
                    show: false,
                    formatter: function (val) {
                        return val;
                    }
                }

            },
            title: {
                text: 'Daily Counts',
                floating: true,
                offsetY: 330,
                align: 'center',
                style: {
                    color: '#444'
                }
            }
        };

        var chart = new ApexCharts(document.querySelector("#chart"), options);
        chart.render();
    }

    $(document).ready(function(){
        loadGraph();
    })
</script>

</body>
</html>
