package uk.co.civichack.buspain;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ComplaintActivity extends Activity {

	int minutes = -1;
	String busNo = null;
	String busCompaney=null;
	TextView busNoTv = null;
	TextView waitingTv = null;
	TextView busCompaneyTv=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_complaint);

		busNo = this.getIntent().getStringExtra("busNo");
		busCompaney=this.getIntent().getStringExtra("busCompaney");
		minutes = this.getIntent().getIntExtra("waitingtime", -1);
		
		busNoTv=(TextView) this.findViewById(R.id.bus_no_Txt);
		waitingTv=(TextView) this.findViewById(R.id.waiting_Txt);
		busCompaneyTv=(TextView) this.findViewById(R.id.busCompaney_txt);
		
		busNoTv.setText(busNo);
		waitingTv.setText(String.valueOf(minutes));
		busCompaneyTv.setText(busCompaney);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.complaint, menu);
		return true;
	}

}
