package hlg.game.learing.mario;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class MarioGame implements ApplicationListener {

	GameStage gameStage;
	StartStage startStage;
	StoreStage storeStage;
	
	
	@Override
	public void create() {		
		gameStage = new GameStage();
		startStage = new StartStage();
		storeStage = new StoreStage();
		
	}

	public void selectStageRender(){
		
		if(Constants.Stageflag == Constants.StartStageOn){
			Gdx.input.setInputProcessor(startStage);
			//startStage.act();
			startStage.draw();
		}else if (Constants.Stageflag == Constants.GameStageOn) {
			Gdx.input.setInputProcessor(gameStage);
			//gameStage.act();
			gameStage.draw();
		}else if (Constants.Stageflag == Constants.StoreStageOn) {
			Gdx.input.setInputProcessor(storeStage);
			//storeStage.act();
			storeStage.draw();
		}
	}
	@Override
	public void dispose() {
		this.gameStage.dispose();
		this.startStage.dispose();
		this.storeStage.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		selectStageRender();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

}
