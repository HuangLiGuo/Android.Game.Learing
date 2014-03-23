package hlg.game.learing.font;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class FontGame implements ApplicationListener {

	private Stage stage;
	private GdxTextView textView;

	@Override
	public void create() {
		this.stage = new Stage();
		this.textView = new GdxTextView(GdxTextView.FONTFAMILY.HuaWenHuPoFNT, GdxTextView.FONTFAMILY.HuaWenHuPoPNG);
		this.textView.setText("胡旭林、黄荔国,在一起，好的!");
		this.textView.setColor(Color.YELLOW);
		this.textView.setWidth(80);
		this.textView.setSize(20);
		this.textView.setPosition(Gdx.graphics.getWidth() / 2 - 40, Gdx.graphics.getHeight() / 2 + (this.textView.getHeight() / 2));
		this.stage.addActor(this.textView);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.stage.dispose();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
	 	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
