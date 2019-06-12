package com.lmorocho.requestapp.services;

import com.lmorocho.requestapp.models.Solicitud;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String API_BASE_URL = "https://requests-lab.herokuapp.com/api/";

    @GET("solicitudes/")
    Call<List<Solicitud>> obtenerSolicitudes();
}
