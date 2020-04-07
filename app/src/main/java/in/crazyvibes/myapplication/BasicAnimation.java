package in.crazyvibes.myapplication;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BasicAnimation extends AppCompatActivity implements Animation.AnimationListener {

    private TextView txtMessage;
    private Button btn;
    private Button btn_drw;
    private Animation animFadein;
    private Animation anim_zoom_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAnimation();
        setContentView(R.layout.activity_main);


        txtMessage = (TextView) findViewById(R.id.text);
        btn = (Button) findViewById(R.id.btn);
        btn_drw = (Button) findViewById(R.id.btn_drw);

        animFadein= AnimationUtils.loadAnimation(this,R.anim.move);
        anim_zoom_in= AnimationUtils.loadAnimation(this,R.anim.blink);

        animFadein.setAnimationListener(this);
        anim_zoom_in.setAnimationListener(this);


        //handling aniamtion on button click

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMessage.setVisibility(View.VISIBLE);
                // starting the animation
                txtMessage.startAnimation(animFadein);

            }
        });

        btn_drw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity();
            }
        });


        }

    public void startActivity(){
        Intent i = new Intent(this,DrawableAnimation.class);
        if(Build.VERSION.SDK_INT>20){
            ActivityOptions options =
                    ActivityOptions.makeSceneTransitionAnimation(this);
            startActivity(i,options.toBundle());
        }else {
            startActivity(i);
        }
    }

    public void setAnimation() {
        if (Build.VERSION.SDK_INT > 20) {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.TOP);
            slide.setDuration(1600);
            slide.setInterpolator(new DecelerateInterpolator());
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide);
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
