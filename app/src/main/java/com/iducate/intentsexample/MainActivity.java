package com.iducate.intentsexample;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	/* you can see a list of intents and their meaning here:
	   NOTE: press ctrl down and then you can click on the link below
	@see <a href="http://developer.android.com/reference/android/content/Intent.html"> this link </a>
	 */
	public void browseWeb(View view) {
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("http://www.google.com"));
		startActivity(intent);		
	}

	public void showMap(View view) {
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("geo:26.934,-80.106"));
		PackageManager packageManager = getPackageManager();
		List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,
		        PackageManager.MATCH_DEFAULT_ONLY);

		//Check if we have any apps that can handle the geo urls
		if (activities.size()>0)
			startActivity(intent); //yes, start the app chooser.
		else
		{ //no, notify user about this
			Toast toast = Toast.makeText(getApplicationContext(), "No Map Activity registered", Toast.LENGTH_LONG);
			toast.show();
		}
	}

	//start the phone chooser.
	public void makeCall(View view) {
		Intent intent = new Intent(android.content.Intent.ACTION_DIAL,
				Uri.parse("tel:+82345623"));
		startActivity(intent);
	}
}
