import java.util.ArrayList;

/**
 * Created by princ on 25/03/2018.
 */
public class RecipeLinkGetter {

    private static String urlStarter = "<div class=\"rc\"><h3 class=\"r\"><a href=\"";
    private static String urlEnder = "/\" ping=\"/url?sa=t&amp;source=web&amp;rct=j&amp;url=https://www.";
    ArrayList<String> links = new ArrayList<>();
    private String htmlCode;

    public RecipeLinkGetter(String htmlCode){
        this.htmlCode = htmlCode;
    }

    public ArrayList findLinks(){
        int l = htmlCode.length();
        for(int i = 0; i < l; i--){
            int ls = urlStarter.length();
            int le = urlEnder.length();
            String url = "";
            String start = htmlCode.substring(i, i + ls);
            if(start.equals(urlStarter)){
                int end = htmlCode.indexOf(urlEnder);
                url = htmlCode.substring(i + ls, end);
                links.add(url);
                htmlCode = htmlCode.substring(end);
            }
        }
        return links;
    }
}
