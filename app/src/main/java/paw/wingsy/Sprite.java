package paw.wingsy;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
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
    int rotationDeg;
    int lastRotationDeg;
    Matrix matrix = new Matrix();
    Bitmap rotatedBitmap;

    public Sprite(Surface surface1, Bitmap b1 ) {
        b=b1;
        surface = surface1;
        xStep=1;
        yStep=1;
        width = b.getWidth()/xStep;
        height = b.getHeight()/yStep;

        rotatedBitmap=Bitmap.createBitmap(b, 0, 0, width, height, matrix, true);


    }
    public void onDraw(Canvas canvas){




        //update();
        int srcX = 0;
        int srcY=0;

        double radians = Math.toRadians(rotationDeg);
       // matrix.setRotate(rotationDeg);
        rotatedBitmap=Bitmap.createBitmap(b, 0, 0, width, height, matrix, true);
        matrix.setTranslate(x,y);

        canvas.drawBitmap(rotatedBitmap,matrix,new Paint());


    }


}
