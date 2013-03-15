package jp.eure.android.sample.FragmentPattern.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jp.eure.android.sample.FragmentPattern.R;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/03/14
 * Time: 12:07
 * To change this template use File | Settings | File Templates.
 */
public class SecondFragment extends Fragment {


	public static SecondFragment newInstance() {
		final SecondFragment f = new SecondFragment();
		return f;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		View view = (View)inflater.inflate(R.layout.second_view, container, false);
		return view;
	}
}