package hlg.game.learing.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame implements ApplicationListener {

	private SpriteBatch batch;
	private BitmapFont bf;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		this.batch = new SpriteBatch();
		this.bf = new BitmapFont();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.batch.dispose();
		this.bf.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		 Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
         Gdx.gl.glClearColor(0f,0f,0f,0f);
         batch.begin();
         bf.draw(batch, "Testin¡ª¡ªMkey libgdx(2)",Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
         batch.end();
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
