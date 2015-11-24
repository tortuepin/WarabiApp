package com.warabi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class StatusActivity extends BaseActivity {


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_status);
		mpStart();
		mpChange(R.raw.bgm);
		mpStart();

		SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
		int hp = data.getInt("HP", 0);
		int at = data.getInt("攻撃力", 0);
		int def = data.getInt("防御力", 0);
		int swe = data.getInt("甘さ", 0);
		int text = data.getInt("食感",0);
		int eng = data.getInt("英語力", 0);
		int sp = data.getInt("足の早さ", 0);
		int fas = data.getInt("オシャレ度", 0);
		int song = data.getInt("歌唱力", 0);
		int act = data.getInt("演技力", 0);
		int sur = data.getInt("対空性能", 0);

		final Uri uri = Uri.parse("https://twitter.com/intent/tweet?text="
	    				+ "【丹精込めて育てたわらびもち】"+ "\n" + "HP:" + hp + "攻撃力:" + at
	    				+ "防御力:" + def + "甘さ:" + swe + "食感:" + text + "英語力:" + eng
	    				+ "足の早さ" + sp + "オシャレ度" + fas + "歌唱力" + song
	    				+ "演技力" + act + "対空性能:" + sur);

	    Button button4 = (Button)findViewById(R.id.button4);
	    button4.setText("戻る");
	    button4.setOnClickListener(new OnClickListener() {
	    	public void onClick(View v) {
	    		Intent intent = new Intent();
	    	    intent.setClassName("com.warabi", "com.warabi.MainActivity");
	    	    startActivity(intent);
	    	}
	    });
	    Button button5 = (Button)findViewById(R.id.button5);
	    button5.setText("つぶやく");
	    button5.setOnClickListener(new OnClickListener() {
	    	public void onClick(View v) {
	    		Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	    		startActivity(intent);
	    	}
	    });

	    TextView HP = (TextView)findViewById(R.id.HP);
	    HP.setText("HP:" + hp);
	    TextView Attack = (TextView)findViewById(R.id.Attack);
	    Attack.setText("攻撃力:" + at);
	    TextView Defense = (TextView)findViewById(R.id.Defense);
	    Defense.setText("防御:" + def);
	    TextView Sweetness = (TextView)findViewById(R.id.Sweetness);
	    Sweetness.setText("甘さ:" + swe);
	    TextView Texture = (TextView)findViewById(R.id.Texture);
	    Texture.setText("食感:" + text);
	    TextView English = (TextView)findViewById(R.id.English);
	    English.setText("英語力:" + eng);
	    TextView Speed = (TextView)findViewById(R.id.Speed);
	    Speed.setText("足の早さ:" + sp);
	    TextView Fashionable = (TextView)findViewById(R.id.Fashionable);
	    Fashionable.setText("オシャレ度:" + fas);
	    TextView Song = (TextView)findViewById(R.id.Song);
	    Song.setText("歌唱力:" + song);
	    TextView Act = (TextView)findViewById(R.id.Act);
	    Act.setText("演技力:" + act);
	    TextView Sur_air= (TextView)findViewById(R.id.Sur_air);
	    Sur_air.setText("対空性能:" + sur);
	}
}

