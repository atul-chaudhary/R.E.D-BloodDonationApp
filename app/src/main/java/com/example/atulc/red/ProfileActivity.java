package com.example.atulc.red;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.example.atulc.blackspot_sih.R;

public class ProfileActivity extends AppCompatActivity {
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        frameLayout = findViewById(R.id.profile_frameLayout);

        //changes the fragment
        Fragment fragment = new HomeFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.profile_frameLayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {

                case R.id.home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.maps:
                    selectedFragment = new MapsFragment();
                    break;
                case R.id.list_:
                    selectedFragment = new ListFragment();
                    break;

                case R.id.account:
                    selectedFragment = new AccountFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.profile_frameLayout, selectedFragment).commit();

            return true;

        }
    };
}
