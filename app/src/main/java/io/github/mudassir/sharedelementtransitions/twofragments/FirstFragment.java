package io.github.mudassir.sharedelementtransitions.twofragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import io.github.mudassir.sharedelementtransitions.MainActivity;
import io.github.mudassir.sharedelementtransitions.R;

public class FirstFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_first, container, false);
	}

	@Override
	public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(v, savedInstanceState);

		Glide.with(this)
				.load(MainActivity.IMAGE_URL)
				.into((ImageView) v.findViewById(R.id.img_first_fragment));

		v.findViewById(R.id.img_first_fragment).setOnClickListener(view -> {

			// Must specify the transitions to be used
			TransitionSet transition = new TransitionSet()
					.setOrdering(TransitionSet.ORDERING_TOGETHER)
					.addTransition(new ChangeTransform())
					.addTransition(new ChangeBounds());

			/*
			 * Could also be done through XML
			 * <?xml version="1.0" encoding="utf-8"?>
			 * <transitionSet xmlns:android="http://schemas.android.com/apk/res/android">
			 *     <changeTransform />
			 *     <changeBounds />
			 *     </transitionSet>
			 */

			// Provide details for the image to transition *out* of this fragment
			setSharedElementReturnTransition(transition);
			setExitTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.fade));

			// Provide details for the image to transition *into* the next fragment
			Fragment secondFragment = new SecondFragment();
			secondFragment.setSharedElementEnterTransition(transition);
			secondFragment.setEnterTransition(TransitionInflater.from(getActivity()).inflateTransition(android.R.transition.fade));

			getFragmentManager().beginTransaction()
					.replace(R.id.frame_layout, secondFragment)
					.addToBackStack("transition")
					.addSharedElement(view, getString(R.string.two_fragments_transition_id))
					.commit();
		});
	}
}
