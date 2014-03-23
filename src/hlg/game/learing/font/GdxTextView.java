package hlg.game.learing.font;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class GdxTextView extends Actor {
	
	public static FontFamily FONTFAMILY = new FontFamily();
	
	private BitmapFont font;
	private String text;
	private float size;
	private float lineHeight;
	private float x, y;
	private HAlignment hAlignment;
	private float width;
	
	public GdxTextView(String fntPath, String pngPath) {
		this.font = new BitmapFont(Gdx.files.internal(fntPath),
	               Gdx.files.internal(pngPath), false);
		this.lineHeight = this.font.getLineHeight();
		this.size = this.lineHeight;
		this.hAlignment = HAlignment.LEFT;
		this.text = "";
		this.x = 0;
		this.y = 0;
		this.width = Gdx.graphics.getWidth();
	}
	
	public GdxTextView(String fntPath, String pngPath, String text) {
		this.font = new BitmapFont(Gdx.files.internal(fntPath),
	               Gdx.files.internal(pngPath), false);
		this.lineHeight = this.font.getLineHeight();
		this.size = this.lineHeight;
		this.hAlignment = HAlignment.LEFT;
		this.text = text;
		this.x = 0;
		this.y = 0;
		this.width = Gdx.graphics.getWidth();
	}
	
	public void setColor(Color color) {
		this.font.setColor(color);
	}
	
	public void setSize(float size) {
		this.size = size;
		this.font.setScale(size/this.lineHeight);
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setHAlignment(HAlignment hAlignment) {
		this.hAlignment = hAlignment;
	}
	
	public void setPosition(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void setWidth(float width) {
		this.width = width;
	}
	
	public float getHeight() {
		float height = this.font.getWrappedBounds(this.text, this.width).height;
		height = height * this.size / this.font.getLineHeight();
		return height;
	}
	
	public float getWidth() {
		return this.width;
	}


	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		this.font.drawWrapped(batch, this.text, this.x, this.y, this.width, this.hAlignment);
		super.draw(batch, parentAlpha);
	}
	
	public static class FontFamily {
		public String HuaWenHuPoFNT = "font/HWHPfont.fnt";
		public String HuaWenHuPoPNG = "font/HWHPfont.png";
	}
	
	public String ReadTxtFile(String strFilePath)
    {
        String path = strFilePath;
        String content = ""; //文件内容字符串
            //打开文件
            File file = new File(path);
            //如果path是传递过来的参数，可以做一个非目录的判断
            if (file.isDirectory())
            {
                //Log.d("TestFile", "The File doesn't not exist.");
            }
            else
            {
                try {
                
                    InputStream instream = Gdx.files.internal(path).read(); 
                    if (instream != null) 
                    {
                    	
                        InputStreamReader inputreader = new InputStreamReader(instream, "gbk");
                        BufferedReader buffreader = new BufferedReader(inputreader);
                        String line;
                        //分行读取
                        while (( line = buffreader.readLine()) != null) {
                        	if(!line.equals("")) {
                        		content += line;
                        	}
                        }                
                        instream.close();
                    }
                }
                catch (java.io.FileNotFoundException e) 
                {
                    Log.d("TestFile", "The File doesn't not exist.");
                } 
                catch (IOException e) 
                {
                  	Log.d("TestFile", e.getMessage());
                }
            }
            return content;
    }
}
