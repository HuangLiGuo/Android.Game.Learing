package hlg.game.learing.camera;

import hlg.game.learing.mario.Mario;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RepeatAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.hlg.gdx.scenes.scene2d.OrtCameraActor;
import com.hlg.gdx.scenes.scene2d.ui.FPSLabel;

public class AoLaiGuoScreen implements Screen  {

	private Game game;
	private Stage stage;
	private Stage cStage;
	private OrtCameraActor ortCameraActor;
	private Mario mario;
	
	public AoLaiGuoScreen(Game game)
	{
		this.game = game;
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.stage.dispose();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1, 1, 1, 1);
		this.stage.act(Gdx.graphics.getDeltaTime());
		this.stage.draw();
		this.cStage.draw();
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.stage = new Stage();
		this.cStage = new Stage();
		this.ortCameraActor = new OrtCameraActor("camera/aolaiguo.jpg");
		this.mario = new Mario(300, 100);
		
		// 移动操作  
        MoveByAction action1 = Actions.moveBy(150, 150, 4); 

        // 还原操作 
        //MoveToAction action6 = Actions.moveTo(800 / 2, 480 / 2);  
  
        // 顺序执行action  
        //SequenceAction sequenceAction = Actions.sequence(action1, action6);  
        //sequenceAction.setActor(this.mario);  
  
        // 无限循环三个动作  
        //RepeatAction epeatAction = Actions.repeat(RepeatAction.FOREVER,  
                //sequenceAction);  
		this.mario.addAction(action1);
		this.stage.addActor(this.ortCameraActor);
		this.stage.addActor(this.mario);
		this.cStage.addActor(this.mario.buttonL);
		this.cStage.addActor(this.mario.buttonR);
		this.cStage.addActor(this.mario.buttonT);
		this.cStage.addActor(this.mario.buttonBottom);
		this.cStage.addActor(new FPSLabel("font/HWHPfont.fnt", "font/HWHPfont.png"));
		
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(this.cStage);
		multiplexer.addProcessor(new GestureDetector(ortCameraActor));
		Gdx.input.setInputProcessor(multiplexer);
	}

}
