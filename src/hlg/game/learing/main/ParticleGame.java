package hlg.game.learing.main;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.ParticleEffectPool;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ParticleGame implements ApplicationListener {

	private SpriteBatch batch;
	private BitmapFont bf;
	private ParticleEffect particle;
	private ParticleEffect tem;
	private ParticleEffectPool particlepool;
	private ArrayList<ParticleEffect> particlelist;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		this.batch = new SpriteBatch();
		this.bf = new BitmapFont();
		
		
		particle = new ParticleEffect();
        particle.load(Gdx.files.internal("particle/particle.p"), Gdx.files.internal("particle/"));
        particlepool=new ParticleEffectPool(particle, 5, 10);
        particlelist = new ArrayList();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		this.batch.dispose();
		this.bf.dispose();
		particle.dispose();
        if(tem!=null)
            tem.dispose();
        particlepool.clear();
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		 Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
         Gdx.gl.glClearColor(0f,0f,0f,0f);
         batch.begin();
         bf.draw(batch, "Testin——Mkey libgdx(2)",Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
         batch.end();
         
         if(true){
             if(Gdx.input.isTouched()){
                //当此触摸点与上一触摸点距离大于一定值的时候触发新的粒子系统，由此减小系统负担
                tem=particlepool.obtain();
                tem.setPosition(Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY());
                particlelist.add(tem);
             }
             batch.begin();
                for(int i=0;i<particlelist.size();i++){
             particlelist.get(i).draw(batch, Gdx.graphics.getDeltaTime());
                }
                batch.end();
       
                //清除已经播放完成的粒子系统
                /*ParticleEffect temparticle;
                for(int i=0;i<particlelist.size();i++){
                  temparticle=particlelist.get(i);
                 if(temparticle.isComplete()){
                     particlelist.remove(i);
                 }
                }*/
             }
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
