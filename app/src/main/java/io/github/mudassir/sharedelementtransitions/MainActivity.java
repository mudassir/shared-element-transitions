package io.github.mudassir.sharedelementtransitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btn_two_activities).setOnClickListener(view -> Toast.makeText(view.getContext(), "test", Toast.LENGTH_SHORT).show());

		Glide.with(this)
				.load("https://raw.githubusercontent.com/mudassir/shared-element-transitions/master/img/android.png")
				.into((ImageView) findViewById(R.id.img));
	}
}
