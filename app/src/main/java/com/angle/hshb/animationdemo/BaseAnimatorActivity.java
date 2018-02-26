package com.angle.hshb.animationdemo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class BaseAnimatorActivity extends AppCompatActivity {

    @InjectView(R.id.btn_alpha)
    Button btnAlpha;
    @InjectView(R.id.btn_rotateX)
    Button btnRotateX;
    @InjectView(R.id.btn_rotateY)
    Button btnRotateY;
    @InjectView(R.id.btn_translationX)
    Button btnTranslationX;
    @InjectView(R.id.btn_translationY)
    Button btnTranslationY;
    @InjectView(R.id.btn_translationXY)
    Button btnTranslationXY;
    @InjectView(R.id.btn_scale)
    Button btnScale;
    @InjectView(R.id.img_test)
    ImageView imgTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_animator);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.btn_scale
            ,R.id.btn_translationX,R.id.btn_translationY,R.id.btn_translationXY
            ,R.id.btn_alpha
            ,R.id.btn_rotateY,R.id.btn_rotateX})
    public void onClick(View view){
        ObjectAnimator animator=null;
        ObjectAnimator animator2=null;
        ObjectAnimator animator3=null;
        ObjectAnimator animator4=null;
        switch (view.getId()){
            case R.id.btn_alpha://渐变
                animator=new ObjectAnimator().ofFloat(imgTest,"alpha",1f,0f);
                animator.setDuration(2000);
                animator.setRepeatCount(ValueAnimator.RESTART);
                animator.setRepeatMode(ValueAnimator.REVERSE);
                animator.start();
                break;
            case R.id.btn_rotateX://旋转X
                animator=new ObjectAnimator().ofFloat(imgTest,"rotationX",0,360);
                animator.setDuration(1000);
                animator.setRepeatCount(ValueAnimator.RESTART);
                animator.setRepeatMode(ValueAnimator.RESTART);
                animator.start();
                break;
            case R.id.btn_rotateY://旋转Y
                animator=new ObjectAnimator().ofFloat(imgTest,"rotationY",0,360);
                animator.setDuration(500);
                animator.setRepeatCount(ValueAnimator.RESTART);
                animator.setRepeatMode(ValueAnimator.RESTART);
                animator.start();
                break;
            case R.id.btn_scale://缩放
                animator=new ObjectAnimator().ofFloat(imgTest,"scaleX",1f,0f,1f);
                animator2=new ObjectAnimator().ofFloat(imgTest,"scaleY",1f,0f,1f);
//                animator.setDuration(2000);
//                animator2.setDuration(2000);
//                animator.start();
                AnimatorSet animatorSet=new AnimatorSet();
                animatorSet.setDuration(2000);
                animatorSet.play(animator).with(animator2);
                animatorSet.start();
                break;
            case R.id.btn_translationX://平移X
                /**
                 *
                 Interpolator对象                         资源ID                                               功能作用
                 AccelerateDecelerateInterpolator        @android:anim/accelerate_decelerate_interpolator      先加速再减速
                 AccelerateInterpolator                  @android:anim/accelerate_interpolator                 加速
                 AnticipateInterpolator                  @android:anim/anticipate_interpolator                 先回退一小步然后加速前进
                 AnticipateOvershootInterpolator         @android:anim/anticipate_overshoot_interpolator       在上一个基础上超出终点一小步再回到终点
                 BounceInterpolator                      @android:anim/bounce_interpolator                     最后阶段弹球效果
                 CycleInterpolator                       @android:anim/cycle_interpolator                      周期运动
                 DecelerateInterpolator                  @android:anim/decelerate_interpolator                 减速
                 LinearInterpolator                      @android:anim/linear_interpolator                     匀速
                 OvershootInterpolator                   @android:anim/overshoot_interpolator                  快速到达终点并超出一小步最后回到终点
                 *
                 */
                animator=new ObjectAnimator().ofFloat(imgTest,"translationX",0f,360f,0f);
                animator.setDuration(2000);
                animator.setInterpolator(new BounceInterpolator());
                animator.setRepeatMode(ValueAnimator.RESTART);
                animator.setRepeatCount(ValueAnimator.REVERSE);
                animator.start();
                break;
            case R.id.btn_translationY://平移Y
                animator=new ObjectAnimator().ofFloat(imgTest,"translationY",0f,360f,0f);
                animator.setInterpolator(new AnticipateInterpolator());
                animator.setDuration(2000);
                animator.setRepeatMode(ValueAnimator.RESTART);
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.start();
                break;
            case R.id.btn_translationXY://斜角平移
                animator=new ObjectAnimator().ofFloat(imgTest,"translationX",0f,-260f,260f,0f);
                animator2=new ObjectAnimator().ofFloat(imgTest,"translationY",0f,-260f,260f,0f);
                animator3=new ObjectAnimator().ofFloat(imgTest,"translationX",0f,260f,-260f,0f);
                animator4=new ObjectAnimator().ofFloat(imgTest,"translationY",0f,-260f,260f,0f);
                animatorSet=new AnimatorSet();
                animatorSet.play(animator).with(animator2).before(animator3).before(animator4);
                animatorSet.setDuration(2000);
                animatorSet.start();
                break;
        }

    }
}
