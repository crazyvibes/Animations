# Animations

What is Animation?

Animation is a method in which pictures are manipulated to appear as moving images.
So, we can think of animations as moving images.

For a better understanding of Animation, We can divide the whole android animations into three categories:

1. Basic Animation
   The best part about animation that I like is the fact that you can use animation just by writing some XML code. 
   Yeah and this is the need because in Animation, you are dealing with the UI part and in order to have Animation, 
   XML codes can be used.
		
    In order to have a thorough knowledge of Animation, we should know some of the important XML attributes that can be 
    used in your application to have a perfect Animation. Some of these attributes are:

    android:duration: It is used to specify the duration of animation i.e. how long a particular Animation will continue.
    android:interpolator: It is used to define the rate of change of Animation i.e. how fast a particular UI will change to another UI.
    android:startOffset: When you are having a number of animations one after the other, then you have to specify some time to a particular animation and that animation will wait for that duration and after that, it will start.
    android:repeatMode: This is used to repeat a particular animation.
    android:repeatCount: This is used to specify the repeat count of a particular animation. You can set the repeat count of an animation to be infinite, if you want infinite repetition.
	
	
	  loadAnimation() method is used to load the desired animation i.e. in our case, it is fade_in.xml file.

    startAnimation() method is used to start an animation on a particular component.If you want to perform some operations before, after or during the Animation, then you can implement the AnimationListener in your call and then override the below function for the same:

    onAnimationStart(): Will be called when the Animation will start.
    onAnimationEnd(): Will be called when the Animation will end.
    onAnimationRepeat(): Will be called when you repeat an Animation.
	

2. Animate Drawable Graphics
   Here, the animation is applied to the Play Button icon(rotate).There are two ways of achieving this:

   a.  Use AnimationDrawable
   b.  Use AnimatedVectorDrawable

   Use AnimationDrawable:

   One of the basic ways of animation is to play or put one image after the other. So, in this case, we are having a series of images
   that are coming one after the other. For example, if you are having five images i.e. Image1, Image2, Image3, Image4, and Image5 then 
   play one image after the other.

   To achieve this feature, you can use the AnimationDrawable class API. Here, the XML file for this is stored in the res/drawable directory
   and the XML file consists of a <animation-list> which contains a series of <items> that will be played or put one after the other.

   Below is an example of the XML file which is added in res/drawable:

   <animation-list xmlns:android="http://schemas.android.com/apk/res/android"
      android:oneshot="true">
      <item android:drawable="@drawable/rocket_thrust1" android:duration="200" />
      <item android:drawable="@drawable/rocket_thrust2" android:duration="200" />
      <item android:drawable="@drawable/rocket_thrust3" android:duration="200" />
   </animation-list>

   Here, android:oneshot is used to tell if the list is to be repeated or not. If the value is true then after the animation of the last element,
   the whole animation will be stopped. But if the value is set to false, then the animation will continue again and again.

   Use AnimatedVectorDrawable

   You can apply animation to your VectorDrawable by using the AnimatedVectorDrawable. So, basically add some Vector Assets in your project and use animationon it.
   To achieve this, you have to add three XML files in your project:

   A vector drawable in the res/drawable directory. You can create a vector drawable by right-clicking on res/drawable and then New > Drawable resource file and enter the desired name
   <!-- res/drawable/vectordrawable.xml -->
   <!-- Source: Android Developer Website -->
   <vector xmlns:android="http://schemas.android.com/apk/res/android"
     android:height="64dp"
     android:width="64dp"
     android:viewportHeight="600"
     android:viewportWidth="600">
     <group
        android:name="rotationGroup"
        android:pivotX="300.0"
        android:pivotY="300.0"
        android:rotation="45.0" >
        <path
            android:name="v"
            android:fillColor="#000000"
            android:pathData="M300,70 l 0,-70 70,70 0,0 -70,70z" />
     </group>
   </vector>

   Other way of creating vector assets in your res/drawable directory. Just right click on the res directory and click on New > Vector assets and then follow the steps.

   An animated vector drawable that is used to animate the attributes of the vector drawable i.e. <group>, <item>, etc. The main aim of this file is to apply certain animation to a certain component. For example, if you are having an attribute A in your vector drawable file and your want some Animation anim to be applied on the attribute A, then you define these things in your animated vector drawable present in the res/drawable directory.
    <!-- res/drawable/animvectordrawable.xml -->
    <animated-vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:drawable="@drawable/vectordrawable" >
     <target
         android:name="rotationGroup"
         android:animation="@anim/rotation" />
     <target
         android:name="v"
         android:animation="@anim/path_morph" />
    </animated-vector>
   At last, you have to add the Object Animator in your res/animator directory. Here, you actually define the animation to be applied on any component. To create an Animator directory go to res and right click on it. After that click on New and Android Resource Directory and select the resource type as animator and click on OK. After that go to res/animator and add the resource file of the name of your choice. Following is an example of the post:

   <!-- res/animator/rotation.xml -->
   <!-- Source: Android Developer Website -->
   <objectAnimator
     android:duration="6000"
     android:propertyName="rotation"
     android:valueFrom="0"
     android:valueTo="360" />


3. Animation between Activities

   When we are making an Android Application, then we deal with various Activities and one Activity is started after the other with the help of some triggers. 
   But if you directly open an activity from another activity then there will be a sudden change in UI and this may result in bad user experience. 
   So, we should apply some kind of Animation that can be used to have a fluent transition from one activity to the other. You can achieve this by enabling Activity
   Transitions in your application. You can apply animation to your transition in the application:

   Enter Transition: An enter transition is used to define the animation that is used when a view of the activity is entering a screen.

   Exit Transition: An exit transition is used to define the animation that is used when a view of the activity is exiting the screen.


   You can achieve this in 3 simple steps
    1) Enable Content Transition
       Go to your style.xml and add this line to enable the content transition.
   
       <item name=”android:windowContentTransitions”>true</item>
  
    2) Write Default Enter and Exit Transition for AllCastActivity
 
       public void setAnimation()
      {
       if(Build.VERSION.SDK_INT>20) {
         Slide slide = new Slide();
         slide.setSlideEdge(Gravity.LEFT);
         slide.setDuration(400);
         slide.setInterpolator(new DecelerateInterpolator());
         getWindow().setExitTransition(slide);
         getWindow().setEnterTransition(slide);
      }
      
   3) Start Activity with Intent
      Write this method in `MovieDetailActivity` to start `AllCastActivity`
   
      public void startActivity(){
        Intent i = new Intent(this,AllCastActivity.class);
         if(Build.VERSION.SDK_INT>20){ 
            ActivityOptions options =          
            ActivityOptions.makeSceneTransitionAnimation(this);
            startActivity(i,options.toBundle());
         }else {
           startActivity(i);
        } 
      }


  
  Most important!
  put your `setAnimation()`method before `setContentView()` method otherwise the animation will not work.
