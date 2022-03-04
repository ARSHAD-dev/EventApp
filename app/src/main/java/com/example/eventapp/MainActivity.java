package com.example.eventapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private Button Tech;
    private Button Dance;
    private Button Drama;
    private Button Art;
    private Button Literary;
    private Button Music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigview);
        navigationView.setNavigationItemSelectedListener(this);
        Tech = findViewById(R.id.tech);
        Dance = findViewById(R.id.dance);
        Drama = findViewById(R.id.drama);
        Art = findViewById(R.id.art);
        Literary = findViewById(R.id.literary);
        Music = findViewById(R.id.music);
        Tech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii=new Intent(MainActivity.this,TechActivity.class);
                    ii.putExtra("value",1);
                startActivity(ii);
            }
        });
        Art.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ia=new Intent(MainActivity.this,TechActivity.class);
                ia.putExtra("value",4);
                startActivity(ia);
            }
        });
        Music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ia=new Intent(MainActivity.this, TechActivity.class);
                ia.putExtra("value",3);
                startActivity(ia);
            }
        });

        Dance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ia=new Intent(MainActivity.this, TechActivity.class);
                ia.putExtra("value",2);
                startActivity(ia);
            }
        });
        Drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ia=new Intent(MainActivity.this, TechActivity.class);
                ia.putExtra("value",5);
                startActivity(ia);
            }
        });
        Literary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ia=new Intent(MainActivity.this, TechActivity.class);
                ia.putExtra("value",6);
                startActivity(ia);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item))
        {
            return  true;
        }
        else
        {
            return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Society()).commit();
                Toast.makeText(this, "Welcome to the Society page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this, "Events Page", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, EventsActivity.class);
                break;
            case R.id.logout:
                Toast.makeText(this, "About Us!!", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new aboutus()).commit();
                break;


        }
        mDrawerlayout.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerlayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}