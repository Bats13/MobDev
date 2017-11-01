package timbr.mymovies.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import timbr.mymovies.R;
import timbr.mymovies.adapter.FilmListItemAdapter;
import timbr.mymovies.model.Film;

public class MainActivity extends AppCompatActivity {
    private RecyclerView filmListView;
    private FilmListItemAdapter mAdapter;
    private List<Film> mFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setting-up recycler viewer
        filmListView = (RecyclerView) findViewById(R.id.filmList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        filmListView.setLayoutManager(mLayoutManager);
        filmListView.setHasFixedSize(true);

        mFilms = new ArrayList<>();

        mFilms.add(new Film(0, "hallo", "hallo", "hallo", "hallo", "hallo"));
        mFilms.add(new Film(1, "tralla", "tralla", "tralla", "tralla", "tralla"));

        FilmListItemAdapter mAdapter = new FilmListItemAdapter(mFilms, this);
        filmListView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onResume() {
        super.onResume();  // Always call the superclass method first
        updateUI();
    }

    private void updateUI() {
        if (mAdapter == null) {
            mAdapter = new FilmListItemAdapter(mFilms, this);
            filmListView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

}
