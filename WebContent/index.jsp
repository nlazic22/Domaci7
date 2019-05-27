<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kuponi</title>

<link rel="stylesheet" href="style/style.css">
</head>
<body>
   <h3>Tabela sa kuponima</h3>

<table id="coupon-tbl">
    <thead>
        <tr>
            <th>Ime proizvoda</th>
            <th>Ime radnje</th>
            <th>Cena sa popustom</th>
            <th>Cena bez popusta</th>
            <th>Popust[u %]</th>
            <th>Dugme za brisanje</th>
        </tr>
    </thead>
    <tbody>

    </tbody>
</table>


<br><br>
<form id="add-coupon-form">
    <select name = "dropdown" id="dropdownMenu">

    </select>
    <input type="text" name="imeProizvoda" placeholder="Ime proizvoda" id="imeProizvoda">
    <input type="text" name="staraCena" placeholder="Stara cena" id="staraCena">
    <input type="text" name="novaCena" placeholder="Nova cena" id="Nova cena">
    <input type="Submit" value="Submit" id="Submit">
</form>
<script src="js/script.js"></script>
</body>
</html>