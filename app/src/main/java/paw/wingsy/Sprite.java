package paw.wingsy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

/**
 * Created by paweł on 2015-03-21.
 */
public class Sprite {
    protected int x,y,xSpeed,ySpeed,width,height =0;
    protected Bitmap b;
    private Surface surface;
    private int xFrameSize;
    private int yFrameSize;
    private int xStep;
    private int yStep;

    public Sprite(Surface surface1, Bitmap b1 ) {
        b=b1;
        surface = surface1;
        xStep=1;
        yStep=1;
        width = b.getWidth()/xStep;
        height = b.getHeight()/yStep;
    }
    public void onDraw(Canvas canvas){
        //update();
        int srcX = 0;
        int srcY=0;


        Rect src = new Rect(srcX,srcY,srcX+width,srcY+height);
        Rect dst = new Rect(x,y, x+width,y+height);
        canvas.drawBitmap(b,src,dst,null);

    }


}
