package hlg.game.learing.camera;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.VertexAttribute; 
import com.badlogic.gdx.graphics.VertexAttributes; 
import com.badlogic.gdx.graphics.VertexAttributes.Usage; 
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;

public class CameraTest implements ApplicationListener, GestureListener {
private OrthographicCamera camera;
private SpriteBatch batch;
private Texture texture;
private Sprite sprite;
 
@Override
public void create() {
   camera = new OrthographicCamera(1280, 720);
 
   batch = new SpriteBatch();
 
   texture = new Texture(Gdx.files.internal("camera/aolaiguo.jpg"));
   texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
 
   sprite = new Sprite(texture);
   sprite.setOrigin(0,0);
   sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
 
   Gdx.input.setInputProcessor(new GestureDetector(this));
}
 
@Override
public void dispose() {
   batch.dispose();
   texture.dispose();
}
 
@Override
public void render() {
   Gdx.gl.glClearColor(1, 1, 1, 1);
   Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
 
   batch.setProjectionMatrix(camera.combined);
   batch.begin();
   sprite.draw(batch);
   batch.end();
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
 
@Override
public boolean touchDown(float x, float y, int pointer, int button) {
// TODO Auto-generated method stub
return false;
}
 
@Override
public boolean tap(float x, float y, int count, int button) {
// TODO Auto-generated method stub
return false;
}
 
@Override
public boolean longPress(float x, float y) {
// TODO Auto-generated method stub
return false;
}
 
@Override
public boolean fling(float velocityX, float velocityY, int button) {
// TODO Auto-generated method stub
return false;
}
 
@Override
public boolean pan(float x, float y, float deltaX, float deltaY) {
   // TODO Auto-generated method stub
   camera.translate(deltaX,0);
   camera.update();
   return false;
}
 
@Override
public boolean zoom(float initialDistance, float distance) {
// TODO Auto-generated method stub
return false;
}
 


@Override
public boolean panStop(float arg0, float arg1, int arg2, int arg3) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean pinch(Vector2 arg0, Vector2 arg1, Vector2 arg2, Vector2 arg3) {
	// TODO Auto-generated method stub
	return false;
}
}
