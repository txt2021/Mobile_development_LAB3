package ua.kpi.comsys.iv8228;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Fragment3 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Context context = requireActivity().getApplicationContext();
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        Scanner scanner = new Scanner(getResources().openRawResource(R.raw.movieslist));
        try {
            String data = scanner.nextLine();
            JSONObject jsonObject = new JSONObject(data);
            ArrayList<Movie> library = processingJsonObj(jsonObject);
            recyclerView.setAdapter(new MovieAdapter(library));
        } catch (JSONException e) {
            Toast.makeText(context, "JSON exception!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (NoSuchElementException e){
            Toast.makeText(context, "Exception while scanning file!", Toast.LENGTH_SHORT).show();
        }

    }
    private ArrayList<Movie> processingJsonObj(JSONObject jsonObject) throws JSONException {
        JSONArray moviesInJSON = jsonObject.getJSONArray("Search");
        ArrayList<Movie> library = new ArrayList<>();
        for (int i = 0; i < moviesInJSON.length(); i++) {
            JSONObject value = moviesInJSON.getJSONObject(i);
            String Title = value.getString("Title");
            String Year = value.getString("Year");
            String imdbID = value.getString("imdbID");
            String Type = value.getString("Type");
            String Poster = value.getString("Poster").toLowerCase();
            int formatIndex = Poster.lastIndexOf(".");
            if(formatIndex == -1)
                formatIndex = 0;
            String post = Poster.substring(0, formatIndex);

            int PosterID = getResources().getIdentifier(post, "drawable", getContext().getPackageName());
            library.add(new Movie(Title, Year, imdbID, Type, PosterID));
        }
        Toast.makeText(getActivity().getApplicationContext(), "here", Toast.LENGTH_SHORT).show();
        return library;

    }
}