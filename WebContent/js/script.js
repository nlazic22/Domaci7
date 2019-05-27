'use strict';

function loadCoupons() {
	


    //AJAX
    var xhttp = new XMLHttpRequest();

    /*
    onreadystatechange.readyState
        0: request not initialized
        1: server connection established
        2: request received
        3: processing request
        4: request finished and response is ready
     */

    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            var result = JSON.parse(this.response);

            // Dohvati tabelu iz DOM-a po id-u
            var table = document.getElementById("coupon-tbl");

            // Dohvati prvi tbody
            var oldTBody = table.tBodies[0];
            var newTBody = document.createElement("tBody");

            for (var i = 0; i < result.length; i++) {

                var bRow = document.createElement("tr"); // Kreiraj novi red

                // Postavi vrednosti za taj red iz rezultata sa servera
                var tdProduct = document.createElement("td");
                tdProduct.innerHTML = result[i].product;
                var tdShop = document.createElement("td");
                tdShop.innerHTML = result[i].shop.name;
                var tdDiscountedPrice = document.createElement("td");
                tdDiscountedPrice.innerHTML = result[i].discountedPrice;
                var tdOriginalPrice = document.createElement("td");
                tdOriginalPrice.innerHTML = result[i].originalPrice;
                var tdDiscount = document.createElement("td");
                tdDiscount.innerHTML = result[i].discount;
                var tdBtn = document.createElement("td");
                var btn = document.createElement("BUTTON");
                btn.innerHTML = "Delete";
                btn.id = result[i].id;
                btn.addEventListener("click", deleteCoupon);
                tdBtn.appendChild(btn);
                

                bRow.appendChild(tdProduct);
                bRow.appendChild(tdShop);
                bRow.appendChild(tdDiscountedPrice);
                bRow.appendChild(tdOriginalPrice);
                bRow.appendChild(tdDiscount);
                bRow.appendChild(tdBtn);

                newTBody.appendChild(bRow)
                

            }
            
            

            // Zameni postojeci sa novim tBody-jem.
            // Na taj nacin ce uvek da se ispisuju svezi elementi a stari da nestanu.
            table.replaceChild(newTBody, oldTBody)
            
            var dropdownMenu = document.getElementById("dropdownMenu");
            
            var uniquesArray = [];
            var counting = 0;
            var found = false;
            for(var j = 0; j < result.length; j++){
            	for (var y = 0; y < uniquesArray.length; y++) {
            		if ( result[j].shop.name == uniquesArray[y] ) {
            			found = true;
            		}
            	}
            	counting++;
            	if (counting == 1 && found == false) {
            		uniquesArray.push(result[j].shop.name);
            	
            		
            	var option = document.createElement("option");
            	option.innerHTML = result[j].shop.name;
            	option.id = result[j].shop.id;
            	dropdownMenu.appendChild(option);
            	}
            	found = false;
            	counting = 0;
            		
            
            }
        }
    };

    xhttp.open("GET", "/Domaci7/rest/coupons/coupon", true);
    xhttp.send();
}

window.onload = function () { loadCoupons(); };

function createCoupon(shop, product, originalPrice, discountedPrice) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            alert("OK")
        }
    };

    xhttp.open("POST", "/Domaci7/rest/coupons", true);
    xhttp.setRequestHeader("Content-Type", "application/json");

    // Saljemo objekat sa parametrima pretvoren u JSON
    xhttp.send(JSON.stringify({shop: shop, product: product, originalPrice: originalPrice, discountedPrice: discountedPrice}));
    onsubmit=setTimeout(function(){loadCoupons();},10);
}






/*
Ovde ce se nalaziti logika koja se pozvati prilikom submit-a forme.
 */
function processForm(e) {
    if (e.preventDefault) e.preventDefault();
    var formData = new FormData(e.target);
    
    var dd = document.getElementById("dropdownMenu");
    var idOfdd = dd.options[dd.selectedIndex].id;

    var shop = {name : formData.get("dropdown"), id: idOfdd};
    var product = formData.get("imeProizvoda");
    var originalPrice = formData.get("staraCena");
    var discountedPrice = formData.get("novaCena");
    createCoupon(shop, product, originalPrice, discountedPrice);

    // Obavezno vratiti false da bi se pregazilo default-no ponasanje prilikom submit-a.
    return false;
}

var form = document.getElementById('add-coupon-form');
if (form.attachEvent) {
    // IE support
    form.attachEvent("submit", processForm);
} else {
    form.addEventListener("submit", processForm);
}

function deleteCoupon(e){
	
	var btn = e.target;
	var id = btn.id;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            alert("OK")
        }
    };

    xhttp.open("DELETE", ("/Domaci7/rest/coupons/" + id), true);
    xhttp.setRequestHeader("Content-Type", "application/json");

    xhttp.send();
    onsubmit=setTimeout(function(){loadCoupons();},10);
	
	
}