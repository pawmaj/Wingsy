package paw.wingsy;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;


public class Main extends Activity implements View.OnTouchListener {
    private View sv;
    public Surface s;
    protected static boolean isItOk = false;
    Thread t;
    Button gas, left, right;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        s = (Surface) findViewById(R.id.sSurface);
        gas = (Button)findViewById(R.id.bGas);
        gas.setOnTouchListener(this);
        left = (Button)findViewById(R.id.bLeft);
        right = (Button)findViewById(R.id.bRight);


        //load bitmaps
        s.sprite1Bmp = BitmapFactory.decodeResource(getResources(),R.drawable.jabko_czerwone);
        s.arrowRightBmp = BitmapFactory.decodeResource(getResources(),R.drawable.arrowright);
        s.arrowLeftBmp = BitmapFactory.decodeResource(getResources(),R.drawable.arrowleft);
        s.gasBmp = BitmapFactory.decodeResource(getResources(),R.drawable.gas);



    }


    @Override
    public boolean onTouch (View v, MotionEvent e) {

                s.gas.x++;

        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pause();
    }

    public void pause(){
        isItOk = false;
       /* while(true){
            try{
              t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            break;
        }
        t = null;*/
    }

    public void resume(){
        isItOk = true;
        t = new Thread(s);
        t.start();



    }
}
