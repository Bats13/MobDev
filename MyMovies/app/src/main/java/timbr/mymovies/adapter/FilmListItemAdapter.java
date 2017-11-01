package timbr.mymovies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import timbr.mymovies.R;
import timbr.mymovies.activity.FilmDetailsActivity;
import timbr.mymovies.model.Film;

/**
 * Created by timbr on 15-10-2017.
 */

public class FilmListItemAdapter extends RecyclerView.Adapter<FilmListItemAdapter.ViewHolder> {

    final Context context;
    private final List<Film> filmArrayList;

    public FilmListItemAdapter(List<Film> list, Context context) {
        filmArrayList = list;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return filmArrayList.size();
    }

    private Film getItem(int position) {
        return filmArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return filmArrayList.get(position).getId();
    }

    public void updateList(List<Film> newlist) {
        // Set new updated list
        filmArrayList.clear();
        filmArrayList.addAll(newlist);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_film_item, parent, false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //Populate the row
        holder.populateRow(getItem(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView title;
        private final TextView type;
        private final TextView status;
        private final TextView date;
        //initialize the variables

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.filmTitle);
            type = (TextView) view.findViewById(R.id.filmType);
            status = (TextView) view.findViewById(R.id.filmStatus);
            date = (TextView) view.findViewById(R.id.filmDate);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, FilmDetailsActivity.class);
            Film selectedFilm = getItem(getAdapterPosition());
            intent.putExtra("selectedFilm", selectedFilm);

            context.startActivity(intent);
        }

        public void populateRow(Film film) {

            title.setText(film.getTitle());
            type.setText(film.getType());
            status.setText(film.getFilmStatus());
            date.setText(film.getDateAdded());
        }
    }
}
