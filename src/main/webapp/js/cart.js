function addCart(id) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("addcart-message").innerHTML = "1 article ajouté au panier !";
            setTimeout(function () {
                document.getElementById("addcart-message").innerHTML = "";
            }, 3000);
        }
    };
    xhr.open('POST', '/AddCart');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send("id=" + id + "&quantity=1");
}

function validateCart() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.location.reload(true);
        }
    };
    xhr.open('POST', '/ValidateCart');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();
}

function deleteOrderProduct(id) {
    /*var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.location.reload(true);
        }
    };
    xhr.open('POST', '/ValidateCart');
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send();*/
}