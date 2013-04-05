package jp.eure.android.sample.FragmentPattern.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
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

	private View mView;
	private Button[] mTabs;
	private Button mTab1;
	private Button mTab2;
	private Button mTab3;
	private FrameLayout[] mFrameLayouts;
	private FrameLayout mTab1View;
	private FrameLayout mTab2View;
	private FrameLayout mTab3View;

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
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mTabs = new Button[3];
		mFrameLayouts = new FrameLayout[3];
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

		mTab1View = (FrameLayout)mView.findViewById(R.id.tab1_view);
		mTab2View = (FrameLayout)mView.findViewById(R.id.tab2_view);
		mTab3View = (FrameLayout)mView.findViewById(R.id.tab3_view);

		mFrameLayouts[0] = mTab1View;
		mFrameLayouts[1] = mTab2View;
		mFrameLayouts[2] = mTab3View;

		mTab1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DLog.v("detail tab1 clicked!");
				replaceView(TAB1);
			}
		});

		mTab2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DLog.v("detail tab2 clicked!");
				replaceView(TAB2);
			}
		});

		mTab3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DLog.v("detail tab3 clicked!");
				replaceView(TAB3);
			}
		});

		return mView;
	}

	// Setting Button(Like Tab)
	private void setSelectButton(int tabId) {

		Button selectedTab = (Button)mTabs[tabId];

		for (int i=0; i<mTabs.length; i++) {
			if (i != tabId) {
				selectedTab.setBackgroundColor(Color.GRAY);
			} else {
				selectedTab.setBackgroundColor(Color.GREEN);
			}
		}
	}

	// Replace View
	private void replaceView(int index) {

		for (int i=0; i<mFrameLayouts.length; i++) {
			mFrameLayouts[i].setVisibility(View.GONE);
		}
		mFrameLayouts[index].setVisibility(View.VISIBLE);
	}
}
