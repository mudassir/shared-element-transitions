package io.github.mudassir.sharedelementtransitions.twofragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.mudassir.sharedelementtransitions.R;

public class FragmentTransitionActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_transition);

		getFragmentManager().beginTransaction()
				.add(R.id.frame_layout, new FirstFragment())
				.addToBackStack("init")
				.commit();
	}

	@Override
	public void onBackPressed() {
		// No idea why this doesn't work properly
		if (getFragmentManager().getBackStackEntryCount() == 0) {
			super.onBackPressed();
		} else {
			getFragmentManager().popBackStack();
		}
	}
}
