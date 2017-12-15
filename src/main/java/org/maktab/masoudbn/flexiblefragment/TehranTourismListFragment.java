package org.maktab.masoudbn.flexiblefragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TehranTourismListFragment extends Fragment {

    RecyclerView recyclerViewTourismList;
    TourismAdapter tourismAdapter;
    public TehranTourismListFragment() {
        // Required empty public constructor
    }

    public static TehranTourismListFragment newInstance()
    {
        TehranTourismListFragment tehranTourismListFragment = new TehranTourismListFragment();
        return  tehranTourismListFragment;
    }

    private class TourismHolder extends RecyclerView.ViewHolder{
        private TextView tvTitle;
        private TourismPlace tourismPlace;

        public TourismHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!TehranTourismListActivity.isUsingTablet) {
                        Intent intent = new Intent(getActivity(), TehranTourismDetailActivity.class);
                        intent.putExtra(TehranTourismDetailActivity.TOURISM_PLACE_ID, tourismPlace.getId());
                        startActivity(intent);
                    }else {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                FragmentManager fragmentManager = getFragmentManager();
                                TehranTourismDetailFragment tehranTourismDetailFragment = TehranTourismDetailFragment.newInstance(tourismPlace.getId());
                                fragmentManager.beginTransaction()
                                        .replace(R.id.frame_layout_details_container, tehranTourismDetailFragment)
                                        .commit();
                            }
                        });
                    }
                }
            });
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
        }

        public void setUI(TourismPlace tourismPlace)
        {
            this.tourismPlace = tourismPlace;

            tvTitle.setText(tourismPlace.getTitle());
        }
    }
    private class TourismAdapter extends RecyclerView.Adapter<TourismHolder>{
        private List<TourismPlace> tourismPlaces;

        public TourismAdapter(List<TourismPlace> tourismPlaces) {
            this.tourismPlaces = tourismPlaces;
        }
        @Override
        public int getItemCount() {
            return tourismPlaces.size();
        }

        @Override
        public TourismHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            View view = inflater.inflate(R.layout.list_item_tourism_place, parent, false);

            TourismHolder tourismHolder = new TourismHolder(view);
            return tourismHolder;
        }

        @Override
        public void onBindViewHolder(TourismHolder holder, int position) {
            TourismPlace tourismPlace = tourismPlaces.get(position);
            holder.setUI(tourismPlace);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tehran_tourism_list, container, false);
        recyclerViewTourismList = (RecyclerView)view.findViewById(R.id.list_recycler_view);
        recyclerViewTourismList.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI() {
        List<TourismPlace> tourismPlaces= TourismLab.getInstance(getActivity().getResources()).getTourismPlaces();

        if(tourismAdapter == null){
            tourismAdapter = new TourismAdapter(tourismPlaces);
            recyclerViewTourismList.setAdapter(tourismAdapter);
        } else {
            tourismAdapter.notifyDataSetChanged();
        }

    }
}
