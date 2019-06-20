package com.example.atulc.red;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.atulc.blackspot_sih.R;
import com.google.firebase.auth.FirebaseAuth;

public class AccountFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account_fragment_layout,container,false);

        Button donot_registration = view.findViewById(R.id.donor_registration);
        ImageView vertical_dots_menu = view.findViewById(R.id.vert_dots);

        vertical_dots_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(getContext(), v);
                popup.inflate(R.menu.user_profile_menu);

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()){
                            case R.id.logout_menu:
                                FirebaseAuth.getInstance().signOut();
                                Intent intent = new Intent(getContext(),MainActivity.class);
                                startActivity(intent);
                                break;

                        }

                        return false;
                    }
                });
                popup.show();
            }
        });

        donot_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment registrationFragment = new RegisterFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.profile_frameLayout,registrationFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
