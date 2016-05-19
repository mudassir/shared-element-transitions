package io.github.mudassir.sharedelementtransitions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.mudassir.sharedelementtransitions.twoactivities.TransitionStartActivity;
import io.github.mudassir.sharedelementtransitions.twofragments.FragmentTransitionActivity;

public class MainActivity extends AppCompatActivity {

	public static final String IMAGE_URL = "https://raw.githubusercontent.com/mudassir/shared-element-transitions/master/img/android.png";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btn_two_activities).setOnClickListener(view ->
				startActivity(new Intent(this, TransitionStartActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));

		findViewById(R.id.btn_two_fragments).setOnClickListener(view ->
				startActivity(new Intent(this, FragmentTransitionActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)));
	}
}
