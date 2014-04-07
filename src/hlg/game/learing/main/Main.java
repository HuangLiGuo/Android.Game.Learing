package hlg.game.learing.main;

import hlg.game.learing.camera.ActionGame;
import hlg.game.learing.camera.CameraGame;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;

public class Main extends AndroidApplication {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		//cfg.useGL20 = true;
		
		this.initialize(new CameraGame(), true);
	}

}