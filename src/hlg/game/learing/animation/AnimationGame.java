package hlg.game.learing.animation;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationGame implements ApplicationListener {

	private static final int FRAME_COLS = 6;
	   private static final int FRAME_ROWS = 2;

	   Animation walkAnimation;
	   Animation leftWalkAnimation;
	   Texture walkSheet;
	   Texture leftWalkSheet;
	   TextureRegion[] walkFrames;
	   TextureRegion[] leftWalkFrames;
	   SpriteBatch batch;
	   TextureRegion currentFrame;
	   TextureRegion leftCurrentFrame;

	   float stateTime;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		walkSheet = new Texture(Gdx.files.internal("animation/rebootright.png"));
		leftWalkSheet = new Texture(Gdx.files.internal("animation/rebootleft.png"));
		
	       TextureRegion[][] tmp = TextureRegion.split(walkSheet,
	               walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight()
	                       / FRAME_ROWS);
	       TextureRegion[][] tmp2 = TextureRegion.split(this.leftWalkSheet, walkSheet.getWidth() / FRAME_COLS,
	    		   walkSheet.getHeight() / FRAME_ROWS);

	       walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
	       this.leftWalkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
	       int index = 0;
	       int lindex = 0;
	       for (int i = 0; i < FRAME_ROWS; i++) {
	           for (int j = 0; j < FRAME_COLS; j++) {
	               walkFrames[index++] = tmp[i][j];
	               this.leftWalkFrames[lindex++] = tmp2[i][j];
	           }
	       }
	       walkAnimation = new Animation(0.075f, walkFrames);
	       this.leftWalkAnimation = new Animation(0.075f, this.leftWalkFrames);

	       walkAnimation.setPlayMode(walkAnimation.LOOP_PINGPONG);
	       this.leftWalkAnimation.setPlayMode(this.leftWalkAnimation.LOOP_PINGPONG);

	       batch = new SpriteBatch();

	       stateTime = 0f;
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
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	       stateTime += Gdx.graphics.getDeltaTime();

	       currentFrame = walkAnimation.getKeyFrame(stateTime, true);
	       this.leftCurrentFrame = this.leftWalkAnimation.getKeyFrame(stateTime, true);

	       batch.begin();
	       batch.draw(currentFrame, Gdx.graphics.getWidth() / 2, 
	               Gdx.graphics.getHeight() / 2);
	       batch.draw(leftCurrentFrame, Gdx.graphics.getWidth() / 2 + 100,
	    		   Gdx.graphics.getHeight() / 2 + 100);
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
