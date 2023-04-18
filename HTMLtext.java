import java.util.ArrayList;


public class HTMLtext extends HtmlTag {

    public ArrayList<String> splitHtml(String lista){

        ArrayList <String> listformat = new ArrayList<>();
        String []elementos  = lista //Removendo espacoes e divindo em uma lista
                .replace("\n","")
                .replace("<","*<")
                .replace(">",">*")
                .replace("**","*")
                .split("[*]");

        for (String elemento : elementos) {
            if (elemento.trim().equals("")) continue;
            listformat.add(elemento.trim());
        }
        return listformat; // return exe: ["<body>", <p>, conteudo, </p>, "</body>"]
    }

    public boolean checkHtml(ArrayList<String> lista){


        ArrayList <String> opentags = new ArrayList<>();
        boolean optag =false;

        for (String el : lista) {
            if (super.isTag(el)!=0) {
                if (super.isTag(el)==1) { //abertura
                    opentags.add(el);
                    optag = true;
                    continue;
                }
                if (!optag) { // caso nao tenha sido abrido uma tag e tenha começado com uma tag de fechamento
                    System.out.println("1malformed HTML");
                    return false;
                }

                String formatendtag = "</" + opentags.get(opentags.size() - 1).substring(1);

                if (!el.equals(formatendtag)) { // verifica se a de tag fechamento atual é a que deve ser fechada ex: <div> <p> </div> </p> --> erro
                    System.out.println("2malformed HTML");
                    return false;
                }
                opentags.remove(opentags.size() - 1);
            }
        }
        if (opentags.size()==0){ //verifica se todas tags foram fechadas
            return true;
        }
        System.out.println("3malformed HTML");
        return false;
    }

    public String htmlDeph(ArrayList<String> htmllist){
        String maxdeph = "";
        int nivel_atual = 0;
        int nivel_max = -1;

        for (String el : htmllist) {
            if (super.isTag(el)!=0) { // verifico se é uma Tag
                if (el.contains("</")) { //Tag de abertura
                    nivel_atual--;
                    continue;
                }
                nivel_atual++; //Tag de fechamento
                continue;
            }
            if (nivel_atual > nivel_max) { // conteudo mais profundo
                maxdeph = el;
                nivel_max = nivel_atual;
            }
        }
        System.out.println(maxdeph);
        return maxdeph;
    }

}
