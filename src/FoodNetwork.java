import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by maylisw on 2/8/18.
 */

public interface FoodNetwork {
    String baseURL = "http://www.rrrather.com/";
    @GET("botapi")
    Call<FoodNetworkRecipe> getRecipe(); // receives data asynchronously

}
