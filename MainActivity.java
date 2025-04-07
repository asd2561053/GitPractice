package com.android.filechooser.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.iusenko.filechooser.FileChooserActivity;

public class MainActivity extends Activity {
	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startActivityForResult(new Intent(this, FileChooserActivity.class), FileChooserActivity.PICK_UP_FILE_REQUEST);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(TAG, "onActivityResult(" + requestCode + ", " + resultCode + ",...)");
		if (FileChooserActivity.FILE_SELECTED_RESULT != resultCode) {
			return;
		}
		String path = data.getStringExtra(FileChooserActivity.SELECTED_FILE_KEY);
		Log.d(TAG, "Selected file: " + path);
		super.onActivityResult(requestCode, resultCode, data);
	}
}