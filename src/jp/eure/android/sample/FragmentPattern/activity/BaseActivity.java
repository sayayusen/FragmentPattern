package jp.eure.android.sample.FragmentPattern.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import jp.eure.android.sample.FragmentPattern.R;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/03/14
 * Time: 12:49
 * To change this template use File | Settings | File Templates.
 */
public class BaseActivity extends SherlockFragmentActivity implements ActionBar.OnNavigationListener {

	protected ActionBar mActionBar;
	protected Context mContext;
	protected ArrayAdapter<CharSequence> mListAdapter;
	protected MenuInflater mMenuInflater;
	protected FragmentManager mFragmentManger;
	protected FragmentTransaction mFragmentTrasaction;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mContext = getApplicationContext();

		setTheme(R.style.Theme_Sherlock);
		mActionBar = getSupportActionBar();
		mActionBar.setDisplayShowTitleEnabled(false);
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayHomeAsUpEnabled(true);
		mActionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

		Context context = mActionBar.getThemedContext();
		mListAdapter = ArrayAdapter.createFromResource(context, R.array.root_locations, R.layout.sherlock_spinner_item);
		mListAdapter.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);
		mActionBar.setListNavigationCallbacks(mListAdapter, this);
	}

	public void changeActionMode(boolean isBack) {
		mActionBar = getSupportActionBar();
		mActionBar.setNavigationMode(isBack? ActionBar.NAVIGATION_MODE_STANDARD: ActionBar.NAVIGATION_MODE_LIST);
		mActionBar.setDisplayShowHomeEnabled(isBack);
		mActionBar.setDisplayHomeAsUpEnabled(isBack);
		mActionBar.setHomeButtonEnabled(isBack);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		mMenuInflater = getSupportMenuInflater();
		mMenuInflater.inflate(R.menu.menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				getSupportFragmentManager().popBackStack();
				changeActionMode(false);
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		switch (event.getKeyCode()) {
			case KeyEvent.KEYCODE_BACK:
				changeActionMode(false);
				break;
		}
		return super.dispatchKeyEvent(event);
	}
}