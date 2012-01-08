package com.github.jonaldomo.WhoopeeCushion;

import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class WhoopeeCushionActivity extends Activity {
	private SoundPool pool;
	private HashMap<Integer, Integer> soundsMap;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		pool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        soundsMap = new HashMap<Integer, Integer>();
		soundsMap.put(1, pool.load(this, R.raw.fart1, 1));
		soundsMap.put(2, pool.load(this, R.raw.fart2, 1));
		soundsMap.put(3, pool.load(this, R.raw.fart3, 1));
		soundsMap.put(4, pool.load(this, R.raw.fart4, 1));
		soundsMap.put(5, pool.load(this, R.raw.fart5, 1));
		soundsMap.put(6, pool.load(this, R.raw.fart6, 1));
		soundsMap.put(7, pool.load(this, R.raw.fart7, 1));
		soundsMap.put(8, pool.load(this, R.raw.fart8, 1));
	}

	public void playSound(View v) {		
		int random = 1 + (int) (Math.random() * ((8 - 1) + 1));
		pool.play(soundsMap.get(random), 1.0f, 1.0f, 0, 0, 1.0f);
	}
	
	public void launchPaid(View v){
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("market://details?id=com.github.jonaldomo.WhoopeeCushionDeluxe"));
		startActivity(intent);
	}
}