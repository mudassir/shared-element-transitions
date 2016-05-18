package io.github.mudassir.sharedelementtransitions;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ActivityTransitionActivity extends AppCompatActivity {

	public static final String IMAGE_ID = "random.image.id";
	public static final String IMAGE_URL_KEY = "random.image.url.key";

	private static final String IMAGE_URL = "https://raw.githubusercontent.com/mudassir/shared-element-transitions/master/img/android.png";

	@Override
	@SuppressWarnings("ConstantConditions")
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_transition);

		// Load image initially
		Glide.with(this)
				.load(IMAGE_URL)
				.into((ImageView) findViewById(R.id.img_activity_transition_main));

		findViewById(R.id.img_activity_transition_main).setOnClickListener(view -> {
			Intent intent = new Intent(this, ActivityTransitionSubactivity.class);
			intent.putExtra(IMAGE_URL_KEY, IMAGE_URL);

			// Specify the view to transition through an ID. Can be more than one.
			ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, new Pair<>(view, IMAGE_ID));

			// Start the Activity and send the transition details through the bundle
			ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
		});
	}
}
