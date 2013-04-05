package jp.eure.android.sample.FragmentPattern.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import jp.eure.android.sample.FragmentPattern.R;
import jp.eure.android.sample.FragmentPattern.adapter.StatePagerAdapter;
import jp.eure.android.sample.FragmentPattern.util.DLog;

import java.lang.Override;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/03/14
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class AnotherFragment extends Fragment {

	private View mView;
	private ViewPager mStatePager;
	private Button mButton1;
	private Button mButton2;

	private List<String> mList;

	private StatePagerAdapter mStatePagerAdapter;

	public static AnotherFragment newInstance() {
		final AnotherFragment f = new AnotherFragment();
		return f;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mList = new ArrayList<String>();
		for (int i = 0; i < 100; i++) {
			mList.add(String.valueOf(i));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		mView = (View)inflater.inflate(R.layout.another_view, container, false);

		mStatePager = (ViewPager)mView.findViewById(R.id.state_pager);
		mStatePager.setId(R.id.state_pager);

		mStatePagerAdapter = new StatePagerAdapter(getActivity().getSupportFragmentManager(), mList);
		mStatePager.setAdapter(mStatePagerAdapter);
		mStatePager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int i, float v, int i2) {
			}

			@Override
			public void onPageSelected(int i) {
			}

			@Override
			public void onPageScrollStateChanged(int i) {
				DLog.v("statePagerScrollStateChanged!");
			}
		});

		mButton1 = (Button)mView.findViewById(R.id.button1);
		mButton2 = (Button)mView.findViewById(R.id.button2);

		mButton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DLog.v("Another Button1 clicked!");
			}
		});
		mButton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DLog.v("Another Button2 clicked!");
			}
		});

		return mView;
	}
}
