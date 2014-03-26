package hlg.game.learing.camera;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class CameraGame implements ApplicationListener {

	private Stage stage;
	private Texture ttMap;
	private Image imgMap;
	//private SpriteBatch batch;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		this.stage = new Stage();
		FileHandle fileHandle = Gdx.files.internal("camera/aolaiguo.jpg");
		this.ttMap = new Texture(fileHandle, true);
		//this.batch = new SpriteBatch();
		//TextureRegion region = new TextureRegion(this.ttMap, 0, 0, 512, 512);
		this.imgMap = new Image(this.ttMap);
		//this.imgMap.setScale(1.0f);
		this.stage.addActor(this.imgMap);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.ttMap.dispose();
		this.imgMap.clear();
		this.stage.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
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

}
