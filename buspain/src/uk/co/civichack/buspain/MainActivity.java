package uk.co.civichack.buspain;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;

public class MainActivity extends Activity {

	private Button late = null;
	private Button arrive = null;
	private Button start = null;
	private Button reset = null;
	private TimePicker expectedTime = null;
	private int expectedTime_hour, expectedTime_minute;
	private int waitingminutes = 0;
	

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
		expectedTime = (TimePicker) this.findViewById(R.id.bus_expectedtime);

		setListeners();
	}

	private void setListeners() {
		
		arrive.setEnabled(false);
		late.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				late.setEnabled(false);
				arrive.setEnabled(true);
				expectedTime_hour = (Integer) expectedTime.getTag(Calendar.HOUR_OF_DAY);
				expectedTime_minute = (Integer) expectedTime.getTag(Calendar.MINUTE);
				Date nowTime = new Date();
				if(nowTime.getHours() > expectedTime_hour){
					if(nowTime.getMinutes() > expectedTime_minute){
						waitingminutes = 60*(nowTime.getHours()-expectedTime_hour) + 
								nowTime.getMinutes() - expectedTime_minute;
					}
					else{
						waitingminutes = 60*(nowTime.getHours()-expectedTime_hour) +
								expectedTime_minute - nowTime.getMinutes();
					}
				}
				else{
					waitingminutes = nowTime.getMinutes() - expectedTime_minute;
				}
			}
			
			
		});
		arrive.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				late.setEnabled(true);
				arrive.setEnabled(false);
			}
			
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
