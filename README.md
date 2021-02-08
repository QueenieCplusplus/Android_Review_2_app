# Android_Review_2_app
Bottom Navigation Bar



1. add dependency

       // BottomNaviationUI
       implementation 'com.google.android.material:material:1.1.0'
       implementation 'androidx.legacy:legacy-support-v4:1.0.0'

2. add menu item for click bars & drawable/vectorXML for buttom icon & Fragements to change view from Mainpage.



    for Menu Items=>


              <?xml version="1.0" encoding="utf-8"?>
              <menu xmlns:android="http://schemas.android.com/apk/res/android">
                  <item
                      android:id="@+id/home"
                      android:icon="@drawable/home"
                      android:title="Home" />

                  <item
                      android:id="@+id/clean"
                      android:icon="@drawable/clean"
                      android:title="Attentions" />

                  <item
                      android:id="@+id/chat"
                      android:icon="@drawable/coffee"
                      android:title="Info" />

                  <item
                      android:id="@+id/contact"
                      android:icon="@drawable/contact"
                      android:title="Remote Care" />


              </menu>



      for Fragments=>
      
              wrapper in Framelayout, and inside view using RelativeLayout

3. add frameLayout for different fragements to be inflatered & BottomNavigation Component for User to click inside Activity_Main.xml.


       <?xml version="1.0" encoding="utf-8"?>
       <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
           xmlns:app="http://schemas.android.com/apk/res-auto"
           xmlns:tools="http://schemas.android.com/tools"
           android:layout_width="match_parent"
           android:layout_height="match_parent"
           tools:context=".MainActivity">

                  <FrameLayout
                      android:id="@+id/frame_wrapper"
                      android:layout_width="match_parent"
                      android:layout_height="match_parent"
                      android:background="@color/wood"/>

                  <com.google.android.material.bottomnavigation.BottomNavigationView
                      android:id="@+id/bottomNav"
                      android:layout_width="match_parent"
                      android:layout_height="wrap_content"
                      android:layout_marginTop="550dp"
                      android:background="?android:attr/windowBackground"
                      app:itemBackground="@color/apricot"
                      app:menu="@menu/nav_menu" />
                      
                      
       </androidx.constraintlayout.widget.ConstraintLayout>




4. init instance from fragment inside MainActivity class.


              val a = AFragment()


5. snippet hereby:


              super.onCreate(savedInstanceState)
                      setContentView(R.layout.activity_main)

                      initFragment(h)

                      bottomNav.setOnNavigationItemReselectedListener {

                          when(it.itemId){

                              // see item id in menu
                              // not drawable id
                              R.id.home -> initFragment(h)
                              R.id.clean -> initFragment(a)
                              R.id.chat -> initFragment(i)
                              R.id.contact -> initFragment(c)

                          }

                      }

                  }

                  // 初始的碎片畫面
                  private fun initFragment(fragment: Fragment){
                      
                      // to pass k/v pairs
                      //supportFragmentManager.getFragment()

                      supportFragmentManager.beginTransaction().apply {
                          replace(R.id.frame_wrapper, fragment)
                          commit()
                      }

                  }

6. be careful that if you add modules for safe args, then downgrade the Gradle version.

7. be attention to add on utf-8 encode tag on the top of your vectorized drawable, otherwise you got build error for String--toooooo-Loooooong ~

   
8. for Safe Args:

   (1) at top level gradle
   
   
               buildscript {

                  dependencies {
                      // 4.1.2 downgrade for safe-args to 3.6.4
                      classpath "com.android.tools.build:gradle:3.6.4"
                      classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

                      // for safe-args
                      classpath 'com.google.gms:google-services:4.3.4'

                      // safe-args => 2.3.3
                      classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
   
   
         
   (2) at app level gradle
   
      
               plugins {

                      id 'androidx.navigation.safeargs.kotlin'
                }

         
   
![](https://raw.githubusercontent.com/QueenieCplusplus/Android_Review_2_app/main/output1.png)

![](https://raw.githubusercontent.com/QueenieCplusplus/Android_Review_2_app/main/output2.png)

![](https://raw.githubusercontent.com/QueenieCplusplus/Android_Review_2_app/main/output3.png)

ref: https://www.youtube.com/watch?v=fODp1hZxfng

          &

   Material Design IO
   https://material.io/components/bottom-navigation/android#bottom-navigation-bar
