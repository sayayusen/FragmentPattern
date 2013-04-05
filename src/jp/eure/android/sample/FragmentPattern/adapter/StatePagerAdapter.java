package jp.eure.android.sample.FragmentPattern.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import jp.eure.android.sample.FragmentPattern.fragment.TabsFragment;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/04/05
 * Time: 18:39
 * To change this template use File | Settings | File Templates.
 */
public class StatePagerAdapter extends FragmentStatePagerAdapter {

	private List<String> mList;

	public StatePagerAdapter(FragmentManager fm, List<String> list) {
		super(fm);
		mList = list;
	}

	@Override
	public Fragment getItem(int position) {
		TabsFragment f = TabsFragment.newInstance();
		Bundle args = new Bundle();
		args.putInt("position", position);
		f.setArguments(args);
		return f;
	}

	@Override
	public int getCount() {
		return mList.size();
	}
}
