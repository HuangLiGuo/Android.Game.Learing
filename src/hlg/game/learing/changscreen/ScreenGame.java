package hlg.game.learing.changscreen;

import com.badlogic.gdx.Game;

public class ScreenGame extends Game {

	public StartScreen startScreen;
	public LoadingScreen loadingScreen;
	public GameScreen gameScreen;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		this.startScreen = new StartScreen(this);
		this.loadingScreen = new LoadingScreen(this);
		this.gameScreen = new GameScreen(this);
		
		this.setScreen(this.startScreen);
	}

}
