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


<main role="main" class="mt-5">

    <section class="jumbotron text-center mb-0">
        <div class="container">
            <h1 class="bttf-font">RETOUR < ] future</h1>
            <p class="lead text-muted">Traversez les époques en grâce nos articles indispensables à tout bon voyageur du
                temps. Découvrez nos produit du passé, du présent et du futur ! Atteignez les 88 miles à l'heure
                mais attention aux déchirures du continuum espace-temps qui provoquent la destruction totale de
                l'univers !</p>
        </div>
        <img src="/images/cover.jpg" class="product-cover"/>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">

            <div class="row">
                <c:forEach items="${products}" var="product">
                    <div class="col-lg-4 col-md-6">
                        <div class="card mb-4 shadow-sm">
                            <a href="/Product/${product.id}">
                                <img class="product-images" src="${product.picture}"/>
                            </a>
                            <div class="card-body product-card-product">
                                <a href="/Product/${product.id}"><p class="card-text mb-3">${product.name}</p></a>
                                <div class="d-flex justify-content-between align-items-center">
                                    <span class="bttf-font">
                                        <fmt:setLocale value="fr_FR"/>
                                        <fmt:formatNumber value="${product.price}" type="currency"/>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
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