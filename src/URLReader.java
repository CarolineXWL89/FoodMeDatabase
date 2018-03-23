import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by princ on 23/03/2018.
 */
public class URLReader {

    private String HTMLCode = "";

    public URLReader(String URL){}

    /**
     * Takes the URL input and returns an HTML code.
     * @param URL
     * @return HTML code for webpage
     */
    public String readerReturn(String URL){
        java.net.URL oracle = null;
        BufferedReader in = null;
        String inputLine;
        try {
            oracle = new URL(URL);
            in = new BufferedReader(
                    new InputStreamReader(oracle.openStream()));
            while ((inputLine = in.readLine()) != null)
                //System.out.println(inputLine);
                HTMLCode += inputLine;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HTMLCode;
    }
}
