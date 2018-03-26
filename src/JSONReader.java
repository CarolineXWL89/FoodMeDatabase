import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

public class JSONReader {
    private FoodNetwork apiFoodNetwork;
    //amishi wants brownies

    public JSONReader() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FoodNetwork.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiFoodNetwork = retrofit.create(FoodNetwork.class);
        makeCall();
    }

    public void makeCall() {
        Call<FoodNetworkRecipe> call = apiFoodNetwork.getRecipe();
        call.enqueue(new Callback<FoodNetworkRecipe>() {
            @Override
            public void onResponse(Call<FoodNetworkRecipe> call, Response<FoodNetworkRecipe> response) {
                FoodNetworkRecipe recipe = response.body();
                //todo create backenless object to send
                Recipe r = new Recipe();
                System.out.println(recipe.toString());
            }

            @Override
            public void onFailure(Call<FoodNetworkRecipe> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
