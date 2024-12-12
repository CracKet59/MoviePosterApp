package com.example.movieposters;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Main activity class that manages the user interface of the application.
 * This activity displays a list of movie posters and allows users to add selected posters to a watchlist.
 */
public class MainActivity extends AppCompatActivity implements PostersListener {

    private Button buttonAddToWatchlist;

    /**
     * Called when the activity is starting.
     * Initializes the user interface and sets up the data for the movie posters.
     *
     * @param savedInstanceState If the activity is being re-initialized after being shut down, this bundle contains the most recent data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Set up the RecyclerView and the "Add to Watchlist" button
        RecyclerView postersRecyclerView = findViewById(R.id.posterRecyclerView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchlist);

        // Prepare movie poster data
        List<Poster> posterList = new ArrayList<>();

        // Add movie posters with updated image sources and details
        Poster mov1 = new Poster();
        mov1.image = R.drawable.mov1;
        mov1.name = "Sprider-Man: No Way Home";
        mov1.rating = 4.7f;
        mov1.createdBy = "Jon Watts";
        mov1.story = "Spiders gather from Multiverse.";
        posterList.add(mov1);

        Poster mov2 = new Poster();
        mov2.image = R.drawable.mov2;
        mov2.name = "Howl's Moving Castle";
        mov2.rating = 4.2f;
        mov2.createdBy = "Hayao Miyazaki";
        mov2.story = "Sofia finds a way to cure her curse by loving.";
        posterList.add(mov2);

        Poster mov3 = new Poster();
        mov3.image = R.drawable.mov3;
        mov3.name = "Stranger Things: The experience";
        mov3.rating = 4.5f;
        mov3.createdBy = "Neftlix";
        mov3.story = "Continueing other season.";
        posterList.add(mov3);

        Poster mov4 = new Poster();
        mov4.image = R.drawable.mov4;
        mov4.name = "Avengers: End Game";
        mov4.rating = 4.5f;
        mov4.createdBy = "Anthony Russo, Jor Russo";
        mov4.story = "Final phase of infinity stone war.";
        posterList.add(mov4);

        Poster mov5 = new Poster();
        mov5.image = R.drawable.mov5;
        mov5.name = "Inside Out 2";
        mov5.rating = 4.5f;
        mov5.createdBy = "Kelsey Mann";
        mov5.story = "Our girl grows up and she has more complicate emotion.";
        posterList.add(mov5);

        Poster mov6 = new Poster();
        mov6.image = R.drawable.mov6;
        mov6.name = "Finding Nemo";
        mov6.rating = 4.5f;
        mov6.createdBy = "Andrew Stanton";
        mov6.story = "Nemo is caught by fishman and his father went a long way to get him.";
        posterList.add(mov6);

        Poster mov7 = new Poster();
        mov7.image = R.drawable.mov7;
        mov7.name = "The Hobbit: An unexpected story";
        mov7.rating = 4.6f;
        mov7.createdBy = "HBO";
        mov7.story = "A wonderful adventure for the hobbit.";
        posterList.add(mov7);

        Poster mov8 = new Poster();
        mov8.image = R.drawable.mov8;
        mov8.name = "Venom: The Last Dance";
        mov8.rating = 4f;
        mov8.createdBy = "Kelly Marcel";
        mov8.story = "Venom and Eddie journey is about to end.";
        posterList.add(mov8);

        Poster mov9 = new Poster();
        mov9.image = R.drawable.mov9;
        mov9.name = "Titanic";
        mov9.rating = 4.3f;
        mov9.createdBy = "James Cameron";
        mov9.story = "Love story from the first sight.";
        posterList.add(mov9);

        Poster mov10 = new Poster();
        mov10.image = R.drawable.mov10;
        mov10.name = "FAST AND FURIOUS 8";
        mov10.rating = 4.5f;
        mov10.createdBy = "Justin Lin";
        mov10.story = "High-speed action and drama.";
        posterList.add(mov10);

        final PosterAdapter posterAdapter = new PosterAdapter(posterList, this);
        postersRecyclerView.setAdapter(posterAdapter);

        // Set the listener for the "Add to Watchlist" button
        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Poster> selectedPosters = posterAdapter.getSelectedPoster();
                StringBuilder posterNames = new StringBuilder();
                for (int i = 0; i < selectedPosters.size(); i++) {
                    if (i == 0) {
                        posterNames.append(selectedPosters.get(i).name);
                    } else {
                        posterNames.append("\n").append(selectedPosters.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this, posterNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Updates the visibility of the "Add to Watchlist" button based on the poster selection state.
     *
     * @param isSelected True if at least one poster is selected; false otherwise.
     */
    @Override
    public void onPosterAction(Boolean isSelected) {
        if (isSelected) {
            buttonAddToWatchlist.setVisibility(View.VISIBLE);
        } else {
            buttonAddToWatchlist.setVisibility(View.GONE);
        }
    }
}
