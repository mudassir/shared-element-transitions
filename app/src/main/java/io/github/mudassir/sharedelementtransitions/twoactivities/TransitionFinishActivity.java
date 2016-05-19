package io.github.mudassir.sharedelementtransitions.twoactivities;

import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.github.mudassir.sharedelementtransitions.R;

public class TransitionFinishActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transition_finish);

		// Specify the view where the transition should finish
		ViewCompat.setTransitionName(findViewById(R.id.img_activity_transition_sub), TransitionStartActivity.IMAGE_ID);

		// Load the image, the transition will be taken care of by the system
		Glide.with(this)
				.load(getIntent().getStringExtra(TransitionStartActivity.IMAGE_URL_KEY))
				.into((ImageView) findViewById(R.id.img_activity_transition_sub));
	}
}
