package paw.wingsy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by paweł on 2015-03-21.
 */
public class Surface extends SurfaceView implements Runnable {
    protected Bitmap sprite1Bmp;
    private Thread t;
    SurfaceHolder holder;

    protected Sprite sprite1;
    boolean spriteLoaded = false;

    public Surface(Context context) {
        super(context);
        holder = getHolder();

    }

    @Override
    public void run() {
        sprite1 = new Sprite (Surface.this,sprite1Bmp);
        while(Main.isItOk){ //perfom canvas drawing
            if(!holder.getSurface().isValid()){
                continue;
            }
            Canvas c = holder.lockCanvas();
            Draw(c);
            holder.unlockCanvasAndPost(c);
        }

    }
    //Drawing method
    protected void Draw(Canvas canvas){
        canvas.drawARGB(255,0,255,0);
        //canvas.drawBitmap(jabko,0,0,new Paint());
        sprite1.onDraw(canvas);
    }



}
