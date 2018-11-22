package com.phamngoclinh.loginfbfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    private Toolbar toolbar;
    private FrameLayout viewPager;
    private BottomNavigationView tabLayout;
    private Homefragment homefragment;
    private Historyfragment historyfragment;
    private Tablefragment tablefragment;
    private Menufragment menufragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        AnhXa();
        onClick();
        fragment();
        setFragment(homefragment);
    }

    void AnhXa() {
        historyfragment = new Historyfragment();
        homefragment = new Homefragment();
        tablefragment = new Tablefragment();
        menufragment = new Menufragment();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        toolbar.setTitle("Vivee");
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    void onClick() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.closeDrawers();
                } else {
                    drawerLayout.openDrawer(navigationView);
                }
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ic_DX:
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
                break;
        }
        drawerLayout.closeDrawer(Gravity.START);
        return false;
    }

    void fragment(){
        tabLayout.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        setFragment(homefragment);
                        return true;
                    case R.id.menu:
                        setFragment(menufragment);
                        return true;
                    case R.id.table:
                        setFragment(tablefragment);
                        return true;
                    case R.id.history:
                        setFragment(historyfragment);
                        return true;
                    default:
                        return false;
                }

            }
        });
    }

    private void setFragment(Fragment viewpagerAdapter) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.viewPager,viewpagerAdapter);
        fragmentTransaction.commit();
    }

}
