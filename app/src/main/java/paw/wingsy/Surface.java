package paw.wingsy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by paweł on 2015-03-21.
 */
public class Surface extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private Thread t;
    SurfaceHolder holder;
    protected Bitmap sprite1Bmp;
    protected Sprite sprite1;
    protected Sprite arrowLeft;
    protected Sprite arrowRight;
    protected Sprite gas;
    //bi
    protected Bitmap arrowLeftBmp;
    protected Bitmap arrowRightBmp;
    protected Bitmap gasBmp;
    //boolean spriteLoaded = false;

    public Surface(Context context) {
        super(context);
        holder = getHolder();


    }

    @Override
    public void run() {
        sprite1 = new Sprite(Surface.this, sprite1Bmp);
        arrowLeft = new Sprite(Surface.this, arrowLeftBmp);
        arrowRight = new Sprite(Surface.this, arrowRightBmp);
        gas = new Sprite(Surface.this, gasBmp);
        gas.x = 100;
        holder = getHolder();
        arrowRight.y = 300;
        //perfom canvas drawing
        while(Main.isItOk) {
            if(!holder.getSurface().isValid()){
                continue;
            }


            Canvas c = holder.lockCanvas();
                Draw(c);
            holder.unlockCanvasAndPost(c);
        }

    } //Drawing method

    protected void Draw(Canvas canvas) {
        canvas.drawARGB(255, 0, 255, 0);
        //canvas.drawBitmap(jabko,0,0,new Paint());
        sprite1.onDraw(canvas);
        arrowLeft.onDraw(canvas);
        arrowRight.onDraw(canvas);
        gas.onDraw(canvas);
    }


    //missing constructors
    public Surface(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    public Surface(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}

