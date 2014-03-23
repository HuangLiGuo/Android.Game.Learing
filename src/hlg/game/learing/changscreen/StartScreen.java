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

public class StartScreen implements Screen {

	private ScreenGame game;
	private Stage stage;
	private Image imgBack;
	private ImageButton imgBtnStart;
	
	public StartScreen(ScreenGame game) {
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
		//this.bacth.begin();
		//this.bacth.draw(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
		//this.bacth.end();
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
		//this.bacth = new SpriteBatch();
		Texture texture = new Texture(Gdx.files.internal("changscreen/nam.png"));
		TextureRegion region = new TextureRegion(texture, 0, 512, 515, 512);
		this.imgBack = new Image(region);
		this.imgBack.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		texture = new Texture(Gdx.files.internal("changscreen/control.png"));
		this.imgBtnStart = new ImageButton(new TextureRegionDrawable(new TextureRegion(texture, 128, 0, 64, 64)),
				new TextureRegionDrawable(new TextureRegion(texture, 192, 0, 64, 64)));
		this.imgBtnStart.setPosition(20, 20);
		this.imgBtnStart.addListener(new InputListener(){

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				return true;
				//return super.touchDown(event, x, y, pointer, button);
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				if(!(x < 0 || y < 0 || x > imgBtnStart.getWidth() || y > imgBtnStart.getHeight())) {
					game.setScreen(game.loadingScreen);
					game.startScreen.dispose();
				}
				super.touchUp(event, x, y, pointer, button);
			}
			
		});
		
		this.stage.addActor(this.imgBack);
		this.stage.addActor(this.imgBtnStart);
	}

}
