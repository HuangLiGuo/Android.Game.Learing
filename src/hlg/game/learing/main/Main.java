package hlg.game.learing.main;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class Main extends AndroidApplication {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.initialize(new MyGame(), false);
	}

}
