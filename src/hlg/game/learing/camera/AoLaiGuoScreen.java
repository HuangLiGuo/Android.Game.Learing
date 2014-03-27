package hlg.game.learing.camera;

import hlg.game.learing.mario.Mario;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class AoLaiGuoScreen implements Screen, GestureListener  {

	private Game game;
	private Stage stage;
	private Texture ttMap;
	private Mario mario;
	private ScreenCamera screenCamera;
	
	public AoLaiGuoScreen(Game game)
	{
		this.game = game;
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.ttMap.dispose();
		this.screenCamera.clear();
		this.stage.dispose();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean pan(float arg0, float arg1, float arg2, float arg3) {
		// TODO Auto-generated method stub
		this.screenCamera.Translation(-arg2, arg3);
		return false;
	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		this.stage.draw();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.stage = new Stage();
		this.mario = new Mario(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 4);
		this.screenCamera = new ScreenCamera("camera/aolaiguo.jpg", this.stage); 
		this.stage.addActor(this.screenCamera);
		this.stage.addActor(this.mario);
		Gdx.input.setInputProcessor(new GestureDetector(this));
	}

	@Override
	public boolean fling(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		//this.screenCamera.Translation(-arg0, arg1);
		return false;
	}

	@Override
	public boolean longPress(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean panStop(float arg0, float arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pinch(Vector2 arg0, Vector2 arg1, Vector2 arg2, Vector2 arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean tap(float arg0, float arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(float arg0, float arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean zoom(float arg0, float arg1) {
		// TODO Auto-generated method stub
		this.screenCamera.setScale(arg1/arg0);
		return false;
	}

}
