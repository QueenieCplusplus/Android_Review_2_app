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


4. init instance from fragment inside MainActivity class.


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

   
   
![](https://raw.githubusercontent.com/QueenieCplusplus/Android_Review_2_app/main/output1.png)

![](https://raw.githubusercontent.com/QueenieCplusplus/Android_Review_2_app/main/output2.png)

![](https://raw.githubusercontent.com/QueenieCplusplus/Android_Review_2_app/main/output3.png)

ref: https://www.youtube.com/watch?v=fODp1hZxfng

          &

   Material Design IO
