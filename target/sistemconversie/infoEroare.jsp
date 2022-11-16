<html>
    <head>
        <title> Mesaj de eroare </title>
    </head>
    <body>
        <jsp:useBean id="error" class="util.Eroare" scope="request" />
        <p>
            A avut loc o eroare la conversie: 
            <jsp:getProperty name="error" property="mesaj"/>
        </p>
        <a href="index.jsp">Incearca din nou</a>
    </body>
</html>