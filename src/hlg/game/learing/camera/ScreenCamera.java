package hlg.game.learing.camera;

import hlg.game.learing.mario.Mario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class ScreenCamera extends Actor {
	
	private Stage stage;
	private float x, y;
	private float RightLimit, TopLimit;
	private Image imgScreenBackground;
	
	public ScreenCamera(String screenbackground, Stage stage)
	{
		this.stage = stage;
		
		this.imgScreenBackground = new Image(new Texture(Gdx.files.internal(screenbackground)));
		this.x = -(this.imgScreenBackground.getWidth() - Gdx.graphics.getWidth());
		this.y = 0;
		this.RightLimit = this.imgScreenBackground.getWidth() - Gdx.graphics.getWidth();
		this.TopLimit = this.imgScreenBackground.getHeight() - Gdx.graphics.getHeight();
		this.imgScreenBackground.setPosition(this.x, this.y);
		this.imgScreenBackground.setScale(1.0f);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		this.imgScreenBackground.draw(batch, 1);
		super.draw(batch, parentAlpha);
	}
	
	public void setScale(float zoom)
	{
		this.imgScreenBackground.setScale(zoom);
	}

	public void Translation(float x, float y)
	{
		float preX = this.x;
		float preY = this.y;
		this.x -= x;
		if(this.x >= 0) {
			this.x = 0;
			x = preX < 0 ? preX : 0;
		}
		if(-this.x >= this.RightLimit) {
			this.x = -this.RightLimit;
			x = (preX + this.RightLimit) > 0 ? (preX + this.RightLimit) : 0;
		}
		if(x != 0) {
			for(Actor actor : this.stage.getActors()) {
				if(actor instanceof Mario) {
					actor.setX(actor.getX() - x);
				}
			}
		}

		this.y -= y;
		if(this.y >= 0) { 
			this.y = 0; 
			y = preY < 0 ? preY : 0;
		}
		if(-this.y >= this.TopLimit) {
			this.y = -this.TopLimit;
			y = 0;
			y = (preY + this.TopLimit) > 0 ? (preY + this.TopLimit) : 0;
		}
		if(y != 0) {
			for(Actor actor : this.stage.getActors()) {
				if(actor instanceof Mario) {
					actor.setY(actor.getY() - y);
				}
			}
		}
		
		this.imgScreenBackground.setPosition(this.x, this.y);
	}
}
