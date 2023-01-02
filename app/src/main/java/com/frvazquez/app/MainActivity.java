package com.frvazquez.app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;


import com.frvazquez.app.adaptador.ContactoAdaptador;
import com.frvazquez.app.model.Contacto;

import java.util.ArrayList;


@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarContactos();
        iniciarRecycleView();
        verDetalles();
    }

    private void iniciarRecycleView() {
        listaContactos = findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(glm);
        iniciarlizarAdaptador();
    }


    private void iniciarlizarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    private void verDetalles() {
       /* lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContactoActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });*/
    }

    private void cargarContactos() {
        contactos = new ArrayList<>();

        contactos.add(new Contacto("Fredy", "9817771122", "fredy@gmail.com", R.drawable.apple_9));
        contactos.add(new Contacto("Bety", "9812001111", "bety@gmail.com", R.drawable.banana_9));
        contactos.add(new Contacto("Gaby", "9812002222", "gaby@gmail.com", R.drawable.candy_9));
        contactos.add(new Contacto("Jose", "9812003333", "jose@gmail.com", R.drawable.lemon_9));
        contactos.add(new Contacto("Alex", "9812004444", "alex@gmail.com", R.drawable.melon_9));
        contactos.add(new Contacto("Gene", "9812005555", "gene@gmail.com", R.drawable.mushrooms_9));
        contactos.add(new Contacto("Chelo", "9812005100", "chelo@gmail.com", R.drawable.rave_9));

    }


}