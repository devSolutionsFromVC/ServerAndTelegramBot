<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content=""/>
    <meta name="author" content=""/>

    <title>Welcome</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <link type="text/css" rel="StyleSheet" href="http://bootstraptema.ru/plugins/2016/shieldui/style.css" />
</head>
<body>

<br><br><br>

<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">

            <!-- График --><div id="chart"></div>

            <script>
                $(function () {
                    $("#chart").shieldChart({
                        theme: "light",
                        primaryHeader: {
                            text: "Продажи автомобилей система сравнения цен на нефть"
                        },
                        exportOptions: {
                            image: false,
                            print: false
                        },
                        axisY: [{
                            min: 1,
                            max: 60,
                            title: {
                                text: 'Средняя заработная плата (тысяч долларов США)',
                                style: {
                                    color: '#4DB0F5'
                                }
                            },
                            axisTickText: {
                                style: {
                                    color: '#4DB0F5'
                                }
                            }
                        }, {
                            min: 1,
                            max: 5,
                            title: {
                                text: 'Цены на газ (долл./галлон)',
                                style: {
                                    color: '#FFC500'
                                }
                            },
                            swapLocation: true,
                            axisTickText: {
                                style: {
                                    color: '#FFC500'
                                }
                            }
                        }, {
                            min: 1,
                            max: 40,
                            title: {
                                text: 'Проданных Автомобилей (В Миллионах)',
                                style: {
                                    color: '#FF1800'
                                }
                            },
                            swapLocation: true,
                            axisTickText: {
                                style: {
                                    color: '#FF1800'
                                }
                            }
                        }],
                        dataSeries: [{
                            seriesType: 'line',
                            axis: 0,
                            collectionAlias: "Зарплата",
                            data: [42.7, 52.8, 63.1, 23.5, 53, 55.8, 57.7]
                        }, {
                            seriesType: 'line',
                            axisY: 1,
                            collectionAlias: "Цены на газ (долл./галлон)",
                            data: [2.75, 2.80, 2, 2.55, 2.60, 2.90, 3.05]
                        }, {
                            seriesType: 'line',
                            axisY: 2,
                            collectionAlias: "Продажи Автомобилей",
                            data: [20, 22.9, 32.1, 31, 22.8, 22.4, 32.10]
                        }]
                    });
                });
            </script><!-- /.График -->

        </div><!-- /.col-md-8 col-md-offset-2 -->
    </div><!-- /.row -->
</div><!-- /.container -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/css/bootstrap.min.css"></script>
<script src="http://bootstraptema.ru/plugins/jquery/jquery-1.11.3.min.js"></script>
<script src="http://bootstraptema.ru/plugins/2016/shieldui/script.js"></script>
</body>
</html>
