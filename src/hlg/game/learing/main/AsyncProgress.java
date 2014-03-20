package hlg.game.learing.main;

import hlg.game.learing.main.ProgressBarGame.ProgressBar;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;

public class AsyncProgress implements ApplicationListener {

	private ProgressBar bar;
	private Stage stage;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub

		bar = new ProgressBar(0, 0);
		stage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(bar);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1f,1f,1f,0f);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		if(bar.progress<100)
			bar.progress+=0.5;
		//重新置零
		if(bar.progress==100)
			bar.progress=0;
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	public class ProgressBar extends Actor implements Disposable {
		
		private Texture platform;
		private Texture bar;
		private int height;
		private int width;
		private float progress;
		private float powerx, powery;

		@Override
		public void draw(SpriteBatch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			//super.draw(batch, parentAlpha);
			batch.draw(platform, (Gdx.graphics.getWidth()-bar.getWidth()*powerx)/2, 10,platform.getWidth()*powerx,platform.getHeight()*powery);
		    batch.draw(bar,(Gdx.graphics.getWidth()-bar.getWidth()*powerx)/2, 10,bar.getWidth()*progress/100f*powerx,bar.getHeight()*powery);
		}

		@Override
		public Actor hit(float x, float y, boolean touchable) {
			// TODO Auto-generated method stub
			//return super.hit(x, y, touchable);
			return null;
		}

		public ProgressBar(int x, int y) {
			super();
			
			//this.x = x;
			//this.y = y;
		
			platform=new Texture(Gdx.files.internal("progress/black.png"));
			bar=new Texture(Gdx.files.internal("progress/green.png"));
		 	height=Gdx.graphics.getHeight();
		 	width=Gdx.graphics.getWidth();
			//做了一个简单的适配，powerx和powery分别当前设备分辨率的权重，以现在主流的800*480为基准
		  	powerx=Gdx.graphics.getWidth()/800f;
		 	powery=Gdx.graphics.getHeight()/480f;
		}
		
		public void setProgress(float progress) {
			this.progress = progress;
		}
		
		@Override
		public void dispose() {
			// TODO Auto-generated method stub
			this.platform.dispose();
			this.bar.dispose();
		}
		
	}
}
