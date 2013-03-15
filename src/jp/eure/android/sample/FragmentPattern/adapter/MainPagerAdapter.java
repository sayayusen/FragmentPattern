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

	public void OnActionBtnClickListener(){};

	public MainPagerAdapter(FragmentManager fm) {
		super(fm);
		DLog.d("MainPagerAdapter create");
	}

	@Override
	public int getCount() {
		return 4;
	}

	@Override
	public Fragment getItem(int position) {

		switch (position) {
		case 0: return FirstFragment.newInstance();
		case 1: return SecondFragment.newInstance();
		case 2: return ThirdFragment.newInstance();
		case 3: return FourthFragment.newInstance();
		default: return null;

		}
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		super.destroyItem(container, position, object);
		DLog.v("destroyItem:"+position);
	}
}
