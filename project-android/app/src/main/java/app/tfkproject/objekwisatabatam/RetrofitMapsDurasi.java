package app.tfkproject.objekwisatabatam;

import app.tfkproject.objekwisatabatam.util.jarak.Example;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by taufik on 22/04/18.
 */

public interface RetrofitMapsDurasi {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
     */
    @GET("api/directions/json?")
    Call<Example> getDistanceDuration(@Query("units") String units, @Query("origin") String origin, @Query("destination") String destination, @Query("mode") String mode);

}