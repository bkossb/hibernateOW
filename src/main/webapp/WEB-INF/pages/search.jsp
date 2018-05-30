<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>

    <title>Bazar aplikacji</title>

    <link type="text/css" href="css/custom-theme/jquery-ui-1.8.24.custom.css" rel="stylesheet"/>
    <link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" type="text/css" href="/style.css"/>

    <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.24.custom.min.js"></script>
    <script language="JavaScript">
        window.onload = function () {
            document.forms[0].elements["searchString"].focus();
        }

        function submitSearchForm() {

            var searchString = document.forms[0].elements["searchString"];

            if (searchString.value == null || searchString.value.replace(/^\s+|\s+$/g, '') == "") {
                alert("Wprowadz slowa kluczowe");
            } else {
                document.forms[0].submit();
            }

        }

        function installApp() {
            alert("Instalowanie aplikacji zostalo poprawne xxx z konta");
        }
    </script>
</head>

<body>
<div id="bg1"></div>
<div id="bg2"></div>
<div id="outer">
    <div id="header">
        <div id="logo">
            <h1><a href="index.html"><i>Bazar</i> Aplikacji</a></h1>
        </div>
        <form action="search" method="post">
            <div id="search">
                <div>
                    <input type="text" class="text" name="searchString" size="32" maxlength="64">
                    <img src="images/search.png" style="margin: -13px" alt="" onclick="submitSearchForm()">
                </div>
            </div>
        </form>
    </div>

    <div id="banner">
        <div class="captions">
            <h2><i>Największe</i> żródło aplikacji</h2>
        </div>
        <img src="images/banner.jpg" alt="" height="150" width="1180"/>
    </div>
    <div id="main">
        <div id="sidebar">
            <div class="box">
                <h3>Premiery</h3>
                <div class="dateList">
                    <ul class="linkedList dateList">
                        <li class="first">
                            <span class="date">data1</span> apka 1
                        </li>
                        <li class="first">
                            <span class="date">data2</span> apka 2
                        </li>
                        <li class="first">
                            <span class="date">data3</span> apka 3
                        </li>
                        <li class="first">
                            <span class="date">data4</span> apka 4
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div id="content">
        <div class="box"><h2>Wyniki wyszukiwania</h2></div>
    </div>
    <table style="width: 100%; margin-left:auto; margin-right: auto">
        <c:forEach items="${apps}" var="app" varStatus="loop">
            <tr>
                <td style="width: 25%; text-align: center; vertical-align: middle;" rowspan="2">
                    <img src="images/apps/${app.image}" alt="">
                </td>
                <td style="height: 1em; width: 75%; text-align: left; vertical-align: bottom; border-bottom: thin dotted black">
                    <b>${app.name}</b>
                    <input type="button" id="appDetailButton_${loop.index}" value="Szczegóły"></td>
            </tr>
            <tr>
                <td style="text-align: left; vertical-align: top; padding-bottom: 30px;">${app.description}</td>
            </tr>


            <div style="font-size: 10px; display:none;">
                <div id="appDetail_${loop.index}" title="Szczegóły">
                    <img src="images/apps/${app.image}" style="float: left; margin: 10px;" alt="">
                    <b>${app.name}</b>
                    <input type="button" value="Instaluj" onclick="installApp()">
                    <hr>

                    <br>
                        ${app.description}
                    <br><br>
                    <hr>

                    Wspierane urządzenia:

                    <c:forEach items="${app.supportedDevices}" var="customerReview" varStatus="devicesLoop">
                        ${device.manufactured} ${device.name}<c:if test="${not devicesLoop.last}">,</c:if>
                    </c:forEach>
                    <hr>
                    <br>

                    Opinie klientów:

                    <br>
                    <hr>

                    <c:forEach items="${app.customerReviews}" var="customerReview">
                        <b>${customerReview.stars} na 5 gwiazdek</b>
                        (użytkownik: <i> ${customerReview.username}</i><br>
                        ${customerReview.comments}
                        <br>
                        <br>
                    </c:forEach>
                </div>
            </div>

            <script language="JavaScript">
                $(function () {
                    $("#appDetailButton_${loop.index}").click(function () {
                        $("#appDetail_${loop.index}").dialog({
                            width: 650, modal: true
                        });
                    });
                });
            </script>
        </c:forEach>
    </table>

    <div>
        <br class="clear">
    </div>
    <br class="clear">

</div>
</body>
</html>