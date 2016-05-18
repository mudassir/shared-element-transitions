package io.github.mudassir.sharedelementtransitions;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ActivityTransitionSubactivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subactivity_activity_transition);

		// Specify the view where the transition should finish
		ViewCompat.setTransitionName(findViewById(R.id.img_activity_transition_sub), ActivityTransitionActivity.IMAGE_ID);

		// Load the image, the transition will be taken care of by the system
		Glide.with(this)
				.load(getIntent().getStringExtra(ActivityTransitionActivity.IMAGE_URL_KEY))
				.into((ImageView) findViewById(R.id.img_activity_transition_sub));
	}
}
