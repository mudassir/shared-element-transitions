package io.github.mudassir.sharedelementtransitions.twofragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.github.mudassir.sharedelementtransitions.MainActivity;
import io.github.mudassir.sharedelementtransitions.R;

public class SecondFragment extends Fragment {

	public SecondFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_second, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Glide.with(this)
				.load(MainActivity.IMAGE_URL)
				.into((ImageView) view.findViewById(R.id.img_second_fragment));
	}
}
