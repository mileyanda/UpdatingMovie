package id.sch.smktelkom_mlg.privateassignment.xirpl518.updatingmovie.NewestDB;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import id.sch.smktelkom_mlg.privateassignment.xirpl518.updatingmovie.R;
/**
 * Created by yanda on 15/05/2017.
 */

public class FavoriteFragment extends Fragment {

    ArrayList<NewestDBItem> fList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewFav);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        fList = new ArrayList<>();

        adapter = new NewestDBAdapter(fList, getActivity().getApplicationContext());
        recyclerView.setAdapter(adapter);

        fList.addAll(NewestDBItem.listAll(NewestDBItem.class));
        adapter.notifyDataSetChanged();

        return view;
    }

}