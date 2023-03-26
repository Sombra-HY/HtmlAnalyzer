import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) {
        String [] a = {"https://www.google.com"};
        HtmlAnalyzer.main(a);
    }
}



class HtmlAnalyzer {
    public static void main(String[] args) {
        try{
            URL url = new URL(args[0]);

            HttpURLConnection conec = (HttpURLConnection) url.openConnection();
            if (conec.getResponseCode()>=400){
                System.out.println("(Error) URL connection ");
                return;
            }

        }
        catch (Exception e){
            System.out.println("erro");
            System.out.println(e.getMessage());

        }

//        try {
//            // Crie uma URL para o site desejado
//            URL url = new URL("https://www.gooagle.com");
//
//            // Crie uma conexão HttpURLConnection para a URL
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//            // Defina o método HTTP para GET
//            conn.setRequestMethod("GET");
//            System.out.println("sim");
//
////            // Leia o HTML da conexão
////            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
////            String inputLine;
////            StringBuffer html = new StringBuffer();
////            while ((inputLine = in.readLine()) != null) {
////                html.append(inputLine);
////            }
////            in.close();
////
////            // Imprima o HTML na saída padrão
////            System.out.println(html.toString());
//        }
//
//        catch (Exception e) {
//            System.out.println(e);;
//
//        }

    }
}