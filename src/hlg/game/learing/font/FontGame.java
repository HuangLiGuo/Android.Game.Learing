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
	               + "����˧�˸�ײŽУ���������ɧ�š��ܶ�С�����ֻ�������Ϸ��", false);// ������Ҫ����Ҫ������֣�ȫ��д�ϣ�ǰ���ǲ������ظ����֡�

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
	       Font.drawMultiLine(batch,"hello Fighting Potato: \n \n����˧���˸�ײŽи�ף�\n���ĳ��         ���˸���ǽ���ɧ�š�", 50, 220);
	       Font.draw(batch, "--------Var3D�ֻ�������Ϸ��", 150, 90);

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
