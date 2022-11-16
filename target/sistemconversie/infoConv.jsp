<html>
    <head>
        <title> Rezultat convertire </title>
    </head>
    <body>
        <jsp:useBean id="deConvertit" class="conversie.InfoConversie" scope="request" />
        <p>
            S-a realizat conversia.
            <br>
            <br>
            <p>
            <jsp:getProperty name="deConvertit" property="valoareDeConvertit"/> in 
            <jsp:getProperty name="deConvertit" property="unitateDin"/>
            are valoarea 
            <jsp:getProperty name="deConvertit" property="valoareConvertita" />
            masurata in:
            <jsp:getProperty name="deConvertit" property="unitateCatre" />
            </p>
    </body>
</html>