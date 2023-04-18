import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class HtmlAnalyzer{

    public static void main(String[] args) {
        String [] a = {args[0]};


        StringBuffer html = new StringBuffer();

        try{
            URL url = new URL(a[0]);
            HttpURLConnection conec = (HttpURLConnection) url.openConnection();
            //Metodo GET
            conec.setRequestMethod("GET");

            if (conec.getResponseCode()>=400){
                System.out.println("URL connection error"); // qualquer Status code erro acima de 400 (Client e Server erro)
                return;
            }

            // Leia o HTML da conexão
            BufferedReader in = new BufferedReader(new InputStreamReader(conec.getInputStream()));
            String inputLine;

            // lendo linha por linha
            while ((inputLine = in.readLine()) != null) {
                html.append(inputLine);
            }
            in.close();
        }
        catch (Exception e){
            System.out.println("URL connection error");
        }

        HTMLtext test = new HTMLtext();

        ArrayList <String> lista = test.splitHtml(html.toString());
        if(test.checkHtml(lista)){ // verificando o html
            test.htmlDeph(lista); // resultado
        }
    }

}


