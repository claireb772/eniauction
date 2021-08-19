<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/Header.jsp" %> 
</head>
<body>

	

<nav class="bg-primary p-3 text-white d-flex col d-flex justify-content-between">
	<%@ include file="/WEB-INF/navBar.jsp" %> 
</nav>
<main class="p-3 col-12 row d-flex justify-content-center">
<p style="" class="text-center text-primary">Acheter des crédits</p>
	
	<form method="post" class=" col-12 col-md-6">
			<div class="form-group  mt-2">
				<label class="" for="cname">Name on Card</label>
	            <input  class="form-control" type="text" id="cname" name="cardname" placeholder="John More Doe" required>
            </div>
            <div class="form-group  mt-2">
            	<label for="ccnum">Credit card number</label>
            	<input class="form-control"  type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444" required>	
            </div>
           <div class="form-group row mt-2">
	           <div class="col-6">
		            <label for="expmonth">Exp Month</label>
		            <input class="form-control" type="text" id="expmonth" name="expmonth" placeholder="12/24" required>
		        </div>
		        <div class="col-6">
		            <label for="cvv">CVV</label>
                <input class="form-control"  type="text" id="cvv" name="cvv" placeholder="352" required>
		        </div>
			</div>
            <div class="form-group  mt-2">
            	<label for="ccnum">Montant désiré</label>
            	<input class="form-control"  type="text" id="ccnum" name="amount" placeholder="225" required>	
            </div>
            <button type="submit" class="btn btn-primary w-100 mt-2">Valider</button>
	</form>
</main>
</body>
</html>