package paw.wingsy;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class Main extends Activity implements View.OnTouchListener {
    private Surface s;
    protected static boolean isItOk = false;
    Thread t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s = new Surface(this);
        s.spriteBmp = BitmapFactory.decodeResource(getResources(),R.drawable.jabko_czerwone);
        setContentView(s);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
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
        while(true){
            try{
                t.join();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            break;
        }
        t = null;
    }

    public void resume(){
        isItOk = true;
        t = new Thread(s);
        t.start();
    }
}
