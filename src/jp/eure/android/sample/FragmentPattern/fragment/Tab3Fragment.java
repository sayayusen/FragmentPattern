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
public class Tab3Fragment extends Fragment {

	private View mView;

	public static Tab3Fragment newInstance() {
		final Tab3Fragment f = new Tab3Fragment();
		return f;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		mView = inflater.inflate(R.layout.tab3_view, container, false);

		return mView;
	}
}
