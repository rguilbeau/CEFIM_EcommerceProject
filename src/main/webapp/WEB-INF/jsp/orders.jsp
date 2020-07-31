<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPEhtml>
<html>
<head>
    <meta charset="UTF-8">
    <title>Retour vers le future</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link href="/css/fontsface.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<header>
    <nav class="navbar navbar-light bg-light justify-content-between fixed-top shadow">
        <a class="navbar-brand bttf-font" href="/">RETOUR < ] future</a>
        <form class="form-inline">
            <a href="/Orders" class="btn btn-outline-primary my-2 my-sm-0" type="submit">Mes comamndes</a>
        </form>
    </nav>
</header>


<main role="main">
    <div class="container">
        <div class="col-md-12" style="margin-top: 100px;">
            <h2 class="featurette-heading mb-4">Mes commandes</h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Date</th>
                    <th scope="col">Nombre d'articles</th>
                    <th scope="col">Prix total</th>
                    <th scope="col">Etat de la commande</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${orders}" var="order">
                    <tr class="clickable orders-line" onclick="document.location = '/Order/${order.id}';">
                        <th scope="row">${order.id}</th>
                        <td>${order.dateCreated}</td>
                        <td>${order.getTotalNumberOfProduct()}</td>
                        <td>
                            <span>
                                <fmt:setLocale value="fr_FR"/>
                                <fmt:formatNumber value="${order.getTotalOrderPrice()}" type="currency"/>
                            </span>
                        </td>
                        <td>
                            <c:if test="${order.status.toString() eq 'in_progress'}">
                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-clock-history"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M8.515 1.019A7 7 0 0 0 8 1V0a8 8 0 0 1 .589.022l-.074.997zm2.004.45a7.003 7.003 0 0 0-.985-.299l.219-.976c.383.086.76.2 1.126.342l-.36.933zm1.37.71a7.01 7.01 0 0 0-.439-.27l.493-.87a8.025 8.025 0 0 1 .979.654l-.615.789a6.996 6.996 0 0 0-.418-.302zm1.834 1.79a6.99 6.99 0 0 0-.653-.796l.724-.69c.27.285.52.59.747.91l-.818.576zm.744 1.352a7.08 7.08 0 0 0-.214-.468l.893-.45a7.976 7.976 0 0 1 .45 1.088l-.95.313a7.023 7.023 0 0 0-.179-.483zm.53 2.507a6.991 6.991 0 0 0-.1-1.025l.985-.17c.067.386.106.778.116 1.17l-1 .025zm-.131 1.538c.033-.17.06-.339.081-.51l.993.123a7.957 7.957 0 0 1-.23 1.155l-.964-.267c.046-.165.086-.332.12-.501zm-.952 2.379c.184-.29.346-.594.486-.908l.914.405c-.16.36-.345.706-.555 1.038l-.845-.535zm-.964 1.205c.122-.122.239-.248.35-.378l.758.653a8.073 8.073 0 0 1-.401.432l-.707-.707z"></path>
                                    <path fill-rule="evenodd"
                                          d="M8 1a7 7 0 1 0 4.95 11.95l.707.707A8.001 8.001 0 1 1 8 0v1z"></path>
                                    <path fill-rule="evenodd"
                                          d="M7.5 3a.5.5 0 0 1 .5.5v5.21l3.248 1.856a.5.5 0 0 1-.496.868l-3.5-2A.5.5 0 0 1 7 9V3.5a.5.5 0 0 1 .5-.5z"></path>
                                </svg>
                                <span class="space"></span>
                                <span>En cours</span>
                            </c:if>
                            <c:if test="${order.status.toString() eq 'payed'}">
                                <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-check"
                                     fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd"
                                          d="M10.97 4.97a.75.75 0 0 1 1.071 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.236.236 0 0 1 .02-.022z"></path>
                                </svg>
                                <span class="space"></span>
                                <span>Payée</span>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </div>

</main>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>
</body>
</html>