package org.maktab.masoudbn.flexiblefragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TehranTourismDetailActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    public static String TOURISM_PLACE_ID = "tourism_place_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tehran_tourism_detail);
        int id = getIntent().getIntExtra(TOURISM_PLACE_ID, 0);


        fragmentManager = getSupportFragmentManager();
        TehranTourismDetailFragment tehranTourismDetailFragment = TehranTourismDetailFragment.newInstance(id);

        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout_details_container, tehranTourismDetailFragment)
                .commit();
    }
}
