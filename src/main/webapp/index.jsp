<html>

<body>
    <h2>Bun venit la sistemul de conversie pentru distanta</h2>
    <form action="procesareConversie" method="post">
        <p>Valoare de convertit</p>
        <input type="text" name="val_de_convertit">
        <br>
        <p>Converteste din
        <select name="marime_initiala">
            <option value="metru" >metru</option>
            <option value="inch" >inch</option>
            <option value="feet" >feet</option>
        </select>
        in
        <select name="marime_finala">
            <option value="metru" >metru</option>
            <option value="inch" >inch</option>
            <option value="feet" >feet</option>
        </select>
        <br> <br>
        <input type="submit" value="Converteste">
    </form>
</body>

</html>