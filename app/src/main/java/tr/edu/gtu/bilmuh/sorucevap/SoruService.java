package tr.edu.gtu.bilmuh.sorucevap;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sunum on 2/20/16.
 */
public interface SoruService {
    @GET("sorular.json")
    Call<Sorular> listSorular();
}
