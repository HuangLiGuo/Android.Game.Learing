package hlg.game.learing.changscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameScreen implements Screen {

	private ScreenGame game;
	private Stage stage;
	private Image imgBackground;
	private ImageButton imgBtnExit;
	
	public GameScreen(ScreenGame game) {
		this.game = game;
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
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
	public void render(float arg0) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//Gdx.gl.glClearColor(0, 0, 0, 1);
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
		Gdx.input.setInputProcessor(this.stage);
		this.imgBackground = new Image(new TextureRegion(new Texture(Gdx.files.internal("changscreen/nam.png")), 0, 0, 512, 512));
		this.imgBackground.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Texture ctlBtnTexture = new Texture(Gdx.files.internal("changscreen/control.png"));
		this.imgBtnExit = new ImageButton(new TextureRegionDrawable(new TextureRegion(ctlBtnTexture, 0, 0, 64, 64)),
				new TextureRegionDrawable(new TextureRegion(ctlBtnTexture, 64, 0, 64, 64)));
		this.imgBtnExit.setPosition(20, 20);
		this.imgBtnExit.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				if(!(x < 0 || y < 0 || x > imgBtnExit.getWidth() || y > imgBtnExit.getHeight())) {
					game.setScreen(game.startScreen);
					game.gameScreen.dispose();
				}
				super.touchUp(event, x, y, pointer, button);
			}
			
		});
		this.stage.addActor(this.imgBackground);
		this.stage.addActor(this.imgBtnExit);
	}

}
