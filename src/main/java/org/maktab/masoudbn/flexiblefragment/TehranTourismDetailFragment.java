package org.maktab.masoudbn.flexiblefragment;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class TehranTourismDetailFragment extends Fragment {

    private static TourismPlace tourismPlace;
    private int id;
    private TextView tvTitle;
    private TextView tvAddress;
    private TextView tvDetails;
    private ImageView imvPlaceImage;


    public TehranTourismDetailFragment() {
        // Required empty public constructor
    }

    public static TehranTourismDetailFragment newInstance(int id)
    {
        TehranTourismDetailFragment tehranTourismDetailFragment = new TehranTourismDetailFragment();
        Bundle args = new Bundle();
        args.putInt(TehranTourismDetailActivity.TOURISM_PLACE_ID, id);
        tehranTourismDetailFragment.setArguments(args);
        return tehranTourismDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tehran_tourism_detail, container, false);
        int id =  getArguments().getInt(TehranTourismDetailActivity.TOURISM_PLACE_ID, 0);
        tourismPlace = TourismLab.getInstance(getActivity().getResources()).getTourismPlace(id);

        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvAddress = (TextView) view.findViewById(R.id.tvAddress);
        tvDetails = (TextView) view.findViewById(R.id.tvDetails);
        imvPlaceImage = (ImageView) view.findViewById(R.id.imvPlaceImage);

         updateUI(id);

        return view;
    }


    public void updateUI(int id)
    {

        tourismPlace.setId(id);
        tvTitle.setText(tourismPlace.getTitle());
        tvAddress.setText(tourismPlace.getAddress());
        tvDetails.setText(tourismPlace.getDetails());

        try {
            imvPlaceImage.setImageResource(R.drawable.class.getField(tourismPlace.getImageName()).getInt(null));
        }
        catch (Exception e)
        {
            imvPlaceImage.setImageResource(R.drawable.img0);
        }
    }
}
