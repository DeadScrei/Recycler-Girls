package com.appspot.bgje0341.petagram;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public static ArrayList<Mascota> mascotas;
    public static ArrayList<Mascota> seleccion = new ArrayList<Mascota>();
    static int fav=0;

    public Adapter (ArrayList<Mascota> mascotas){
        this.mascotas=mascotas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla el cardview a el Layput
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        //Setea los valores de Mascota, Asosia los elementos de la lista con cada view

        final Mascota mascota = mascotas.get(position);

        viewHolder.imgPrincipal.setImageResource(mascota.getImagen());
        viewHolder.imgHA.setImageResource(mascota.getHuesoA());
        viewHolder.imgHB.setImageResource(mascota.getHuesoB());
        viewHolder.nombre.setText(mascota.getNombre());
        viewHolder.like.setText(Integer.toString(mascota.getLike()));
        viewHolder.imgHA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setLike(mascota.getLike() + 1);

            }
        });
        viewHolder.imgHB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Me ah gustado "+mascota.getNombre(),Snackbar.LENGTH_SHORT).show();

                seleccion.add(new Mascota(mascota.getImagen(),mascota.getHuesoB(),mascota.getHuesoA(),mascota.getNombre(),mascota.getLike()));
            }
        });
    }

    @Override
    public int getItemCount() { //Cantidad de elementos de la lista
        return mascotas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPrincipal;
        private ImageView imgHA;
        private ImageView imgHB;
        private TextView nombre;
        private TextView like;

        public ViewHolder(View itemView) {
            super(itemView);
            imgPrincipal = (ImageView) itemView.findViewById(R.id.imgPrincipal);
            imgHA = (ImageView) itemView.findViewById(R.id.imgHA);
            imgHB = (ImageView) itemView.findViewById(R.id.imgHB);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            like = (TextView) itemView.findViewById(R.id.numero);
        }
    }
}
