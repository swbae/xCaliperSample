package com.iscreamreport.xcaliper.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iscreamreport.xcaliper.sample.util.XCaliperEyeTrackingEvent
import com.iscreamreport.xcaliper.utils.Base64Util
import com.iscreamreport.xcaliper.utils.getCurrentTime
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


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

                intent.putExtra("ACTOR_ID","12341234")
                intent.putExtra("ACTOR_LOGIN_ID","xCaliperSampleId")
                intent.putExtra("ACTOR_KIND_CD","Student")
                intent.putExtra("ACTOR_GRADE",3)
                intent.putExtra("ACTOR_STATUS" , "ON_SERVICE")
                intent.putExtra("ACTOR_MEMBERSHIP" , "Learner")

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

                intent.putExtra("TG_CURTIME",3600)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }

        }

        //Media - Completed (GameObject 한정)
        btn_md_completed.setOnClickListener{

            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","MediaEvent")
                intent.putExtra("ACTION_TYPE","Completed")

                intent.putExtra("OBJ_ID" , "12312314")
                intent.putExtra("OBJ_TYPE","GameObject")
                intent.putExtra("OBJ_NAME" , "1에서 5까지의 수  개념영상")
                intent.putExtra("OBJ_URL" , "mp4:data/origin_img/2011/09/02/2010902p5512485.mp4")
                intent.putExtra("OBJ_KEYWORDS" , arrayOf("수학","수의 체계", "9까지의 수", "1에서 5까지의 수"))
                intent.putExtra("OBJ_LEARN_OBJS" , arrayOf("규칙성","문제해결력"))
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

                intent.putExtra("TG_CURTIME",1200)
                intent.putExtra("TG_PREVTIME",1700)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , true)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("OBJ_MEDIA_TYPE" , "video/mp4")
                intent.putExtra("OBJ_DATE_PUBLISHED" , "2018-08-01T06:00:00.000Z")
                intent.putExtra("OBJ_DATE_MODIFIED" , "2018-08-03T06:00:00.000Z")
                intent.putExtra("OBJ_VOLUME_LEVEL" , "12")
                intent.putExtra("OBJ_VOLUME_MIN" , "2")
                intent.putExtra("OBJ_VOLUME_MAX" , "20")
                intent.putExtra("OBJ_MUTED" , false)

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
                intent.putExtra("GEN_ANNOTATOR","annotator")
                intent.putExtra("GEN_ANNOTATED","annotated")
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
                intent.putExtra("GEN_ANNOTATOR","annotator")
                intent.putExtra("GEN_ANNOTATED","annotated")
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
                intent.putExtra("GEN_ANNOTATOR","annotator")
                intent.putExtra("GEN_ANNOTATED","annotated")
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
                intent.putExtra("GEN_ANNOTATOR","annotator")
                intent.putExtra("GEN_ANNOTATED","annotated")
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
                intent.putExtra("OBJ_TYPE", "DigitalResource")
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

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }
        //assignable - paused
        btn_as_paused.setOnClickListener{
            Intent().also{
                    intent->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE","AssignableEvent")
                intent.putExtra("ACTION_TYPE","Paused")

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_TYPE", "DigitalResource")
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
                intent.putExtra("OBJ_TYPE", "DigitalResource")
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

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("TG_ID","12332")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())

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

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("TG_ID","12332")

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

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("TG_ID","12332")

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

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("TG_ID","12332")

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

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("TG_ID","12332")

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

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("TG_ID","12332")

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

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("TG_ID","12332")

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

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("TG_ID","12332")

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

                intent.putExtra("OBJ_ID","12332")
                intent.putExtra("OBJ_NAME", "3학년 수학 모의고사")
                intent.putExtra("OBJ_VERSION", "1.2.1")
                intent.putExtra("OBJ_START_AT_TIME", getCurrentTime())
                intent.putExtra("OBJ_ENDED_AT_TIME", getCurrentTime())

                intent.putExtra("REF_ID","12332")
                intent.putExtra("REF_TOTAL_CNT", 30)
                intent.putExtra("REF_CORRECT_CNT", 22)
                intent.putExtra("REF_WRONG_CNT", 7)
                intent.putExtra("REF_MARK_CNT", 1)
                intent.putExtra("REF_EXAM_TYPE", 1)

                val jArray = JSONArray()
                try {
                    for (i in 1..3) {
                        val sObject = JSONObject()
                        sObject.put("questionId", "287770")
                        sObject.put("type", "10")
                        sObject.put("result", "0")
                        sObject.put("input", "③")
                        jArray.put(sObject)
                    }

                } catch (e: JSONException) {
                    e.printStackTrace()
                }

                intent.putExtra("REF_ANSWERS", jArray.toString())

                intent.putExtra("GEN_ID","12332")
                intent.putExtra("GEN_MAXSCORE",100.0)
                intent.putExtra("GEN_SCOREGIVEN",43.0)
                intent.putExtra("GEN_COMMENT","auto-graded exam")

                intent.putExtra("TG_ID","12332")

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

        //message - Posted (음성 발화 Text 수집)
        btn_speech_recognizer_posted.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "MessageEvent")
                intent.putExtra("ACTION_TYPE", "Posted")

                intent.putExtra("OBJ_ID", "d33d1bb2-0386-4174-9fc7-6457899db9c2")
                intent.putExtra("OBJ_TYPE", "SpeechRecognizer")
                intent.putExtra("OBJ_NAME", "StopCapture")
                intent.putExtra("OBJ_BODY", "오늘 날씨 어때")

                intent.putExtra("REF_ID", "d33d1bb2-0386-4174-9fc7-6457899db9c2")
                intent.putExtra("REF_TYPE", "SpeechRecognizer")
                intent.putExtra("REF_EXPECT_SPEECH_ID", "f4f4erfrrfr-b4b4-4d53-822e-f15249d42056")
                intent.putExtra("REF_SEARCHED", true)

                intent.putExtra("TG_ID","6ef75f5e-b4b4-4d53-822e-f15249d42056")
                intent.putExtra("TG_TYPE", "Thread")

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
                intent.putExtra("OBJ_PAGE_NUM", 3)

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //View Viewed - 평가 힌트 보기
        btn_view_viewed_hint.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "ViewEvent")
                intent.putExtra("ACTION_TYPE", "Viewed")

                intent.putExtra("OBJ_ID", "123123")
                intent.putExtra("OBJ_TYPE", "AssessmentItem")
                intent.putExtra("OBJ_NAME", "3학년1학기 모의고사")
                intent.putExtra("OBJ_MEDIA_TYPE", "text/html")
                intent.putExtra("OBJ_VIEW_TYPE", "HintView")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //View Viewed - 풀이 완료 후 해설 보기
        btn_view_viewed_explan.setOnClickListener {
            Intent().also { intent ->
                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "ViewEvent")
                intent.putExtra("ACTION_TYPE", "Viewed")

                intent.putExtra("OBJ_ID", "123123")
                intent.putExtra("OBJ_TYPE", "AssessmentItem")
                intent.putExtra("OBJ_NAME", "3학년1학기 모의고사")
                intent.putExtra("OBJ_MEDIA_TYPE", "text/html")
                intent.putExtra("OBJ_VIEW_TYPE", "ExplanView")

                intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
                intent.putExtra("EDAPP_ID",packageName)
                intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Navigation NavigatedTo - 메뉴 이동 (DigitalResourceCollection)
        //OBJ_ID 는 packageName + className + OBJ_NAME(Base64 Encoding) + OBJ_CONTENT_ID(Optional)
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

        //Search Searched - 콘텐츠 검색 시
        btn_searched.setOnClickListener {
            Intent().also { intent ->

                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "SearchEvent")
                intent.putExtra("ACTION_TYPE", "Searched")

                intent.putExtra("OBJ_ID", "123123")
                intent.putExtra("OBJ_NAME", "과학")

                intent.putExtra("GEN_SEARCH_RESULTS_ITEM_COUNT", 3)

                intent.putExtra("EDAPP_NAME", getText(R.string.app_name))
                intent.putExtra("EDAPP_ID", packageName)
                intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Survey Created - 설문 생성 시
        btn_survey_created.setOnClickListener {
            Intent().also { intent ->

                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "SurveyEvent")
                intent.putExtra("ACTION_TYPE", "Created")

                intent.putExtra("OBJ_ID", "123123")
                intent.putExtra("OBJ_NAME", "설문 제목")

                intent.putExtra("EDAPP_NAME", getText(R.string.app_name))
                intent.putExtra("EDAPP_ID", packageName)
                intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Survey Deleted - 설문 삭제 시
        btn_survey_deleted.setOnClickListener {
            Intent().also { intent ->

                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "SurveyEvent")
                intent.putExtra("ACTION_TYPE", "Deleted")

                intent.putExtra("OBJ_ID", "123123")
                intent.putExtra("OBJ_NAME", "설문 제목")

                intent.putExtra("EDAPP_NAME", getText(R.string.app_name))
                intent.putExtra("EDAPP_ID", packageName)
                intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Questionnaire Started - 설문 시작 시
        btn_questionnaire_started.setOnClickListener {
            Intent().also { intent ->

                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "QuestionnaireEvent")
                intent.putExtra("ACTION_TYPE", "Started")

                intent.putExtra("OBJ_ID", "123123")
                intent.putExtra("OBJ_NAME", "설문 제목")

                intent.putExtra("EDAPP_NAME", getText(R.string.app_name))
                intent.putExtra("EDAPP_ID", packageName)
                intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //Questionnaire Submitted - 설문 제출 시
        btn_questionnaire_submitted.setOnClickListener {
            Intent().also { intent ->

                intent.setAction(getString(R.string.xcaliper_action))
                intent.putExtra("EVENT_TYPE", "QuestionnaireEvent")
                intent.putExtra("ACTION_TYPE", "Submitted")

                intent.putExtra("OBJ_ID", "123123")
                intent.putExtra("OBJ_NAME", "설문 제목")

                intent.putExtra("EDAPP_NAME", getText(R.string.app_name))
                intent.putExtra("EDAPP_ID", packageName)
                intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
                intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

                sendBroadcast(intent)
            }
        }

        //시선 추적 이벤트 (학습중일 때 - 영상 재생중 포함)
        btn_eyetracking.setOnClickListener {
            XCaliperEyeTrackingEvent.sendEyeTrackingEvent(this,
                "347413",
                10,
                0.75073117f,
                11,
                12,
                "true"
            )
        }

        //시선 추적 이벤트 (영상 재생중일 때)
        btn_eyetracking_media.setOnClickListener {
            XCaliperEyeTrackingEvent.sendEyeTrackingMediaEvent(this,
                "347413",
                10,
                0.75073117f,
                11,
                12,
                "false"
            )
        }

    }
}
