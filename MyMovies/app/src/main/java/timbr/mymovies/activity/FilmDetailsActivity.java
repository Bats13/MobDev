package timbr.mymovies.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import timbr.mymovies.R;
import timbr.mymovies.model.Film;

/**
 * Created by timbr on 15-10-2017.
 */

public class FilmDetailsActivity extends AppCompatActivity {

    private Film film;
    private TextView title;
    private TextView platform;
    private TextView status;
    private TextView date;
    private TextView notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Get the film from the intent, which was passed as parameter
        this.film = (Film) getIntent().getSerializableExtra("selectedFilm");
        setFilmViews();


    }

    public void setFilmViews() {
        title = (TextView) findViewById(R.id.detailTitle);
        platform = (TextView) findViewById(R.id.detailType);
        status = (TextView) findViewById(R.id.detailStatusB);
        date = (TextView) findViewById(R.id.detailDateB);
        notes = (TextView) findViewById(R.id.detailNotesB);

        title.setText(film.getTitle());
        platform.setText(film.getType());
        status.setText(film.getFilmStatus());
        date.setText(film.getDateAdded());
        notes.setText(film.getNotes());
    }

}
