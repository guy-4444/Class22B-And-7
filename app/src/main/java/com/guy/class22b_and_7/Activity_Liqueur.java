package com.guy.class22b_and_7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_Liqueur extends AppCompatActivity {

    private RecyclerView liqueur_LST_items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liquer);

        liqueur_LST_items = findViewById(R.id.liqueur_LST_items);

        ArrayList<Liqueur> liqueurs = DataManager.generateliqueurs();
        LiqueurAdapter liqueurAdapter = new LiqueurAdapter(this, liqueurs);
        liqueur_LST_items.setLayoutManager(new LinearLayoutManager(this));
        liqueur_LST_items.setHasFixedSize(true);
        liqueur_LST_items.setAdapter(liqueurAdapter);

        liqueurAdapter.setLiqueurlistener(new LiqueurAdapter.Liqueurlistener() {
            @Override
            public void clicked(Liqueur liqueur, int position) {
                Toast.makeText(Activity_Liqueur.this, liqueur.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void plus(Liqueur liqueur, int position) {
                liqueur.addAmount(1);
                liqueur_LST_items.getAdapter().notifyItemChanged(position);
            }

            @Override
            public void minus(Liqueur liqueur, int position) {
                liqueur.addAmount(-1);
                liqueur_LST_items.getAdapter().notifyItemChanged(position);
            }
        });
    }
}