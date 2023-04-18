public class HtmlTag {

    /**
     * return 1 for tag open, 2 tag end and 0 if not is a tag
     * **/
    public int isTag(String el){
        return !(el.charAt(0) == '<' && el.charAt(el.length() - 1) == '>')?(0):(el.contains("</"))?2:1 ;
    }

}
