import java.util.ArrayList;

/**
 * Created by princ on 25/03/2018.
 */
public class Main {

    public static void main(String args[]){

        GoogleSearch googleSearch = new GoogleSearch("temp", "temp");
        String url = googleSearch.googleURL();
        URLReader urlReader = new URLReader(url);
        String googleHTMLCode = urlReader.readerReturn(url);
        RecipeLinkGetter recipeLinkGetter = new RecipeLinkGetter(googleHTMLCode);
        ArrayList<String> googleLinks = recipeLinkGetter.findLinks();
    }

}
