package uk.co.civichack.buspain;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity {

	private Button report = null;
	private Button history = null;
	private Button rate = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		report = (Button) this.findViewById(R.id.report);
		history = (Button) this.findViewById(R.id.history);
		rate = (Button) this.findViewById(R.id.rate);

		setListeners();
	}

	private void setListeners() {

		report.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(intent);

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
