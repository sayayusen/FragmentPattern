package jp.eure.android.sample.FragmentPattern.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jp.eure.android.sample.FragmentPattern.R;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/04/05
 * Time: 19:38
 * To change this template use File | Settings | File Templates.
 */
public class Tab1Fragment extends Fragment {

	private View mView;

	public static Tab1Fragment newInstance() {
		final Tab1Fragment f = new Tab1Fragment();
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		mView = inflater.inflate(R.layout.tab1_view, container, false);

		return mView;
	}
}
