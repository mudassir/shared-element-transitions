package io.github.mudassir.sharedelementtransitions.twoactivities;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.github.mudassir.sharedelementtransitions.MainActivity;
import io.github.mudassir.sharedelementtransitions.R;

public class TransitionStartActivity extends AppCompatActivity {

	public static final String IMAGE_ID = "random.image.id";
	public static final String IMAGE_URL_KEY = "random.image.url.key";



	@Override
	@SuppressWarnings("ConstantConditions")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transition_start);

		// Load image initially
		Glide.with(this)
				.load(MainActivity.IMAGE_URL)
				.into((ImageView) findViewById(R.id.img_activity_transition_main));

		findViewById(R.id.img_activity_transition_main).setOnClickListener(view -> {
			Intent intent = new Intent(this, TransitionFinishActivity.class);
			intent.putExtra(IMAGE_URL_KEY, MainActivity.IMAGE_URL);

			// Specify the view to transition through an ID. Can be more than one.
			ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, new Pair<>(view, IMAGE_ID));

			// Start the Activity and send the transition details through the bundle
			ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
		});
	}
}
