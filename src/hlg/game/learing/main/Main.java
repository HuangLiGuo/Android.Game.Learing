package hlg.game.learing.main;

import hlg.game.learing.animation.AnimationGame;
import hlg.game.learing.camera.CameraGame;
import hlg.game.learing.changscreen.ScreenGame;
import hlg.game.learing.font.FontGame;
import hlg.game.learing.mario.MarioGame;
import hlg.game.learing.texture.TextureGame;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class Main extends AndroidApplication {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		//cfg.useGL20 = true;

		//this.initialize(new ScreenGame(), true);
		this.initialize(new CameraGame(), true);
	}

}