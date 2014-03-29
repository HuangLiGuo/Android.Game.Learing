package hlg.game.learing.camera;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.hlg.gdx.scenes.scene2d.OrtCameraActor;

public class CameraTest implements ApplicationListener {


private OrtCameraActor ortCameraActor;

private Stage stage;
 
@Override
public void create() {

   this.stage = new Stage();
   this.ortCameraActor = new OrtCameraActor("camera/aolaiguo.jpg");
   this.stage.addActor(this.ortCameraActor);
 
}
 
@Override
public void dispose() {
   this.stage.dispose();
}
 
@Override
public void render() {
   Gdx.gl.glClearColor(1, 1, 1, 1);
   Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
 
   this.stage.draw();
}
 
@Override
public void resize(int width, int height) {
}
 
@Override
public void pause() {
}
 
@Override
public void resume() {
}
 
}
