
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conversie.InfoConversie;
import util.Eroare;

@WebServlet("/procesareConversie")
public class ConversieServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("/index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        prelucreazaDate(request, response);
    }

    public void prelucreazaDate(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SecurityException, ServletException {
        System.out.println("s-a invocat servletul");

        String valoareInit = request.getParameter("val_de_convertit");
        String marimeInit = request.getParameter("marime_initiala");
        String marimeFinal = request.getParameter("marime_finala");
        String mesajDeEroare = "";
        double valoareDeProcesat = 0;
        boolean valid = true;

        //validarea datelor din textbox
        if (valoareInit == "") {
            valid = false;
            mesajDeEroare += "Introduceti un numar <br>";
        } else { //verificam sa fie parsable
            try {
                valoareDeProcesat = Double.parseDouble(valoareInit);
            } catch (Exception e) {
                System.out.println("Nu este prezent un numar in camp");
                valid = false;
                mesajDeEroare += "Introduceti un numar si nu caractere <br>";
            }
        }
        
    
        if (valid == true) {
            //determinam constanta bazata pe marimea de intrare si iesire
            InfoConversie deConvertit = new InfoConversie();
            if (marimeInit.equals("metru")) {
                if (marimeFinal.equals("feet")){
                    deConvertit.setConstantaDeConversie(3.281);
                }
                else if (marimeFinal.equals("inch"))
                    deConvertit.setConstantaDeConversie(39.37);
            }
            if (marimeInit.equals("feet")) {
                if (marimeFinal.equals("metru"))
                    deConvertit.setConstantaDeConversie(0.30478);
                else if (marimeFinal.equals("inch"))
                    deConvertit.setConstantaDeConversie(12);
            }       
            if (marimeInit.equals("inch")) {
                if (marimeFinal.equals("metru"))
                    deConvertit.setConstantaDeConversie(0.0254);
                else if (marimeFinal.equals("feet"))
                    deConvertit.setConstantaDeConversie(0.08333);
            }
            //daca este aceeasi marime, se multiplica cu 1
            if(marimeInit.equals(marimeFinal))
                deConvertit.setConstantaDeConversie(1);

            //atribuim valorile procesate catre obiectul nostru 
            deConvertit.setValoareDeConvertit(valoareDeProcesat);
            deConvertit.setUnitateDin(marimeInit);
            deConvertit.setUnitateCatre(marimeFinal);
            deConvertit.setValoareConvertita(deConvertit.getValoareDeConvertit()*deConvertit.getConstantaDeConversie());
            request.setAttribute("deConvertit", deConvertit);

            RequestDispatcher view = request.getRequestDispatcher("infoConv.jsp");
            view.forward(request, response);
        } else {

            //cream obiectul eroare si redirectionam spre infoEroare.jsp unde afiseaza mesajul de eroare
            Eroare err = new Eroare();
            err.setMesaj(mesajDeEroare);
            System.out.println(err.getMesaj());
            request.setAttribute("error", err);
            RequestDispatcher view = request.getRequestDispatcher("infoEroare.jsp");
            view.forward(request, response);
        }

    }
}
