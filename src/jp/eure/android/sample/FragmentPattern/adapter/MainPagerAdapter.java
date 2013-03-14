package jp.eure.android.sample.FragmentPattern.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import jp.eure.android.sample.FragmentPattern.fragment.FirstFragment;
import jp.eure.android.sample.FragmentPattern.fragment.FourthFragment;
import jp.eure.android.sample.FragmentPattern.fragment.SecondFragment;
import jp.eure.android.sample.FragmentPattern.fragment.ThirdFragment;
import jp.eure.android.sample.FragmentPattern.util.DLog;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/03/14
 * Time: 13:20
 * To change this template use File | Settings | File Templates.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

	private FirstFragment mFirstFragment;
	private SecondFragment mSecondFragment;
	private ThirdFragment mThirdFragment;
	private FourthFragment mFourthFragment;


	public void OnActionBtnClickListener(){};

	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	private boolean isNull(Fragment f) {
		return f==null?true:false;
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Fragment getItem(int position) {

		switch (position) {
			case 0:
				if (isNull(mFirstFragment)) {
					mFirstFragment = new FirstFragment() {
						@Override
						public void onActionBtnClickHandler() {
							super.onActionBtnClickHandler();
							OnActionBtnClickListener();
						}
					};
				}
				return mFirstFragment;
			case 1:
				if (isNull(mSecondFragment)) {
					mSecondFragment = SecondFragment.newInstance();
				}
				return mSecondFragment;
			case 2:
				if (isNull(mThirdFragment)) {
					mThirdFragment = ThirdFragment.newInstance();
				}
				return mThirdFragment;
			case 3:
				if (isNull(mFourthFragment)) {
					mFourthFragment = FourthFragment.newInstance();
				}
				return mFourthFragment;
			default:
				return null;
		}
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
		DLog.v("destroyItem:"+position);
	}
}
