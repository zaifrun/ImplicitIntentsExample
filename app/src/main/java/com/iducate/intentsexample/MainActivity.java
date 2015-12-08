package com.iducate.intentsexample;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

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
	
		if (activities.size()>0)
			startActivity(intent);
		else
		{
			Toast toast = Toast.makeText(getApplicationContext(), "No Map Activity registered", Toast.LENGTH_LONG);
			toast.show();
		}
	}

	public void makeCall(View view) {
		Intent intent = new Intent(android.content.Intent.ACTION_DIAL,
				Uri.parse("tel:+82345623"));
		startActivity(intent);
	}
}
