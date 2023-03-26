import java.util.ArrayList;
public class HTMLtext {
    public static void main(String[] args) {
        StringBuffer html = new StringBuffer();
        html.append("<html>\n" +
                "  <head>\n" +
                "    <title>\n" +
                "      This is the title.\n" +
                "    </title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    This is the body.\n" +
                "  </body>\n" +
                "</html>\n");

        ArrayList <String> lista = splitHtml(html.toString());
        HtmlDeph(lista);

    }
    public static ArrayList<String> splitHtml(String lista){

        ArrayList <String> ele = new ArrayList<String>(); //array final [<body>,conteudo,</body>]
        String []elementos  = lista
                .replace("\n","")
                .replace("<","*<")
                .replace(">",">*")
                .replace("**","*")
                .split("[*]");

        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i].trim() == ""){
                continue;
            }
            ele.add(elementos[i].trim());
        }
        System.out.println(ele);
        return ele;
    }
    public static String HtmlDeph(ArrayList<String> htmllist){
        String maxdeph = "";
        int nivel_atual = 0;
        int nivel_max = -1;

        for (int i = 0; i < htmllist.size(); i++) {

            if (htmllist.get(i).contains("<")) {
                if (htmllist.get(i).contains("</")){ // tag de fechamento
                    nivel_atual--;
                    System.out.println("FECHAMENTO - NIVEL :"+ nivel_atual +" "+ htmllist.get(i));
                    continue;
                }
                nivel_atual++; //tag de abertura
                System.out.println("ABERTURA - NIVEL :"+ nivel_atual +" "+ htmllist.get(i));
                continue;
            }
            if (nivel_atual > nivel_max){ // conteudo mais profundo
                maxdeph = htmllist.get(i); // atualizacao de variavel com coneteudo e do parametro de profundidade
                nivel_max = nivel_atual;
            }
            System.out.println("CONTEUDO - NIVEL :"+ nivel_atual +" "+ htmllist.get(i));

        }
        System.out.println("max = "+maxdeph);
        return maxdeph;
    }
}
