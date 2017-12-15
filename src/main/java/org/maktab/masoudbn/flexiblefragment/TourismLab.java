package org.maktab.masoudbn.flexiblefragment;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by MasoudBN on 01/12/2017.
 */

public class TourismLab {
    private static TourismLab tourismLab;
    private List<TourismPlace> tourismPlaces;
    private static Resources resources;

    public static TourismLab getInstance(Resources contextResources)
    {
        if(tourismLab!=null)
            return tourismLab;
        //This code is for get app resources like arrays
        resources = contextResources;
        tourismLab = new TourismLab();
        return tourismLab;
    }

    private TourismLab() {
        tourismPlaces = new ArrayList<>();
        String[] titles = resources.getStringArray(R.array.tourism_place_titles);;
        String[] addresses = resources.getStringArray(R.array.tourism_place_addresses);
        String[] details = resources.getStringArray(R.array.tourism_place_details);

        //Set information for every tourism place
        for (int i=0;i<titles.length;i++)
        {
            TourismPlace tourismPlace = new TourismPlace();
            tourismPlace.setTitle(titles[i]);
            tourismPlace.setAddress(addresses[i]);
            tourismPlace.setDetails(details[i]);
            tourismPlace.setImageName("img" + (i+1));
            tourismPlace.setId(i);
            tourismPlaces.add(tourismPlace);
        }

    }

    public int getCount()
    {
        return tourismPlaces.size();
    }

    public List<TourismPlace> getTourismPlaces()
    {
     return tourismPlaces;
    }

    public TourismPlace getTourismPlace(int id)
    {
        for(TourismPlace tourismPlace: tourismPlaces)
        {
            if(tourismPlace.getId()==id)
                return tourismPlace;
        }
        return null;
    }
	
	public int setNumber() {
		return 1;
	}
}
