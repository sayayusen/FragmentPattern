package jp.eure.android.sample.FragmentPattern.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import jp.eure.android.sample.FragmentPattern.R;
import jp.eure.android.sample.FragmentPattern.activity.MainActivity;
import jp.eure.android.sample.FragmentPattern.util.DLog;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/04/05
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */
public class TabsFragment extends Fragment {

	private MainActivity mMainActivity;

	private View mView;
	private Button[] mTabs;
	private Button mTab1;
	private Button mTab2;
	private Button mTab3;

	private static final int TAB1 = 0;
	private static final int TAB2 = 1;
	private static final int TAB3 = 2;

	public static TabsFragment newInstance() {
		final TabsFragment f = new TabsFragment();
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

		mTabs = new Button[3];
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		mView = inflater.inflate(R.layout.tabs_view, container, false);

		mTab1 = (Button)mView.findViewById(R.id.tab1);
		mTab2 = (Button)mView.findViewById(R.id.tab2);
		mTab3 = (Button)mView.findViewById(R.id.tab3);

		mTabs[0] = mTab1;
		mTabs[1] = mTab2;
		mTabs[2] = mTab3;

		mTab1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DLog.v("detail tab1 clicked!");
				setFragment(TAB1);
			}
		});

		mTab2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DLog.v("detail tab2 clicked!");
				setFragment(TAB2);
			}
		});

		mTab3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DLog.v("detail tab3 clicked!");
				setFragment(TAB3);
			}
		});

		// DefaultFragment
		setFragment(TAB1);

		return mView;
	}

	// Setting Button(Like Tab)
	private void setSelectButton(int tabId) {

		Button selectedTab = (Button)mTabs[tabId];

		for (int i=0; i<mTabs.length; i++) {
			if (i != tabId) {
				DLog.v("NO"+tabId);
				selectedTab.setBackgroundColor(Color.GRAY);
			} else {
				DLog.v("SELECT"+tabId);
				selectedTab.setBackgroundColor(Color.GREEN);
			}
		}
	}

	// Setting Fragment
	private void setFragment(int fragmentId) {

		FragmentManager fragmentManager = mMainActivity.getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		Fragment fragment = null;

		switch (fragmentId) {
			case TAB1:
				Tab1Fragment tab1Fragment = Tab1Fragment.newInstance();
				fragment = tab1Fragment;
				break;
			case TAB2:
				Tab2Fragment tab2Fragment = Tab2Fragment.newInstance();
				fragment = tab2Fragment;
				break;
			case TAB3:
				Tab3Fragment tab3Fragment = Tab3Fragment.newInstance();
				fragment = tab3Fragment;
				break;
		}
		//setSelectButton(fragmentId);
		fragmentTransaction.replace(R.id.detail_fragment, fragment);
		//fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
}
