package hlg.game.learing.font;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeBitmapFontData;

public class FontGame implements ApplicationListener {

	 private BitmapFont Font;

	   private FreeTypeFontGenerator Generator;

	   FreeTypeBitmapFontData fontData;

	   private SpriteBatch batch;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub

		Generator = new FreeTypeFontGenerator(
	               Gdx.files.internal("font/font.TTF"));

	       fontData = Generator.generateData(25, Generator.DEFAULT_CHARS
	               + "长的帅人告白才叫，丑男那性骚扰。奋斗小土豆手机工作游戏室", false);// 这里需要把你要输出的字，全部写上，前提是不能有重复的字。

	       Font = new BitmapFont(fontData, fontData.getTextureRegion(), false);

	       Font.setColor(Color.RED);
	    

	       batch = new SpriteBatch();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.batch.dispose();
		//this.font.dispose();
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
	       batch.begin();
	       Font.drawMultiLine(batch,"hello Fighting Potato: \n \n长的帅的人告白才叫告白，\n长的丑的         男人告白那叫性骚扰。", 50, 220);
	       Font.draw(batch, "--------Var3D手机工作游戏室", 150, 90);

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
