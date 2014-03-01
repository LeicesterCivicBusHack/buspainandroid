package uk.co.civichack.buspain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	private Button late = null;
	private Button arrive = null;
	private Button start = null;
	private Button reset = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		TimePicker t = (TimePicker) this.findViewById(R.id.timePicker1);
		t.setIs24HourView(true);

		late = (Button) this.findViewById(R.id.button1);
		arrive = (Button) this.findViewById(R.id.button2);
		start = (Button) this.findViewById(R.id.start);
		reset = (Button) this.findViewById(R.id.bus_reset);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
