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
            <h2 class="featurette-heading mb-4">
                <span>Commande N°${order.id} du ${order.dateCreated}</span>
                <br>
                <span class="bttf-font">
                    <fmt:setLocale value="fr_FR"/>
                    <fmt:formatNumber value="${order.getTotalOrderPrice()}" type="currency"/>
                </span>
            </h2>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Produit</th>
                    <th scope="col">Prix unitaire</th>
                    <th scope="col">Quantité</th>
                    <!--<th scope="col">Actions</th>-->
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${order.getOrderProducts()}" var="orderproduct">
                    <tr>
                        <td><img class="order-product-image" src="/${orderproduct.product.picture}"></td>
                        <td><a href="/Product/${orderproduct.product.id}">${orderproduct.product.name}</a></td>
                        <td class="bttf-font">
                            <fmt:setLocale value="fr_FR"/>
                            <fmt:formatNumber value="${orderproduct.product.price}" type="currency"/>
                        </td>
                        <td>${orderproduct.quantity}</td>
                        <!--<td>
                            <button onclick="deleteOrderProduct(${orderproduct.product.id});"
                                    class="btn btn-outline-warning btn-sm">Supprimer 1 article
                            </button>
                        </td>-->
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <c:if test="${order.status.toString() eq 'in_progress'}">
                <div class="col-md-12 mt-5 text-center" onclick="validateCart()">
                    <button class="btn btn-primary btn-lg">Passer la commande (${order.getTotalNumberOfProduct()}
                        articles)
                    </button>
                </div>
            </c:if>
            <c:if test="${order.status.toString() eq 'payed'}">
                <div class="col-md-12 mt-5 text-center">
                    <h2>Commande payé</h2>
                </div>
            </c:if>
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

<script src="/js/cart.js"></script>
</body>
</html>