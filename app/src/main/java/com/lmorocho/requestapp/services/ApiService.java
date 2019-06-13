package com.lmorocho.requestapp.services;

import com.lmorocho.requestapp.models.Solicitud;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    String API_BASE_URL = "https://requests-lab.herokuapp.com/api/";

    @GET("solicitudes/")
    Call<List<Solicitud>> obtenerSolicitudes();

    @FormUrlEncoded
    @POST("solicitudes/")
    Call<Solicitud> createProducto(@Field("correo") String correo,
                                         @Field("tipo") String tipo,
                                         @Field("descripcion") String descripcion);
    /*@Multipart
    @POST("solicitudes/")
    Call<Solicitud> createProductoWithImage(
            @Part("correo") RequestBody correo,
            @Part("tipo") RequestBody tipo,
            @Part("descripcion") RequestBody descripcion
    );*/

}
