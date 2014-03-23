package hlg.game.learing.changscreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AnimationImage extends Actor {
	
	private Animation ani;
	private float stateTime;
	private float interval;
	private TextureRegion[] aniTextureArray;
	private float DrawX, DrawY;
	
	public AnimationImage(float interval, TextureRegion[] aniTextureArray) {
		this.interval = interval;
		this.aniTextureArray = aniTextureArray;
		this.ani = new Animation(this.interval, this.aniTextureArray);
		this.stateTime = 0;
		this.DrawX = 0;
		this.DrawY = 0;
	}
	
	public float getWidth() {
		float width;
		width = 0;
		if(this.aniTextureArray.length > 0) {
			width = this.aniTextureArray[0].getRegionWidth();
		}
		return width;
	}
	
	public float getHeight() {
		float height;
		height = 0;
		if(this.aniTextureArray.length > 0) {
			height = this.aniTextureArray[0].getRegionHeight();
		}
		return height;
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		batch.draw(this.ani.getKeyFrame(this.stateTime, true), this.DrawX, this.DrawY);
		this.stateTime += Gdx.graphics.getDeltaTime();
		super.draw(batch, parentAlpha);
	}
	
	public void setPosition(float x, float y) {
		this.DrawX = x;
		this.DrawY = y;
	}
}
