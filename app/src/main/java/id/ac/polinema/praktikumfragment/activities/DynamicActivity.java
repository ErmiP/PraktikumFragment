package id.ac.polinema.praktikumfragment.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import id.ac.polinema.praktikumfragment.R;
import id.ac.polinema.praktikumfragment.fragment.BlueFragment;
import id.ac.polinema.praktikumfragment.fragment.RedFragment;


public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
    }
    public void handleClickLoadRedFragment(View view) {

        Fragment fragment= getSupportFragmentManager().findFragmentById(R.id.dynamic_fragment_placeholder);

        if (fragment == null || fragment instanceof BlueFragment) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.replace(R.id.dynamic_fragment_placeholder, new RedFragment(), "RED_FRAGMENT");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void handleClickLoadBlFragment(View view) {

        Fragment fragment= getSupportFragmentManager().findFragmentById(R.id.dynamic_fragment_placeholder);

        if (fragment == null || fragment instanceof RedFragment) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.replace(R.id.dynamic_fragment_placeholder, new BlueFragment(), "BLUE_FRAGMENT");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
