package hlg.game.learing.mario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class StartStage extends Stage {

	Texture texture;
	TextureRegion startRegion;
	Image startImage;
	Image newGameBtn;
	TextureRegion newGameRegion;
	
	private float ScaleX, ScaleY;
	
	public StartStage() {
		super();
		init();
	}

	public void init() {

		texture = new Texture(Gdx.files.internal("mario/start.png"));
		startRegion = new TextureRegion(texture, 0, 0, 798, 480);
		this.ScaleX = (float)Gdx.graphics.getWidth() / 798;
		this.ScaleY = (float)Gdx.graphics.getHeight() / 480;
		startImage = new Image(startRegion);
		startImage.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//startImage.setSize(480, 200);

		newGameRegion = new TextureRegion(texture, 924, 0, 100, 50);
		newGameBtn = new Image(newGameRegion);
		newGameBtn.setSize(100 * this.ScaleX, 50 * this.ScaleY);
		newGameBtn.setPosition(80 * this.ScaleX, this.ScaleY * 
				(Gdx.graphics.getHeight() - 70 - 50)); 
		
		this.addActor(startImage);
		this.addActor(newGameBtn);
		
		newGameBtn.addListener(new InputListener(){

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				Constants.Stageflag = Constants.GameStageOn;
				
				return true;
			}			
		});
	}
}