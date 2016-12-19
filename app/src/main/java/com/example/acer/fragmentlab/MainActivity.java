package com.example.acer.fragmentlab;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment = new Fragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {

        case R.id.house:
            FragmentManager FM1 = getFragmentManager();
            FragmentTransaction FT1 = FM1.beginTransaction();
            FragmentHouse fhouse = new FragmentHouse();

            Fragment fthere = FM1.findFragmentById(R.id.activity_main);

            if (fthere instanceof FragmentHappy) FT1.replace(R.id.activity_main, fhouse);
            else if(fthere instanceof FragmentHouse);
            else FT1.add(R.id.activity_main,fhouse);

            FT1.addToBackStack("fhouse");
            FT1.commit();

            return(true);

        case R.id.happy:
            FragmentManager FM2 = getFragmentManager();
            FragmentTransaction FT2 = FM2.beginTransaction();
            FragmentHappy fhappy = new FragmentHappy();

            Fragment fthat = FM2.findFragmentById(R.id.activity_main);

            if (fthat instanceof FragmentHouse) FT2.replace(R.id.activity_main, fhappy);
            else if(fthat instanceof FragmentHappy);
            else FT2.add(R.id.activity_main,fhappy);

            FT2.addToBackStack("fhappy");
            FT2.commit();

            return(true);

        case R.id.exit:
            finish();
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }
}
