package hlg.game.learing.camera;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
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

public class ActionGame implements ApplicationListener
{

    private Stage mStage;

    @Override
    public void create()
    {
        mStage = new Stage(800, 480);

        Player player = new Player();
        player.setPosition(800 / 2, 480 / 2);

        // 移动操作
        MoveByAction action1 = Actions.moveBy(150, 0, 3);
        ScaleByAction action2 = Actions.scaleBy(3, 3, 3);
        RotateByAction action3 = Actions.rotateBy(90, 3);

        // 还原操作
        ScaleToAction action4 = Actions.scaleTo(1, 1);
        RotateToAction action5 = Actions.rotateTo(0);
        MoveToAction action6 = Actions.moveTo(800 / 2, 480 / 2);

        // 顺序执行action
        SequenceAction sequenceAction = Actions.sequence(action1, action2,
                action3, action4, action5, action6);
        sequenceAction.setActor(player);

        // 无限循环三个动作
        RepeatAction epeatAction = Actions.repeat(RepeatAction.FOREVER,
                sequenceAction);

        player.addAction(epeatAction);

        mStage.addActor(player);

    }

    @Override
    public void resize(int width, int height)
    {
    }

    @Override
    public void render()
    {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mStage.act(Gdx.graphics.getDeltaTime());
        mStage.draw();
    }

    @Override
    public void pause()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void resume()
    {
        // TODO Auto-generated method stub
    }

    @Override
    public void dispose()
    {
        // 所有实现Disposable接口的都需要释放资源
        mStage.dispose();
    }


public class Player extends Actor
{

    private Pixmap mPixmap;
    private Texture mTexture;
    private TextureRegion mTextureRegion;

    public Player()
    {
        mPixmap = new Pixmap(Gdx.files.internal("texture/potato.jpg"));
        mTexture = new Texture(mPixmap);
        mTextureRegion = new TextureRegion(mTexture, 0, 0, 30, 30);
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha)
    {
        //这里要注意，我们添加的action只是改变actor的属性值，绘制的时候并没有
        //自动给我们处理这些逻辑， 我们要做的就是取得这些值，然后自己处理
        batch.draw(mTextureRegion, getX(), getY(),
                mTextureRegion.getRegionWidth() / 2,
                mTextureRegion.getRegionHeight() / 2,
                mTextureRegion.getRegionWidth(),
                mTextureRegion.getRegionHeight(), getScaleX(), getScaleY(),
                getRotation());
    }

    @Override
    public void clear()
    {
        super.clear();
        mPixmap.dispose();
        mTexture.dispose();
    }

}}