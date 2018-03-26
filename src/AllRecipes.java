import java.util.ArrayList;

/**
 * Created by princ on 25/03/2018.
 */
public class AllRecipes {

    private static String ingredientsStartTag = "<label ng-class=\"{true: 'checkList__item'}[true]\" title=\"";
    private static String ingredientsEndTag = "\">";
    private static String basicsStartTag = "var reviewsInitialSet = {\"";
    private static String recipeIDTag = "recipeId\":";
    private static String recipeNameTag = ",\"recipeTitle\":\"";
    private static String imageURLTag = "\",\"recipeImageUrl\":\"";
    private static String originalImageTag = "\",\"heroImage\":\"";
    private static String fullReviewTag = "\",\"reviews\":{";
    //private static String --> if we want reviews
    private static String directionsStartTag = "<span class=\"recipe-directions__list--item\">";
    private static String directionsEndTag = "</span></li>";
    private static String timeStartTags = "<span class=\"prepTime__item--time\">"; //do we want tips?
    private static String spanTag = "</span> ";
    private static String timeTag = "</time>";
    //private static String nutritionTags???
    private static String urlStartTag = "   <link itemprop=\"url\" href=\"";
    private static String urlEndTag = "\" />\n";
    private ArrayList<String> ingredients = new ArrayList<>();
    private ArrayList<String> steps = new ArrayList<>();
    private ArrayList<String> basicParts = new ArrayList<>();
    private ArrayList<String> timeParts = new ArrayList<>();
    private String url = "";

    public AllRecipes(String url) {
        this.url = url;
    }

    public ArrayList<String> getIngredients(String htmlCode) {
        int l = htmlCode.length();
        int lst = ingredientsStartTag.length();
        for (int i = 0; i < l; i++) {
            String tested = htmlCode.substring(i, i + lst);
            if (tested.equals(ingredientsStartTag)) {
                htmlCode.substring(i + lst);
                int end = htmlCode.indexOf(ingredientsEndTag);
                String ingredient = htmlCode.substring(i + lst, end);
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    public ArrayList<String> getSteps(String htmlCode) {
        int l = htmlCode.length();
        int lst = directionsStartTag.length();
        for (int i = 0; i < l; i++) {
            String tested = htmlCode.substring(i, i + lst);
            if (tested.equals(directionsStartTag)) {
                htmlCode.substring(i + lst);
                int end = htmlCode.indexOf(directionsEndTag);
                String direction = htmlCode.substring(i + lst, end);
                steps.add(direction);
            }
        }
        return steps;
    }

        public ArrayList<String> getBasicParts(String htmlCode){
        int start = htmlCode.indexOf(basicsStartTag) + basicsStartTag.length();
        htmlCode = htmlCode.substring(start);
        int idStart = htmlCode.indexOf(recipeIDTag) + recipeIDTag.length();
        int titleStart = htmlCode.indexOf(recipeNameTag) + recipeNameTag.length();
        int imageStart = htmlCode.indexOf(imageURLTag) + imageURLTag.length();
        int originalStart = htmlCode.indexOf(originalImageTag) + originalImageTag.length();
        int fullRevStart = htmlCode.indexOf(fullReviewTag) + fullReviewTag.length();
        String recipeID = htmlCode.substring(idStart, titleStart - recipeNameTag.length() + 1);
        basicParts.add(recipeID);
        String title = htmlCode.substring(titleStart, imageStart - imageURLTag.length() + 1);
        basicParts.add(title);
        String imageURLSquare = htmlCode.substring(imageStart, originalStart - originalImageTag.length() + 1);
        basicParts.add(imageURLSquare);
        String imageOriginal = htmlCode.substring(originalStart, fullRevStart - fullReviewTag.length() + 1);
        basicParts.add(imageOriginal);
        return basicParts;
        }

        public ArrayList<String> getTimeParts(String htmlCode){
            int l = htmlCode.length();
            int lst = timeStartTags.length();
            for (int i = 0; i < l; i++) {
                String tested = htmlCode.substring(i, i + lst);
                if (tested.equals(timeStartTags)) {
                    htmlCode.substring(i + lst);
                    int end1 = htmlCode.indexOf(spanTag);
                    String span = htmlCode.substring(i + lst, end1);
                    timeParts.add(span);

                    int end2 = htmlCode.indexOf(timeTag);
                    String time = htmlCode.substring(i + lst + span.length() + end1, end2);
                    timeParts.add(time);
                }
            }
            return timeParts;
        }

        public String urlConstruction(String htmlCode){
            int urlStart = htmlCode.indexOf(urlStartTag) + urlStartTag.length();
            int urlEnd = htmlCode.indexOf(urlEndTag);
            url = htmlCode.substring(urlStart, urlEnd);
            return url;
        }
    }


