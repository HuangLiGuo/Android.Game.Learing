package hlg.game.learing.texture;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TextureGame implements ApplicationListener {

	private SpriteBatch batch;
	private Texture texture;
	private TextureRegion textRegion;
	private Sprite sprite;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		texture = new Texture(Gdx.files.internal("texture/potato.jpg"));
		//this.textRegion = new TextureRegion(this.texture, 0, 0, -this.texture.getWidth() / 2, -this.texture.getHeight() / 2);
		//·´Ïò½ØÍ¼
		this.textRegion = new TextureRegion(this.texture, this.texture.getWidth() / 2, this.texture.getHeight() / 2, -(this.texture.getWidth() / 2), -(this.texture.getHeight() / 2));
		this.sprite = new Sprite(textRegion);
		this.sprite.setOrigin(0, 0);
		this.sprite.setRotation(50);
		this.sprite.setPosition(100, 100);
		this.sprite.setColor(1, 0, 1, 1);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.batch.dispose();
		this.texture.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		 
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.batch.begin();
		//this.batch.draw(this.texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//this.batch.draw(this.textRegion, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.sprite.draw(this.batch);
		
		this.batch.end();
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
