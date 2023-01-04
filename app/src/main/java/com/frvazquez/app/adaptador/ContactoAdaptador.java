package com.frvazquez.app.adaptador;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.frvazquez.app.DetalleContactoActivity;
import com.frvazquez.app.R;
import com.frvazquez.app.model.Contacto;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    private ArrayList<Contacto> contactos;
    private Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {
        this.contactos = contactos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        Contacto contacto = contactos.get(position);
        contactoViewHolder.ivFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombre.setText(contacto.getNombre());
        contactoViewHolder.tvTelefono.setText(contacto.getTelefono());
        contactoViewHolder.tvEmail.setText(contacto.getEmail());

        contactoViewHolder.ivFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContactoActivity.class);
                intent.putExtra("Nombre", contacto.getNombre());
                intent.putExtra("Telefono", contacto.getTelefono());
                intent.putExtra("Email", contacto.getEmail());
                activity.startActivity(intent);
                activity.finish();
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a "+contacto.getNombre(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFoto;
        private TextView tvNombre;
        private TextView tvTelefono;
        private TextView tvEmail;
        private ImageButton btnLike;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvTelefono = itemView.findViewById(R.id.tvTelefono);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            btnLike = itemView.findViewById(R.id.btnLike);
        }
    }

}
