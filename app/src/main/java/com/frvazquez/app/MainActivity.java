package com.frvazquez.app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.frvazquez.app.adaptador.ContactoAdaptador;
import com.frvazquez.app.adaptador.PaginaAdaptador;
import com.frvazquez.app.fragment.PerfilFragment;
import com.frvazquez.app.fragment.RecyclerViewFragment;
import com.frvazquez.app.model.Contacto;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    private ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private Toolbar toolbar;
    private TabLayout tableLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarViews();
        setUpViewPage();

        if(toolbar == null) {
            setSupportActionBar(toolbar);
        }
        //cargarContactos();
        //iniciarRecycleView();
    }

    private void iniciarViews() {
        toolbar = findViewById(R.id.toolbar);
        tableLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
    }

    private ArrayList<Fragment> agregarFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPage() {
        viewPager.setAdapter(new PaginaAdaptador(getSupportFragmentManager(), agregarFragment()));
        tableLayout.setupWithViewPager(viewPager);
    }


    private void iniciarRecycleView() {
        listaContactos = findViewById(R.id.rvContactos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(llm);
        iniciarlizarAdaptador();
    }


    private void iniciarlizarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, this);
        listaContactos.setAdapter(adaptador);
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