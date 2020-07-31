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
            <h2 class="featurette-heading mb-4">${product.name}</h2>

            <div class="row featurette">

                <div class="col-md-5 mt-4">
                    <img class="featurette-image img-fluid mx-auto"
                         style="width: 700px; height: 350px; object-fit: scale-down"
                         src="/${product.picture}">
                </div>
                <div class="col-md-7 mt-4">

                    <p class="lead">${product.description}</p>
                    <p class="mt-5">
                        <span>Prix : </span>
                        <span class="bttf-font">
                            <fmt:setLocale value="fr_FR"/>
                            <fmt:formatNumber value="${product.price}" type="currency"/>
                        </span>
                    </p>
                    <p class="mt-0 mb-4 text-muted font-italic">Il reste ${stock.quantity} articles !
                    </p>
                    <button class="btn btn-primary" onclick="addCart(${product.id})">
                        <svg width="1.3em" height="1.3em" viewBox="0 0 16 16" class="bi bi-basket2"
                             fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M1.111 7.186A.5.5 0 0 1 1.5 7h13a.5.5 0 0 1 .489.605l-1.5 7A.5.5 0 0 1 13 15H3a.5.5 0 0 1-.489-.395l-1.5-7a.5.5 0 0 1 .1-.42zM2.118 8l1.286 6h9.192l1.286-6H2.118z"></path>
                            <path fill-rule="evenodd"
                                  d="M11.314 1.036a.5.5 0 0 1 .65.278l2 5a.5.5 0 1 1-.928.372l-2-5a.5.5 0 0 1 .278-.65zm-6.628 0a.5.5 0 0 0-.65.278l-2 5a.5.5 0 1 0 .928.372l2-5a.5.5 0 0 0-.278-.65z"></path>
                            <path d="M4 10a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zm3 0a1 1 0 0 1 2 0v2a1 1 0 1 1-2 0v-2zM0 6.5A.5.5 0 0 1 .5 6h15a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5H.5a.5.5 0 0 1-.5-.5v-1z"></path>
                        </svg>
                        <span>Ajouter au panier</span>
                    </button>
                    <span id="addcart-message"></span>
                </div>
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

<script src="/js/cart.js"></script>
</body>
</html>