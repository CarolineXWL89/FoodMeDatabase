/**
 * Created by princ on 25/03/2018.
 */
public class GoogleSearch {

    private static String googleSearchRoot = "https://www.google.com/search?safe=strict&source=hp&ei=&q=";
    private String searchTerm, site, food = "";
    private String googleSearch = "";

    public GoogleSearch(String site, String food) {
        this.site = site;
        this.food = food;
        String comb = site + " " + food;
        int length = comb.length();
        for (int i = 0; i < length; i++) {
            String charac = comb.substring(i, i + 1);
            if (charac.equals(" ")) {
                searchTerm += "+";
            } else {
                searchTerm += charac;
            }
        }
    }

    public String googleURL(){
        googleSearch = googleSearchRoot + searchTerm;
        return googleSearch;
    }
}
