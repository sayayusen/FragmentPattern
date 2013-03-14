package jp.eure.android.sample.FragmentPattern.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.actionbarsherlock.app.ActionBar;
import jp.eure.android.sample.FragmentPattern.R;

/**
 * Created with IntelliJ IDEA.
 * User: pixie3
 * Date: 2013/03/14
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class TopActivity extends BaseActivity {

	private Button mStartBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top_view);

		mActionBar.hide();
		mStartBtn = (Button)this.findViewById(R.id.start_btn);
		mStartBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TopActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
