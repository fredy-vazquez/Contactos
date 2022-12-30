package com.frvazquez.app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.frvazquez.app.model.Contacto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private  ListView lstContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cargarContactos();
        verDetalles();
    }

    private void verDetalles() {
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetalleContactoActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(i).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(i).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(i).getEmail());
                startActivity(intent);
                finish();
            }
        });
    }

    private void cargarContactos() {
        contactos = new ArrayList<>();

        contactos.add(new Contacto("Fredy", "9817771122", "fredy@gmail.com"));
        contactos.add(new Contacto("Bety", "9812001111", "bety@gmail.com"));
        contactos.add(new Contacto("Gaby", "9812002222", "gaby@gmail.com"));
        contactos.add(new Contacto("Jose", "9812003333", "jose@gmail.com"));
        contactos.add(new Contacto("Alex", "9812004444", "alex@gmail.com"));
        contactos.add(new Contacto("Gene", "9812005555", "gene@gmail.com"));
        contactos.add(new Contacto("Chelo", "9812005100", "chelo@gmail.com"));

         lstContactos = findViewById(R.id.lstContactos);

        List<String> nombres = contactos.stream()
                .map(Contacto::getNombre)
                .collect(Collectors.toList());
        lstContactos
                .setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres));


    }


}