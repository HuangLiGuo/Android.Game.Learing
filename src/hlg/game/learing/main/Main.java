package hlg.game.learing.main;

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
		
		//this.ini
		this.initialize(new TextureGame(), true);
	}

}