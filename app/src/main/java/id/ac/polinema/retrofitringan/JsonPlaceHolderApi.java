package id.ac.polinema.retrofitringan;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {
    @GET("siswa")
    Call<List<Post>> getPost();

    @GET("siswa")
    Call<List<Post>> getPostById(@Query("id_siswa")String id_siswa);

    @POST("siswa")
    Call<ResponseBody>createPost(@Body Post post);

    @PUT("siswa")
    Call<ResponseBody>editPost(@Body Post post);
}
