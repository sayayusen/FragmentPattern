package jp.eure.android.sample.FragmentPattern.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import jp.eure.android.sample.FragmentPattern.R;
import jp.eure.android.sample.FragmentPattern.fragment.MainFragment;
import jp.eure.android.sample.FragmentPattern.util.DLog;

/**
 * Created with IntelliJ IDEA. User: pixie3 Date: 2013/03/14 Time: 12:06 To
 * change this template use File | Settings | File Templates.
 */
public class MainActivity extends BaseActivity implements
	MainFragment.OnCurrentPageChangeListener {

	private MainFragment mMainFragment;
	private FragmentManager mFragmentManger;
	private FragmentTransaction mFragmentTrasaction;

	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main_view);
	DLog.d("MainActivity onCreate");


	if (savedInstanceState == null) {
		mFragmentManger = getSupportFragmentManager();
		mFragmentTrasaction = mFragmentManger.beginTransaction();
		mMainFragment = MainFragment.newInstance();
		mFragmentTrasaction.replace(R.id.main_fragment, mMainFragment);
		mFragmentTrasaction.addToBackStack(null);
		mFragmentTrasaction.commit();
	}
}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		mMainFragment.setPage(itemPosition);
		return super.onNavigationItemSelected(itemPosition, itemId);
	}

	@Override
	public void onChangeCurrentPage(int currentPage) {
		mActionBar.setSelectedNavigationItem(currentPage);
	}
}