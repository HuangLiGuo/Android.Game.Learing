package hlg.game.learing.mario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Mario extends Actor {

	public static float x;
	public static float y;
	public static float statetime;

	Texture texture;
	TextureRegion currentFrame;

	public ImageButton buttonL;
	public ImageButton buttonR;
	public ImageButton buttonT;
	public ImageButton buttonBottom;
	public ImageButton buttonB;

	Animation aniRight;
	Animation aniLeft;
	Animation aniIdle;
	TextureRegion[][] spilt;
	TextureRegion[][] miror;
	TextureRegion[] regionI;
	
	public static int LeftState  = 1;
	public static int IdeltState = 2;
	public static int RightState = 3;
	public static int TopState = 4;
	public static int ButtomState = 5;
	public static int state = 2;

	
	public Mario(float x, float y) {
		this.x = x;
		this.y = y;
		this.setX(x);
		this.setY(y);
		this.show();
	}

	public void show() {
		texture = new Texture(Gdx.files.internal("mario/mario.png"));
		spilt = TextureRegion.split(texture, 64, 64);
		miror = TextureRegion.split(texture, 64, 64);
		for (TextureRegion[] region1 : miror) {
			for (TextureRegion region2 : region1) {
				region2.flip(true, false);
			}
		}

		// ÓÒ
		TextureRegion[] regionR = new TextureRegion[3];
		regionR[0] = spilt[0][1];
		regionR[1] = spilt[0][2];
		regionR[2] = spilt[0][0];
		aniRight = new Animation(0.1f, regionR);
		// ×ó
		TextureRegion[] regionL = new TextureRegion[3];
		regionL[0] = miror[0][1];
		regionL[1] = miror[0][2];
		regionL[2] = miror[0][0];
		aniLeft = new Animation(0.1f, regionL);
		// ¿ÕÏÐ
		regionI = new TextureRegion[1];
		regionI[0] = spilt[0][0];

		aniIdle = new Animation(0.1f, regionI);

		buttonL = new ImageButton(new TextureRegionDrawable(spilt[1][0]),
				new TextureRegionDrawable(spilt[1][1]));
		
		buttonB = new ImageButton(new TextureRegionDrawable(spilt[1][0]),
				new TextureRegionDrawable(spilt[1][1]));
		
		
		buttonB.setPosition(20, Gdx.graphics.getHeight() - this.buttonB.getHeight());
		buttonB.addListener(new InputListener(){
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				if(x > buttonB.getWidth() || x < 0
						|| y < 0 || y > buttonB.getHeight()) {
					
				} else {
					Constants.Stageflag = Constants.StartStageOn;
				}
				return;
				//super.touchUp(event, x, y, pointer, button);
			}

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				//Constants.Stageflag = Constants.StartStageOn;
				//return true;
				//super.touchDown(event, x, y, pointer, button);
				return true;
				//return true;
			}
		});
		
		buttonR = new ImageButton(new TextureRegionDrawable(miror[1][0]),
				new TextureRegionDrawable(miror[1][1]));

		buttonT = new ImageButton(new TextureRegionDrawable(miror[1][0]),
				new TextureRegionDrawable(miror[1][1]));
		buttonT.setOrigin(miror[1][0].getRegionWidth() / 2, miror[1][0].getRegionHeight() / 2);
		buttonT.setRotation(90);
		
		buttonBottom = new ImageButton(new TextureRegionDrawable(miror[1][0]),
				new TextureRegionDrawable(miror[1][1]));
		buttonBottom.setOrigin(miror[1][0].getRegionWidth() / 2, miror[1][0].getRegionHeight() / 2);
		buttonBottom.setRotation(-90);
		
		buttonL.setPosition(20, 40);
		buttonR.setPosition(100, 40);
		buttonT.setPosition(60, 90);
		buttonBottom.setPosition(60, 0);
		
		buttonL.addListener(new InputListener() {

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				state = IdeltState;
				regionI[0] = miror[0][0];
				super.touchUp(event, x, y, pointer, button);
			}

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				state = LeftState;
				return true;
			}
		});

		buttonR.addListener(new InputListener() {
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = IdeltState;
				regionI[0] = spilt[0][0];
				super.touchUp(event, x, y, pointer, button);
			}

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = RightState;
				return true;
			}

		});

		buttonT.addListener(new InputListener(){
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = IdeltState;
				regionI[0] = spilt[0][0];
				super.touchUp(event, x, y, pointer, button);
			}

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = TopState;
				return true;
			}
		});
		
		buttonBottom.addListener(new InputListener(){
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = IdeltState;
				regionI[0] = spilt[0][0];
				super.touchUp(event, x, y, pointer, button);
			}

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				state = ButtomState;
				return true;
			}
		});
	}
	
	public void update(){
		if(state == LeftState){
			this.x -=1.5f;
			//if(x<20) this.x = 20;
		}else if(state == RightState){
			this.x +=1.5f;
			//if(x>400) this.x = 400;
		}else if(state == TopState) {
			this.y += 1.5f;
		}else if(state == ButtomState) {
			this.y -= 1.5f;
		}
	}
	
	public void aniCheck(){
		if(state == LeftState){
			currentFrame = aniLeft.getKeyFrame(statetime, true);
		}else if(state == RightState){
			currentFrame = aniRight.getKeyFrame(statetime, true);
		}else if (state == IdeltState) {
			currentFrame = aniIdle.getKeyFrame(statetime,true);
		} else if(state == TopState) {
			currentFrame = aniLeft.getKeyFrame(statetime, true);
		} else {
			currentFrame = aniRight.getKeyFrame(statetime, true);
		}
	}

	
	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return this.y;
	}

	@Override
	public void setX(float x) {
		// TODO Auto-generated method stub
		this.x = x;
		super.setX(x);
	}

	@Override
	public void setY(float y) {
		// TODO Auto-generated method stub
		this.y = y;
		super.setY(y);
	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
			statetime+=Gdx.graphics.getDeltaTime();
			this.update();
			this.aniCheck();
			batch.draw(currentFrame, super.getX(), super.getY());
	}
}
