package paw.wingsy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by paweł on 2015-03-21.
 */
public class Surface extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private Thread t;
    SurfaceHolder holder;
    protected Bitmap sprite1Bmp;
    protected Sprite jabko;
    protected Sprite arrowLeft;
    protected Sprite arrowRight;
    protected Sprite gas;
    //bi
    protected Bitmap arrowLeftBmp;
    protected Bitmap arrowRightBmp;
    protected Bitmap gasBmp;
    private LinkedList<Sprite> toDraw;
    //boolean spriteLoaded = false;

    public Surface(Context context) {
        super(context);
        holder = getHolder();


    }

    @Override
    public void run() {
        holder = getHolder(); // Must be here for some reason

        //load bitmaps
        jabko = new Sprite(Surface.this, sprite1Bmp);
        arrowLeft = new Sprite(Surface.this, arrowLeftBmp);
        arrowRight = new Sprite(Surface.this, arrowRightBmp);
        gas = new Sprite(Surface.this, gasBmp);
        toDraw.add(jabko);
        toDraw.add(arrowLeft);
        toDraw.add(arrowRight);
        toDraw.add(gas);

        //Main loop
        while(Main.isItOk) {
            if(!holder.getSurface().isValid())continue;//wait for the surface

               updateGameState();

            Canvas c = holder.lockCanvas();
                Draw(c);
            holder.unlockCanvasAndPost(c);
        }

    } //Drawing method

    private void updateGameState() {
        checkCollisions(toDraw);
        gas.x = 100;
        arrowRight.y = 300;
    }

    private Dictionary<Sprite,Sprite> checkCollisions(LinkedList<Sprite> sprites) {

        Iterator<Sprite> it1 = toDraw.iterator();
        while(it1.hasNext()){
            Iterator<Sprite> it2 = toDraw.iterator();
            while(it2.hasNext()){
                Sprite s1 = it1.next();
                Sprite s2 = it2.next();
                if(!s1.equals(s2)){
                    //TODO add sprite collision logic
                    if(s1.getX() + s1.getWidth() > s2.getX() && s1.getX() < s2.getX()) {

                    }
// Second case
                    if(s1.getX() < s2.getX() + s2.getWidth() && s1.getX() + s1.getWidth() > s2.getX()) {

                    }
// Third s
                    if((s1.getX() + s1.getWidth() > s2.getX() && s1.getX() < s2.getX()) && (s1.getX() < s2.getX() + s2.getWidth() && s1.getX() + s1.getWidth() > s2.getX())) {

                    }
                }
            }
        }
        return null;
    }

    protected void Draw(Canvas canvas) {
        canvas.drawARGB(255, 0, 255, 0);

        Iterator<Sprite> it = toDraw.iterator();//draw Sprite by Sprite
        while(it.hasNext()){
            it.next().onDraw(canvas);
        }

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

