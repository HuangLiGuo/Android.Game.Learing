package hlg.game.learing.changscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class LoadingScreen implements Screen {

	private ScreenGame game;
	private Stage stage;
	private AnimationImage aniImgLoading;
	private float loadingTime;
	
	public LoadingScreen(ScreenGame game) {
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
		if(this.loadingTime > 3) {
			this.game.setScreen(this.game.gameScreen);
			this.dispose();
		}
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		this.loadingTime += Gdx.graphics.getDeltaTime();
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
		this.loadingTime = 0;
		this.intAni();
		this.stage.addActor(this.aniImgLoading);
	}

	private void intAni(){
		TextureRegion[][] arrayOfTextureRegion = TextureRegion.split(new Texture(Gdx.files.internal("changscreen/loading.png")), 100, 100);
		TextureRegion[] arrayOfTextureRegion1 = new TextureRegion[12];
		arrayOfTextureRegion1[0] = arrayOfTextureRegion[0][0];
		arrayOfTextureRegion1[1] = arrayOfTextureRegion[0][1];
	    arrayOfTextureRegion1[2] = arrayOfTextureRegion[0][2];
	    arrayOfTextureRegion1[3] = arrayOfTextureRegion[0][3];
	    arrayOfTextureRegion1[4] = arrayOfTextureRegion[0][4];
	   	arrayOfTextureRegion1[5] = arrayOfTextureRegion[1][0];
	   	arrayOfTextureRegion1[6] = arrayOfTextureRegion[1][1];
	   	arrayOfTextureRegion1[7] = arrayOfTextureRegion[1][2];
	   	arrayOfTextureRegion1[8] = arrayOfTextureRegion[1][3];
	  	arrayOfTextureRegion1[9] = arrayOfTextureRegion[1][4];
	  	arrayOfTextureRegion1[10] = arrayOfTextureRegion[2][0];
	  	arrayOfTextureRegion1[11] = arrayOfTextureRegion[2][1];
	  	this.aniImgLoading = new AnimationImage(0.1f, arrayOfTextureRegion1);
	  	this.aniImgLoading.setPosition(Gdx.graphics.getWidth() / 2 - this.aniImgLoading.getWidth() / 2, Gdx.graphics.getHeight() / 2 - this.aniImgLoading.getHeight() / 2);
	}
}
