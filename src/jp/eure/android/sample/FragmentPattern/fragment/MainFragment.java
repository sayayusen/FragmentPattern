package jp.eure.android.sample.FragmentPattern.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import jp.eure.android.sample.FragmentPattern.R;
import jp.eure.android.sample.FragmentPattern.adapter.MainPagerAdapter;
import jp.eure.android.sample.FragmentPattern.util.DLog;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/03/14
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class MainFragment extends Fragment {

	private View mView;
	private ViewPager mMainPager;
	private MainPagerAdapter mMainPagerAdapter;

	public interface OnCurrentPageChangeListener {
		public void onChangeCurrentPage(int currentPage);
	}
	private OnCurrentPageChangeListener onCurrentPageChangeListener;

	public static MainFragment newInstance() {
		final MainFragment f = new MainFragment();
		return f;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		if (activity instanceof OnCurrentPageChangeListener == false) {
			throw new ClassCastException("error");
		}
		onCurrentPageChangeListener = ((OnCurrentPageChangeListener) activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);

		mView = (View)inflater.inflate(R.layout.main_pager_view, container, false);
		mMainPager = (ViewPager)mView.findViewById(R.id.main_pager);
		mMainPagerAdapter = new MainPagerAdapter(getActivity().getSupportFragmentManager()) {
			@Override
			public void OnActionBtnClickListener() {
				super.OnActionBtnClickListener();
				// TODO Replaces the between this and AnotherFragment
				DLog.v("action btn clicked");
			}
		};
		mMainPager.setAdapter(mMainPagerAdapter);
		mMainPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int i, float v, int i2) {
			}

			@Override
			public void onPageSelected(int i) {
			}

			@Override
			public void onPageScrollStateChanged(int i) {
				if (i==ViewPager.SCROLL_STATE_SETTLING) {
					int currentPage = mMainPager.getCurrentItem();
					onCurrentPageChangeListener.onChangeCurrentPage(currentPage);
				}
			}
		});

		return mView;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		DLog.v("Destroy");
	}

	public void setPage(int position) {
		DLog.v("setPage:"+position);
		mMainPager.setCurrentItem(position, false); // not working...why?
	}
}