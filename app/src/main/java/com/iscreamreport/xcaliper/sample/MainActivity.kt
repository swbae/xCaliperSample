package com.iscreamreport.xcaliper.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iscreamreport.xcaliper.model.Answer
import com.iscreamreport.xcaliper.utils.Base64Util
import com.iscreamreport.xcaliper.utils.getCurrentTime
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Session - LoggedIn
        btn_login.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","SessionEvent")
                intent.putExtra("ACTION_TYPE","LoggedIn")

                intent.putExtra("ACTOR_ID","631945")
                intent.putExtra("ACTOR_LOGIN_ID","pt0002b1")
                intent.putExtra("ACTOR_KIND_CD","학생")
                intent.putExtra("ACTOR_GRADE",3)
                intent.putExtra("ACTOR_STATUS" , "ON_SERVICE")
                intent.putExtra("ACTOR_MEMBERSHIP" , "정회원")

                intent.putExtra("TCHR_ID" , "12314")
                intent.putExtra("TCHR_LOGIN_ID" , "tc_test01")

                intent.putExtra("OBJ_ID", "1f6442a482de72ea6ad134943812bff564a76259")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Session - LoggedOut
        btn_logout.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","SessionEvent")
                intent.putExtra("ACTION_TYPE","LoggedOut")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())
                sendBroadcast(intent)
            }
        }

        //Session - TimeOut
        btn_timeout.setOnClickListener{

            val intent = Intent(getString(R.string.xcaliper_action))
            intent.putExtra("EVENT_TYPE","SessionEvent")
            intent.putExtra("ACTION_TYPE","TimedOut")

            intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
            intent.putExtra("EDAPP_ID",packageName)
            intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
            intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())
            sendBroadcast(intent)
        }

        //Media - Started
        btn_md_start.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","Started")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))
                intent.putExtra("OBJ_MUTED" , false)

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }


        //Media - Ended
        btn_md_end.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","Ended")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - Paused
        btn_md_paused.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","Paused")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - Resumed
        btn_md_resumed.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","Resumed")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - Restarted
        btn_md_restart.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","Restarted")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - ForwardedTo
        btn_md_forward.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","ForwardedTo")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - JumpedTo

        btn_md_jumped.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","JumpedTo")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - ChangedResolution
        btn_md_changedResolution.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","ChangedResolution")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - ChangedSize
        btn_md_changedSize.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","ChangedSize")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - ChangedSpeed
        btn_md_changedSpeed.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","ChangedSpeed")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - ChangedVolume
        btn_md_changedVolume.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","ChangedVolume")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }


        //Media - EnabledClosedCaption
        btn_md_enabledClosedCaption.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","EnabledClosedCaptioning")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - DisabledClosedCaption
        btn_md_disabledClosedCaption.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","DisabledClosedCaptioning")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }


        //Media - EnteredFullScreen
        btn_md_enterFullscreen.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","EnteredFullScreen")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - ExitedFullScreen
        btn_md_exitedFullscreen.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","ExitedFullScreen")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - Muted
        btn_md_muted.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","Muted")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - Unmuted
        btn_md_unmuted.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","Unmuted")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - OpenedPopout
        btn_md_openedPopout.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","OpenedPopout")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - ClosedPopout
        btn_md_closedPopout.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","ClosedPopout")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","VideoObject")
                intent.putExtra("OBJ_NAME" , "케냐 - 동물왕국의 두 얼굴(1/4)(12분29초)")
                intent.putExtra("OBJ_DURATION" , 3600)
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("케냐","두얼굴의 왕국","동물"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("동물의 일상","치타의 습성"))

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Annotation - bookmarked
        btn_bookmarked.setOnClickListener{
            Intent().also { intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AnnotationEvent")
                intent.putExtra("ACTION_TYPE","Bookmarked")

                intent.putExtra("OBJ_ID" , "123456")
                intent.putExtra("OBJ_TYPE" , "Document")
                intent.putExtra("OBJ_NAME" , "Annotation 샘플")

                intent.putExtra("GEN_TYPE","BookmarkAnnotation")
                intent.putExtra("GEN_BOOKMARK_NOTES","북마크 합니다.")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())
                sendBroadcast(intent)
            }
        }

        //Annotation - shared
        btn_shared.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AnnotationEvent")
                intent.putExtra("ACTION_TYPE","Shared")

                intent.putExtra("OBJ_ID" , "123456")
                intent.putExtra("OBJ_TYPE" , "Document")
                intent.putExtra("OBJ_NAME" , "Annotation 샘플")

                intent.putExtra("GEN_TYPE","SharedAnnotation")
                intent.putExtra("GEN_WITH_AGENTS",arrayOf("657585","667788"))

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Annotation - highlighted
        btn_highlighted.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AnnotationEvent")
                intent.putExtra("ACTION_TYPE","Highlighted")

                intent.putExtra("OBJ_ID" , "123456")
                intent.putExtra("OBJ_TYPE" , "Document")
                intent.putExtra("OBJ_NAME" , "Annotation 샘플")

                intent.putExtra("GEN_TYPE","HighlightAnnotation")
                intent.putExtra("GEN_SELECT_TEXT","하이라이트 합니다.")
                intent.putExtra("GEN_SELECTION_START",10)
                intent.putExtra("GEN_SELECTION_END",55)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }


        //Annotation - tagged
        btn_tagged.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AnnotationEvent")
                intent.putExtra("ACTION_TYPE","Tagged")

                intent.putExtra("OBJ_ID" , "123456")
                intent.putExtra("OBJ_TYPE" , "Document")
                intent.putExtra("OBJ_NAME" , "Annotation 샘플")

                intent.putExtra("GEN_TYPE","TagAnnotation")
                intent.putExtra("GEN_TAGS",arrayOf("수학","구구단","테스트"))

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //assignable - activated
        btn_as_activated.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssignableEvent")
                intent.putExtra("ACTION_TYPE","Activated")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_KIND","CourseSection")
                intent.putExtra("OBJ_NAME","4장 구구단 알기")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))
                intent.putExtra("OBJ_MEDIA_TYPE","video")
                intent.putExtra("OBJ_PROG_DAY","2019-08-11")

                intent.putExtra("REF_TOTAL_PLAN_COUNT",5)
                intent.putExtra("REF_PLAN_COMPLETE_COUNT",0)
                intent.putExtra("REF_SUBJ_PLAN_COUNT",3)
                intent.putExtra("REF_SUBJ_PLAN_COMPLETE_COUNT",0)
                intent.putExtra("REF_SP_PLAN_COUNT",2)
                intent.putExtra("REF_SP_PLAN_COMPLETE_COUNT",0)
                intent.putExtra("REF_SERVICE_ID","55432")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //assignable - deactivated
        btn_as_deactivated.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssignableEvent")
                intent.putExtra("ACTION_TYPE","Deactivated")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_KIND","CourseSection")
                intent.putExtra("OBJ_NAME","4장 구구단 알기")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))
                intent.putExtra("OBJ_MEDIA_TYPE","video")

                intent.putExtra("REF_SERVICE_ID","55432")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }
        //assignable - started
        btn_as_started.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssignableEvent")
                intent.putExtra("ACTION_TYPE","Started")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_KIND","CourseSection")
                intent.putExtra("OBJ_NAME","4장 구구단 알기")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))
                intent.putExtra("OBJ_MEDIA_TYPE","video")

                intent.putExtra("REF_SERVICE_ID","55432")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }
        //assignable - completed
        btn_as_completed.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssignableEvent")
                intent.putExtra("ACTION_TYPE","Completed")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_KIND","CourseSection")
                intent.putExtra("OBJ_NAME","4장 구구단 알기")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))
                intent.putExtra("OBJ_MEDIA_TYPE","video")

                intent.putExtra("REF_SERVICE_ID","55432")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //assignable - submitted
        btn_as_submitted.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssignableEvent")
                intent.putExtra("ACTION_TYPE","Submitted")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_KIND","CourseSection")
                intent.putExtra("OBJ_NAME","4장 구구단 알기")
                intent.putExtra("OBJ_DATE_TO_SUBMIT",getCurrentTime())
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))
                intent.putExtra("OBJ_MEDIA_TYPE","video")
                intent.putExtra("OBJ_PROG_DAY","2019-08-11")

                intent.putExtra("REF_TOTAL_PLAN_COUNT",5)
                intent.putExtra("REF_PLAN_COMPLETE_COUNT",0)
                intent.putExtra("REF_SUBJ_PLAN_COUNT",3)
                intent.putExtra("REF_SUBJ_PLAN_COMPLETE_COUNT",0)
                intent.putExtra("REF_SP_PLAN_COUNT",2)
                intent.putExtra("REF_SP_PLAN_COMPLETE_COUNT",0)
                intent.putExtra("REF_SERVICE_ID","55432")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }
        //assignable - reviewed
        btn_as_reviewed.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssignableEvent")
                intent.putExtra("ACTION_TYPE","Reviewed")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_KIND","CourseSection")
                intent.putExtra("OBJ_NAME","4장 구구단 알기")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))
                intent.putExtra("OBJ_MEDIA_TYPE","video")

                intent.putExtra("REF_SERVICE_ID","55432")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }


        //assessment - started
        btn_ass_started.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssessmentEvent")
                intent.putExtra("ACTION_TYPE","Started")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12332")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_SERVICE_ID","55432")
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())
                intent.putExtra("EXT_APPNAME","스쿨링 수학")

                sendBroadcast(intent)
            }
        }

        //assessment - paused
        btn_ass_paused.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssessmentEvent")
                intent.putExtra("ACTION_TYPE","Paused")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12332")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_QUESTION_ID", "1233")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_SERVICE_ID","55432")
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }


        //assessment - resumed
        btn_ass_resumed.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssessmentEvent")
                intent.putExtra("ACTION_TYPE","Resumed")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12332")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_QUESTION_ID", "1233")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_SERVICE_ID","55432")
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }


        //assessment - restarted
        btn_ass_restarted.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssessmentEvent")
                intent.putExtra("ACTION_TYPE","Restarted")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12332")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_SERVICE_ID","55432")
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //assessment - reset
        btn_ass_reset.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssessmentEvent")
                intent.putExtra("ACTION_TYPE","Reset")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12332")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_SERVICE_ID","55432")
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //assessment - submitted
        btn_ass_submitted.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "AssessmentEvent")
                intent.putExtra("ACTION_TYPE", "Submitted")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12332")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_SERVICE_ID","55432")
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }


        //assessmentItem - started
        btn_assitem_started.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "AssessmentItemEvent")
                intent.putExtra("ACTION_TYPE", "Started")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12312")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //assessmentItem - skipped
        btn_assitem_skipped.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "AssessmentItemEvent")
                intent.putExtra("ACTION_TYPE", "Skipped")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12312")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //assessmentItem - Completed
        btn_assitem_completed.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "AssessmentItemEvent")
                intent.putExtra("ACTION_TYPE", "Completed")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME","3학년1학기 모의고사")
                intent.putExtra("OBJ_MAX_ATTEMPTS",3)
                intent.putExtra("OBJ_MAX_SUMBITS",2)
                intent.putExtra("OBJ_MAX_SCORE",100.0)
                intent.putExtra("OBJ_VERSION","1.2.0")
                intent.putExtra("OBJ_KEYWORDS", arrayOf("#키워드1","#키워드2","#키워드3"))
                intent.putExtra("OBJ_LEARN_OBJS", arrayOf("이해력1","이해력2","이해력3"))

                intent.putExtra("REF_ID","12312")
                intent.putExtra("REF_COURSE_ID", "123123")
                intent.putExtra("REF_EXAM_TYPE",0)
                intent.putExtra("REF_STU_TEST_ID","12313")

                intent.putExtra("GEN_ID","123323")
                intent.putExtra("GEN_TYPE","MultipleChoiceResponse")
                intent.putExtra("GEN_VALUES", arrayOf("A"))

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //grade - grade
        btn_gd_grade.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "GradeEvent")
                intent.putExtra("ACTION_TYPE", "Graded")

                intent.putExtra("OBJ_NAME", "3학년 수학 모의고사")
                intent.putExtra("OBJ_VERSION", "1.2.1")
                intent.putExtra("OBJ_START_AT_TIME", getCurrentTime())
                intent.putExtra("OBJ_ENDED_AT_TIME", getCurrentTime())

                intent.putExtra("REF_TOTAL_CNT", 30)
                intent.putExtra("REF_CORRECT_CNT", 22)
                intent.putExtra("REF_WRONG_CNT", 7)
                intent.putExtra("REF_MARK_CNT", 1)
                intent.putExtra("REF_EXAM_TYPE", 1)

                val listdata = ArrayList<Answer>()
                for (i in 1..3) {
                    listdata.add(Answer("287770", "10", "0", "③"))
                }
                intent.putExtra("REF_ANSWERS", listdata)

                intent.putExtra("GEN_MAXSCORE",100.0)
                intent.putExtra("GEN_SCOREGIVEN",43.0)
                intent.putExtra("GEN_COMMENT","auto-graded exam")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }


        //message - markedAsRead
        btn_msg_markedAsRead.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "MessageEvent")
                intent.putExtra("ACTION_TYPE", "MarkedAsRead")

                intent.putExtra("OBJ_ID", "12332")
                intent.putExtra("OBJ_NAME", "메시지 제목")
                intent.putExtra("OBJ_BODY", "메시지 본문")
                intent.putExtra("OBJ_DESC", "설명")
                intent.putExtra("OBJ_CREATORS","631945")
                intent.putExtra("OBJ_KEYWORDS",arrayOf("#키워드1", "#키워드2", "#키워드3"))
                intent.putExtra("OBJ_DATE_CREATED", getCurrentTime())
                intent.putExtra("OBJ_DATE_MODIFIED", getCurrentTime())
                intent.putExtra("OBJ_DATE_PUBLISHED", getCurrentTime())

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //message - markedAsUnRead
        btn_msg_markedAsUnRead.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "MessageEvent")
                intent.putExtra("ACTION_TYPE", "MarkedAsUnRead")

                intent.putExtra("OBJ_ID", "12332")
                intent.putExtra("OBJ_TYPE","Message")
                intent.putExtra("OBJ_NAME", "메시지 제목")
                intent.putExtra("OBJ_BODY", "메시지 본문")
                intent.putExtra("OBJ_DESC", "설명")
                intent.putExtra("OBJ_CREATORS","631945")
                intent.putExtra("OBJ_KEYWORDS",arrayOf("#키워드1", "#키워드2", "#키워드3"))
                intent.putExtra("OBJ_DATE_CREATED", getCurrentTime())
                intent.putExtra("OBJ_DATE_MODIFIED", getCurrentTime())
                intent.putExtra("OBJ_DATE_PUBLISHED", getCurrentTime())

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //message - Posted
        btn_msg_posted.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "MessageEvent")
                intent.putExtra("ACTION_TYPE", "Posted")

                intent.putExtra("OBJ_ID", "12332")
                intent.putExtra("OBJ_TYPE","Message")
                intent.putExtra("OBJ_NAME", "메시지 제목")
                intent.putExtra("OBJ_BODY", "메시지 본문")
                intent.putExtra("OBJ_DESC", "설명")
                intent.putExtra("OBJ_CREATORS","631945")
                intent.putExtra("OBJ_KEYWORDS",arrayOf("#키워드1", "#키워드2", "#키워드3"))
                intent.putExtra("OBJ_DATE_CREATED", getCurrentTime())
                intent.putExtra("OBJ_DATE_MODIFIED", getCurrentTime())
                intent.putExtra("OBJ_DATE_PUBLISHED", getCurrentTime())

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //ToolUse Launched
        btn_tooluse_launched.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "ToolUseEvent")
                intent.putExtra("ACTION_TYPE", "Launched")

                intent.putExtra("OBJ_ID", "com.home_learn.main")
                intent.putExtra("OBJ_NAME", "홈런 메인")
                intent.putExtra("OBJ_VERSION", "1.2.2")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //ToolUse Used
        btn_tooluse_used.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "ToolUseEvent")
                intent.putExtra("ACTION_TYPE", "Used")

                intent.putExtra("OBJ_ID", "com.home_learn.main")
                intent.putExtra("OBJ_NAME", "홈런 메인")
                intent.putExtra("OBJ_VERSION", "1.2.2")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass .name.trim())

                sendBroadcast(intent)
            }
        }

        //Forum Subscribed
        btn_forum_subscribed.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "ForumEvent")
                intent.putExtra("ACTION_TYPE", "Subscribed")

                intent.putExtra("OBJ_ID", "1234")
                intent.putExtra("OBJ_NAME", "설문톡")
                intent.putExtra("OBJ_DESC", "홈런 설문조사")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Forum Unsubscribed
        btn_forum_unsubscribed.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "ForumEvent")
                intent.putExtra("ACTION_TYPE", "Unsubscribed")

                intent.putExtra("OBJ_ID", "1234")
                intent.putExtra("OBJ_NAME", "설문톡")
                intent.putExtra("OBJ_DESC", "홈런 설문조사")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //View Viewed
        btn_view_viewed.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "ViewEvent")
                intent.putExtra("ACTION_TYPE", "Viewed")

                intent.putExtra("OBJ_ID", "123123")
                intent.putExtra("OBJ_TYPE", "Page")
                intent.putExtra("OBJ_NAME", "홈런 생생정보 5월호")
                intent.putExtra("OBJ_MEDIA_TYPE", "text")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Navigation NavigatedTo - 메뉴 이동 (DigitalResourceCollection)
        //OBJ_ID 는 packageName + className + OBJ_NAME + OBJ_CONTENT_ID(Optional)
        btn_navigation_menu.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "NavigationEvent")
                intent.putExtra("ACTION_TYPE", "NavigatedTo")

                val objName = "메뉴 이동"
                intent.putExtra("OBJ_ID", "${this.javaClass.name.trim()}.${Base64Util.encode(objName.toByteArray())}")
                intent.putExtra("OBJ_TYPE", "DigitalResourceCollection")
                intent.putExtra("OBJ_NAME", objName)
                intent.putExtra("OBJ_DESC", "설명")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Navigation NavigatedTo - 콘텐츠 이동 (DigitalResource)
        //target에 해당 콘텐츠에 대한 정보를 추가함
        btn_navigation_content.setOnClickListener {
            Intent().also { intent ->

                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "NavigationEvent")
                intent.putExtra("ACTION_TYPE", "NavigatedTo")

                val objName = "콘텐츠 이동"
                intent.putExtra("OBJ_ID", "${this.javaClass.name.trim()}.${Base64Util.encode(objName.toByteArray())}.123123")
                intent.putExtra("OBJ_TYPE", "Page")
                intent.putExtra("OBJ_NAME", objName)
                intent.putExtra("OBJ_DESC", "설명")
                intent.putExtra("OBJ_CONTENT_ID", "123123")
                intent.putExtra("OBJ_MEDIA_TYPE", "text")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

    }
}
