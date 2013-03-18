package jp.eure.android.sample.FragmentPattern.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import jp.eure.android.sample.FragmentPattern.R;
import jp.eure.android.sample.FragmentPattern.activity.MainActivity;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/03/14
 * Time: 12:07
 * To change this template use File | Settings | File Templates.
 */

public class FirstFragment extends Fragment {

	private MainActivity mMainActivity;
	private Button mActionBtn;


	public void onActionBtnClickHandler(){};

	public static FirstFragment newInstance() {
		final FirstFragment f = new FirstFragment();
		return f;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mMainActivity = (MainActivity)activity;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = (View)inflater.inflate(R.layout.first_view, container, false);

		mActionBtn = (Button)view.findViewById(R.id.action_btn);
		mActionBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mMainActivity.openAnotherFragment();
			}
		});
		return view;
	}
}
