package org.maktab.masoudbn.flexiblefragment;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TehranTourismListActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    public static boolean isUsingTablet=false;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_tehran_tourism_list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tehran_tourism_list);

        if(savedInstanceState!=null)
            return;
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TehranTourismListFragment tehranTourismListFragment = TehranTourismListFragment.newInstance();
        fragmentTransaction.add(R.id.frame_layout_list_container, tehranTourismListFragment);
        //If we use tablet
        if(findViewById(R.id.frame_layout_details_container)!=null)
        {
            TehranTourismDetailFragment tehranTourismDetailFragment = TehranTourismDetailFragment.newInstance(0);
            fragmentTransaction.add(R.id.frame_layout_details_container, tehranTourismDetailFragment);
            isUsingTablet=true;
        }
        fragmentTransaction.commit();
    }
}
