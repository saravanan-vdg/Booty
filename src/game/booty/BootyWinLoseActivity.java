package game.booty;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class BootyWinLoseActivity extends Activity 
{	   
	private int m_Selection;
	private String m_Player;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        
        //Get what has been selected
        m_Selection = getIntent().getExtras().getInt("Selection");
        m_Player = getIntent().getExtras().getString("Player");
        
        //Set the Activity to full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Set the main screen
        setContentView(R.layout.layoutfindbooty);
        
        int imageToUse;
        
        if(m_Selection == 0) {
        	imageToUse = R.drawable.iconusedchest;
        }
        else if(m_Selection == 1) {
        	imageToUse = R.drawable.icontrap;
        }
        else {
        	imageToUse = R.drawable.iconchest;
        }
        
    	ImageView imageFindBooty = (ImageView) findViewById(R.id.imagefindbooty);
    	Animation coinchoice = AnimationUtils.loadAnimation(this, R.anim.animationrevealbooty);
    	imageFindBooty.startAnimation(coinchoice);
    	imageFindBooty.setImageResource(imageToUse);
    	
    	new Handler().postDelayed(new Runnable() 
    	{ 
    	    public void run() 
    	    { 
            	//End the find activity
    	    	CloseActivity();
    	    }
    	}, 10000);
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)  {

        }
        return super.onKeyDown(keyCode, event);
    }
    
    private void CloseActivity() {
    	this.finish();
    }
}