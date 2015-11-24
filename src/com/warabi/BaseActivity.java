package com.warabi;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class BaseActivity extends Activity {
	static protected MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(mp==null) {
			mp = MediaPlayer.create(this, R.raw.bgm);
			mp.setLooping(true);
		}
	}

	protected void mpChange(int bgm) {
		mp = MediaPlayer.create(this,  bgm);
		mp.setLooping(true);
	}
	protected void  mpStart() {
		if(!mp.isPlaying()) {
			mp.start();
		}
	}

	protected void mpStop() {
		if(mp.isPlaying()) {
			mp.stop();
		}
	}
}
