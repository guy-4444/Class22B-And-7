package com.guy.class22b_and_7;

import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guy.class22b_and_7.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private FloatingActionButton fab;
    private RecyclerView main_LST_posts;

    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViews();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                items.get(2).setSelected(true);
                items.get(3).setSelected(true);
                main_LST_posts.getAdapter().notifyItemChanged(3);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        items = DataManager.generateItems();
        items.get(1).setSelected(true);

        ItemAdapter itemAdapter = new ItemAdapter(this, items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        main_LST_posts.setLayoutManager(linearLayoutManager);
        main_LST_posts.setAdapter(itemAdapter);
    }

    private void findViews() {
        fab = findViewById(R.id.fab);
        main_LST_posts = findViewById(R.id.main_LST_posts);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        toolbar.setTitle("List App");
        toolbar.setSubtitle("Amazon");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}