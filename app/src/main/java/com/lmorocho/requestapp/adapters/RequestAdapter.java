package com.lmorocho.requestapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lmorocho.requestapp.R;
import com.lmorocho.requestapp.models.Solicitud;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.ViewHolder> {

    private List<Solicitud> solicitudes;

    public RequestAdapter(){
        this.solicitudes = new ArrayList<>();
    }

    public void setRequest(List<Solicitud> solicitudes){
        this.solicitudes = solicitudes;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView fotoImage;
        public TextView tituloText;
        public TextView emailText;
        public TextView descripcionText;

        public ViewHolder(View itemView) {
            super(itemView);
            fotoImage = itemView.findViewById(R.id.foto_image);
            tituloText = itemView.findViewById(R.id.title_text);
            emailText = itemView.findViewById(R.id.email_text);
            descripcionText = itemView.findViewById(R.id.description_text);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_request, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        Solicitud solicitud = this.solicitudes.get(position);

//        viewHolder.tituloText.setText(solicitud.getTitulo());
//        viewHolder.emailText.setText(solicitud.getEmail());
//        viewHolder.descripcionText.setText(solicitud.getDescripcion());
//
//        String url = ApiService.API_BASE_URL + "/productos/images/" + solicitud.getImagen();
//        Picasso.with(viewHolder.itemView.getContext()).load(url).into(viewHolder.fotoImage);

    }

    @Override
    public int getItemCount() {
        return this.solicitudes.size();
    }

}

