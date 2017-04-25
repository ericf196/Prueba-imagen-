package com.rm.Sign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rm.Sign.fragments.ProyectosPendientesFragment;

/**
 * Created by Riccardo on 01/12/16.
 */

public class ActivityChooser extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chooser);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        ProyectosPendientesFragment fragment = new ProyectosPendientesFragment();
        fragmentTransaction.replace(R.id.content_main, fragment);
        fragmentTransaction.commit();

    }

}
