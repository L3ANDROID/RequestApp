package com.lmorocho.requestapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.lmorocho.requestapp.R;
import com.lmorocho.requestapp.SolicitudServiceGenerator;
import com.lmorocho.requestapp.adapters.SolicitudAdapter;
import com.lmorocho.requestapp.models.Solicitud;
import com.lmorocho.requestapp.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView solicitudesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solicitudesList = findViewById(R.id.solicitudes_list);
        solicitudesList.setLayoutManager(new LinearLayoutManager(this));

        solicitudesList.setAdapter(new SolicitudAdapter());

        initialize();
    }

    private void initialize() {

        ApiService service = SolicitudServiceGenerator.createService(ApiService.class);

        Call<List<Solicitud>> call = service.obtenerSolicitudes();

        call.enqueue(new Callback<List<Solicitud>>() {
            @Override
            public void onResponse(Call<List<Solicitud>> call, Response<List<Solicitud>> response) {
                try {

                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Solicitud> solicitudes = response.body();
                        Log.d(TAG, "Solicitudes: " + solicitudes);

                        SolicitudAdapter adapter = (SolicitudAdapter) solicitudesList.getAdapter();
                        adapter.setSolicitudes(solicitudes);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }catch (Throwable x){}
                }
            }

            @Override
            public void onFailure(Call<List<Solicitud>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

}
