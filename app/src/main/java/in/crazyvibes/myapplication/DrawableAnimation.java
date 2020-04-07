package in.crazyvibes.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class DrawableAnimation extends AppCompatActivity {

    private ImageView iv_image;
    private AnimationDrawable image_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAnimation();
        setContentView(R.layout.activity_drawable_animation);
        iv_image = (ImageView) findViewById(R.id.iv_image);



        iv_image.setBackgroundResource(R.drawable.drawable_anim);
        image_anim = (AnimationDrawable) iv_image.getBackground();



        iv_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image_anim.start();
            }
        });





        }

    public void setAnimation() {
        if (Build.VERSION.SDK_INT > 20) {
            Slide slide = new Slide();
            slide.setSlideEdge(Gravity.BOTTOM);
            slide.setDuration(1600);
            slide.setInterpolator(new DecelerateInterpolator());
            getWindow().setExitTransition(slide);
            getWindow().setEnterTransition(slide);
        }
    }

       // image_anim.setOnClickListener({ rocketAnimation.start() });

    }

