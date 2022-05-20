package com.iscreamreport.xcaliper.sample.util

import android.content.Context
import android.content.Intent
import com.iscreamreport.xcaliper.sample.BuildConfig
import com.iscreamreport.xcaliper.sample.R

const val XCALIPER_HOMELEARN_ES_BROADCAST_ACTION = "com.xcaliper.homelearn-es"      //홈런 초등
const val XCALIPER_HOMELEARN_MS_BROADCAST_ACTION = "com.xcaliper.homelearn-ms"      //홈런 중등

object XCaliperEyeTrackingEvent {

    /**
     * 시선 추적 이벤트 (통합)
     * 학습 시작 ~ 학습 종료까지 수집한 데이터를 학습 종료 시점에 1회만 전송
     * @param serviceId
     * 오늘의학습의 ID (스케쥴된 학습 ID = service_id)
     * 스스로학습일 때 null, 오늘의학습일 때 필수
     * @param drowsinessCnt : 졸음 횟수 (학습 시작 ~ 종료)
     * @param attentionRate : 집중도 수치 (0.0 ~ 1.0)  (학습 시작 ~ 종료 평균치)
     * @param outsideOfScreenCnt : 시선아웃 횟수 (학습 시작 ~ 종료)
     * @param protectionCnt : 시력보호 횟수 (학습 시작 ~ 종료)
     * @param calibration : 캘리브레이션 여부 : true/false
     */
    fun sendEyeTrackingEvent(context: Context,
                             serviceId: String?,
                             drowsinessCnt: Int?,
                             attentionRate: Float?,
                             outsideOfScreenCnt: Int?,
                             protectionCnt: Int?,
                             calibration: String?
    ) {
        val intent = Intent(XCALIPER_HOMELEARN_ES_BROADCAST_ACTION)
        intent.putExtra("EVENT_TYPE", "EyeTrackingEvent")
        intent.putExtra("ACTION_TYPE", "EyeTracking")
        intent.putExtra("UNIQUE_ACTION", "EyeTracking")

        intent.putExtra("OBJ_ID", serviceId)
        intent.putExtra("OBJ_DROWSINESS_CNT", drowsinessCnt)
        intent.putExtra("OBJ_ATTENTION_RATE", attentionRate)
        intent.putExtra("OBJ_OUTSIDE_OF_SCREEN_CNT", outsideOfScreenCnt)
        intent.putExtra("OBJ_PROTECTION_CNT", protectionCnt)
        intent.putExtra("OBJ_CALIBRATION", calibration)

        intent.putExtra("EDAPP_NAME", context.getString(R.string.app_name))
        intent.putExtra("EDAPP_ID", context.packageName)
        intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
        intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

        context.sendBroadcast(intent)
    }

    /**
     * 시선 추적 이벤트 (영상 재생중일 때)
     * 영상 시작 ~ 영상 종료까지 수집한 데이터를 학습 종료 시점에 1회만 전송
     * @param serviceId
     * 오늘의학습의 ID (스케쥴된 학습 ID = service_id)
     * 스스로학습일 때 null, 오늘의학습일 때 필수
     * @param drowsinessCnt : 졸음 횟수 (영상 시작 ~ 종료)
     * @param attentionRate : 집중도 수치 (0.0 ~ 1.0)  (영상 시작 ~ 종료 평균치)
     * @param outsideOfScreenCnt : 시선아웃 횟수 (영상 시작 ~ 종료)
     * @param protectionCnt : 시력보호 횟수 (영상 시작 ~ 종료)
     * @param calibration : 캘리브레이션 여부 : true/false
     */
    fun sendEyeTrackingMediaEvent(context: Context,
                             serviceId: String?,
                             drowsinessCnt: Int?,
                             attentionRate: Float?,
                             outsideOfScreenCnt: Int?,
                             protectionCnt: Int?,
                             calibration: String?
    ) {
        val intent = Intent(XCALIPER_HOMELEARN_ES_BROADCAST_ACTION)
        intent.putExtra("EVENT_TYPE", "EyeTrackingEvent")
        intent.putExtra("ACTION_TYPE", "EyeTrackingMedia")
        intent.putExtra("UNIQUE_ACTION", "EyeTrackingMedia")

        intent.putExtra("OBJ_ID", serviceId)
        intent.putExtra("OBJ_DROWSINESS_CNT", drowsinessCnt)
        intent.putExtra("OBJ_ATTENTION_RATE", attentionRate)
        intent.putExtra("OBJ_OUTSIDE_OF_SCREEN_CNT", outsideOfScreenCnt)
        intent.putExtra("OBJ_PROTECTION_CNT", protectionCnt)
        intent.putExtra("OBJ_CALIBRATION", calibration)

        intent.putExtra("EDAPP_NAME", context.getString(R.string.app_name))
        intent.putExtra("EDAPP_ID", context.packageName)
        intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
        intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

        context.sendBroadcast(intent)
    }

    /**
     * 시선 추적(졸음) 이벤트
     * @param serviceId
     * 오늘의학습의 ID (스케쥴된 학습 ID = service_id)
     * 스스로학습일 때 null, 오늘의학습일 때 필수
     * @param drowsiness
     * 졸음 여부 : true/false
     */
    @Deprecated("Deprecated") fun sendEyeTrackingDrowsinessEvent(context: Context,
                                       serviceId: String?,
                                       drowsiness: String?
    ) {
        val intent = Intent(XCALIPER_HOMELEARN_ES_BROADCAST_ACTION)
        intent.putExtra("EVENT_TYPE", "EyeTrackingEvent")
        intent.putExtra("ACTION_TYPE", "Drowsiness")
        intent.putExtra("UNIQUE_ACTION", "EyeTrackingDrowsiness")

        intent.putExtra("OBJ_ID", serviceId)
        intent.putExtra("OBJ_DROWSINESS", drowsiness)
//        intent.putExtra("OBJ_CALIBRATION", "true")

        intent.putExtra("EDAPP_NAME", context.getString(R.string.app_name))
        intent.putExtra("EDAPP_ID", context.packageName)
        intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
        intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

        context.sendBroadcast(intent)
    }

    /**
     * 시선 추적(집중) 이벤트
     * @param serviceId
     * 오늘의학습의 ID (스케쥴된 학습 ID = service_id)
     * 스스로학습일 때 null, 오늘의학습일 때 필수
     * @param attentionRate
     * 집중도 수치 (0.0 ~ 1.0)
     * @param media
     * 영상(미디어이벤트) 내에서 발생 여부 : true/false
     */
    @Deprecated("Deprecated") fun sendEyeTrackingAttentionEvent(context: Context,
                                      serviceId: String?,
                                      attentionRate: Float?,
                                      media: String?
    ) {
        val intent = Intent(XCALIPER_HOMELEARN_ES_BROADCAST_ACTION)
        intent.putExtra("EVENT_TYPE", "EyeTrackingEvent")
        intent.putExtra("ACTION_TYPE", "Attention")
        intent.putExtra("UNIQUE_ACTION", "EyeTrackingAttention")

        intent.putExtra("OBJ_ID", serviceId)
        intent.putExtra("OBJ_ATTENTION_RATE", attentionRate)
        intent.putExtra("OBJ_MEDIA", media)
//        intent.putExtra("OBJ_CALIBRATION", "true")

        intent.putExtra("EDAPP_NAME", context.getString(R.string.app_name))
        intent.putExtra("EDAPP_ID", context.packageName)
        intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
        intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

        context.sendBroadcast(intent)
    }

    /**
     * 시선 추적(부재중) 이벤트
     * @param serviceId
     * 오늘의학습의 ID (스케쥴된 학습 ID = service_id)
     * 스스로학습일 때 null, 오늘의학습일 때 필수
     * @param outsideOfScreen
     * 시선아웃 여부 : true/false
     */
    @Deprecated("Deprecated") fun sendEyeTrackingMissedEvent(context: Context,
                                       serviceId: String?,
                                       outsideOfScreen: String?
    ) {
        val intent = Intent(XCALIPER_HOMELEARN_ES_BROADCAST_ACTION)
        intent.putExtra("EVENT_TYPE", "EyeTrackingEvent")
        intent.putExtra("ACTION_TYPE", "Missed")
        intent.putExtra("UNIQUE_ACTION", "EyeTrackingMissed")

        intent.putExtra("OBJ_ID", serviceId)
        intent.putExtra("OBJ_OUTSIDE_OF_SCREEN", outsideOfScreen)
//        intent.putExtra("OBJ_CALIBRATION", "true")

        intent.putExtra("EDAPP_NAME", context.getString(R.string.app_name))
        intent.putExtra("EDAPP_ID", context.packageName)
        intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
        intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

        context.sendBroadcast(intent)
    }

    /**
     * 시선 추적(시력보호) 이벤트
     * @param serviceId
     * 오늘의학습의 ID (스케쥴된 학습 ID = service_id)
     * 스스로학습일 때 null, 오늘의학습일 때 필수
     * @param protection
     * 시력보호 여부 : true/false
     */
    @Deprecated("Deprecated") fun sendEyeTrackingProtectionEvent(context: Context,
                                       serviceId: String?,
                                       protection: String?
    ) {
        val intent = Intent(XCALIPER_HOMELEARN_ES_BROADCAST_ACTION)
        intent.putExtra("EVENT_TYPE", "EyeTrackingEvent")
        intent.putExtra("ACTION_TYPE", "Protection")
        intent.putExtra("UNIQUE_ACTION", "EyeTrackingProtection")

        intent.putExtra("OBJ_ID", serviceId)
        intent.putExtra("OBJ_PROTECTION", protection)
//        intent.putExtra("OBJ_CALIBRATION", "true")

        intent.putExtra("EDAPP_NAME", context.getString(R.string.app_name))
        intent.putExtra("EDAPP_ID", context.packageName)
        intent.putExtra("EDAPP_VERSION", BuildConfig.VERSION_NAME)
        intent.putExtra("EXT_LOCATION", this.javaClass.name.trim())

        context.sendBroadcast(intent)
    }
}