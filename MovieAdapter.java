package ua.kpi.comsys.iv8228;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>  {
    private ArrayList<Movie> movies;
    public MovieAdapter(ArrayList<Movie> movieList) {
        movies = movieList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView Title, Year, imdbID, Type;
        public final ImageView PosterView;
        public ViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.movie_Title);
            Year = itemView.findViewById(R.id.movie_Year);
            imdbID = itemView.findViewById(R.id.movie_imdbID);
            Type = itemView.findViewById(R.id.movie_Type);
            PosterView = itemView.findViewById(R.id.movie_Poster);
        }
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View library = inflater.inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(library);    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Movie movie = movies.get(position);
        TextView title = holder.Title;
        title.setText(movie.getTitle());
        TextView year = holder.Year;
        year.setText(movie.getYear());
        TextView imdbID = holder.imdbID;
        imdbID.setText(movie.getimdbID());
        TextView type = holder.Type;
        type.setText(movie.getType());
        ImageView posterView = holder.PosterView;
        posterView.setImageResource(movie.getPosterID());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
