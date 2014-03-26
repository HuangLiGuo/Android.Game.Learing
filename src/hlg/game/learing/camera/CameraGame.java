package hlg.game.learing.camera;

import com.badlogic.gdx.Game;

public class CameraGame extends Game {

	public AoLaiGuoScreen aolaiguoScreen;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		this.aolaiguoScreen = new AoLaiGuoScreen(this);
		
		this.setScreen(this.aolaiguoScreen);
	}

}
