package id.sch.smktelkom_mlg.privateassignment.xirpl518.updatingmovie;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanda on 15/05/2017.
 */
public class PopularFragment extends Fragment {

    private static final String URL_DATA = "https://api.themoviedb.org/3/movie/popular?api_key=fa3aaf4614da022556b744ebb7d33982&language=en-US&page=1";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<PopularListItem> listItems;

    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popular, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewAve);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        listItems = new ArrayList<>();

        loadRecyclerViewData();


        return view;
    }

    private void loadRecyclerViewData() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading data.....");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() { //aksi ketika api terload
                    @Override
                    public void onResponse(String s) {
                        progressDialog.dismiss(); // mematikan dialog loading ketika berhasil mengload

                        try {
                            JSONObject jsonObject = new JSONObject(s);

                            JSONArray array = jsonObject.getJSONArray("results");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                PopularListItem item = new PopularListItem(
                                        o.getString("poster_path"), //kalau ada kurung//kalau ada kurung
                                        o.getString("title"), //langsung titik dua
                                        o.getString("overview")
                                );
                                listItems.add(item);
                            }

                            adapter = new PopularAdapter(listItems, getActivity().getApplicationContext()); //mengirim ke adapter
                            recyclerView.setAdapter(adapter); //menampilkan ke xml

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() { //memunculkan apabila api tidak terload
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressDialog.dismiss();
                        Toast.makeText(getActivity().getApplicationContext(), volleyError
                                .getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }


}