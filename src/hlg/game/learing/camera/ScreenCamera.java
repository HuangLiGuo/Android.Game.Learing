package hlg.game.learing.camera;

import hlg.game.learing.mario.Mario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class ScreenCamera extends Actor {
	
	private Stage stage;
	private Texture screenbackground;
	private float x, y;
	private float RightLimit, TopLimit;
	
	public ScreenCamera(String screenbackground, Stage stage)
	{
		this.stage = stage;
		this.screenbackground = new Texture(Gdx.files.internal(screenbackground));
		
		this.x = 0;
		this.y = 0;
		this.RightLimit = this.screenbackground.getWidth() - Gdx.graphics.getWidth();
		this.TopLimit = this.screenbackground.getHeight() - Gdx.graphics.getHeight();
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.draw(this.screenbackground, this.x, this.y);
		
		super.draw(batch, parentAlpha);
	}

	public void Translation(float x, float y)
	{
		if(this.x <= 0 && -this.x < this.RightLimit) {
			this.x -= x;
			if(this.x > 0) { this.x = 0; }
			if(-this.x > this.RightLimit) { this.x = -this.RightLimit; }
			
			for(Actor actor : this.stage.getActors()) {
				if(actor instanceof Mario) {
					actor.setX(actor.getX() - x);
					//actor.setY(actor.getY() - y);
				}
			}
		}
		if(this.y <= 0 && -this.y < this.TopLimit) {
			this.y -= y;
			if(this.y > 0) { this.y = 0; }
			if(-this.y > this.RightLimit) { this.y = -this.TopLimit; }
			
			for(Actor actor : this.stage.getActors()) {
				if(actor instanceof Mario) {
					//actor.setX(actor.getX() - x);
					actor.setY(actor.getY() - y);
				}
			}
		}
	}
}
