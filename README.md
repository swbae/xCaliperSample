# xCaliperSample
## 프로젝트 설정
**프로젝트의 build.gradle 파일의 repositories에 다음의 maven 저장소를 추가합니다.**
```kotlin
maven {
   url "s3://ise-maven-repo.s3.amazonaws.com"
   credentials(AwsCredentials) {
       accessKey AWS_ACCESS_KEY
       secretKey AWS_SECRET_KEY
   }
}
```
최종 적용된 코드는 다음과 비슷하게 될 것 입니다.
```kotlin
allprojects {
   repositories {
       google()
       jcenter()
       maven {
           url "s3://ise-maven-repo.s3.amazonaws.com"
           credentials(AwsCredentials) {
               accessKey AWS_ACCESS_KEY
               secretKey AWS_SECRET_KEY
           }
       }
   }
}
```
주의 : 하나의 프로젝트에는 보통 2개 이상의 build.gradle 파일이 있는데, 이 중 모듈이 아닌 프로젝트의 build.gradle 파일을 수정해야합니다.<br>


**프로젝트의 gradle.properties 파일에 다음 내용을 추가합니다.**
```kotlin
AWS_ACCESS_KEY=(발급 받은 Access Key)
AWS_SECRET_KEY=(발급 받은 Secret Access Key)
```
AWS_ACCESS_KEY 와 AWS_SECRET_KEY 는 발급 받은 내용을 사용하시면 됩니다.<br>
주의 : 해당 파일이 외부에 공개되지 않도록 유의합니다. ‘.gitignore’에 이 파일을 추가하는 것을 권장합니다.


**모듈의 build.gradle 파일의 dependencies에 다음 내용을 추가합니다.**
```kotlin
implementation (group: 'com.iscreamreport.xcaliper', name: 'iscreamEduXCaliper', version: '1.5.5', ext: 'aar', classifier: 'release') {
   transitive = true
}
```
개발중일때는 debug 버전을 사용하시면 됩니다.<br>
debug 버전을 사용하면 개발 서버에 데이터가 저장되며 Logcat에서 로그를 확인할 수 있습니다.<br>
gradle 파일을 수정하게 되면 Android Studio에서 Sync Now버튼이 보이게 됩니다.<br>
Sync를 하게 되면 메이븐 저장소에서 SDK 라이브러리를 다운로드 받게 됩니다.(로컬 저장소에 다운받기 때문에 프로젝트에서는 볼 수 없습니다)


**AndroidManifest.xml 파일의 application안에 다음 내용을 추가합니다.**
```kotlin
<meta-data
   android:name="com.iscreamreport.xcaliper.servicecode"
   android:value="발급 받은 서비스 코드" />
```
value 는 발급 받은 서비스 코드를 사용하시면 됩니다.


## SDK 사용법
프로젝트의 Application Class 의 onCreate() 에 XCaliper.start 를 호출합니다. 적용된 코드는 아래와 같습니다. 
```kotlin
override fun onCreate() {
   super.onCreate()
   XCaliper.start(this)
}
```
운영 배포 시 로그를 비활성화 하려면 XCaliper.start(this, false) 를 사용하면 됩니다.<br>
프로젝트의 strings.xml 에 발급받은 action 이름을 추가합니다.<br>
action 이름은 Broadcast 전송시 사용되므로 원하는 곳에 저장하여 사용하시면 됩니다.<br>

```kotlin
<resources>
   <string name="xcaliper_action">com.xcaliper.sample</string>
</resources>
```
주의 : com.xcaliper.sample 은 예제이므로 발급받은 action 이름을 넣어줘야 합니다.<br>


## 이벤트 전송 방법
데이터 전송은 Broadcast 를 통해 전송됩니다. <br>
데이터 전송시 수신처 지정을 위해 발급받은 action 이름을 넣습니다.
```kotlin
val intent = Intent(getString(R.string.xcaliper_action))
```
사용할 이벤트 이름을 설정합니다. 
```kotlin
intent.putExtra("EVENT_TYPE","SessionEvent")
```
이벤트의 액션 타입을 설정합니다.
```kotlin
intent.putExtra("ACTION_TYPE","TimedOut")
```
이벤트가 삽입되어진 위치의 앱 이름을 설정합니다. (이 코드가 삽입되어진 앱)
```kotlin
intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
```
이벤트가 삽입되어진 위치의 앱의 패키지 이름을 설정합니다.
```kotlin
intent.putExtra("EDAPP_ID",packageName)
```
이벤트가 삽입되어진 위치의 앱의 버전을 설정합니다.
```kotlin
intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
```
이벤트가 삽입되어진 위치의 클래스 이름을 설정합니다.
```kotlin
intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())
```
이벤트별 추가 데이터를 설정합니다.<br>
전송되는 모든 데이터는 Key:value의 형태의 쌍으로 전송되며, Key값과 함께 데이터 타입에 맞는 데이터를 넣어주면 됩니다.<br>
Key값과 데이터의 대한 정의는 <이벤트별 데이터 정의서>를 참고하도록 합니다.<br>
이벤트를 전송합니다.
```kotlin
sendBroadcast(intent)
```

적용된 코드는 아래와 같습니다. 
```kotlin
//Kotlin 예제 
val intent = Intent(getString(R.string.xcaliper_action))
intent.putExtra("EVENT_TYPE","SessionEvent")
intent.putExtra("ACTION_TYPE","TimedOut")

//이벤트별 추가되는 데이터 
...

intent.putExtra("EDAPP_NAME",getText(R.string.app_name))
intent.putExtra("EDAPP_ID",packageName)
intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME)
intent.putExtra("EXT_LOCATION",this.javaClass.name.trim())
sendBroadcast(intent)
```
```java
//Java 예제 
Intent intent = new Intent(getString(R.string.xcaliper_action));
intent.putExtra("EVENT_TYPE","SessionEvent");
intent.putExtra("ACTION_TYPE","TimedOut");


//이벤트별 추가되는 데이터 
...

intent.putExtra("EDAPP_NAME",getText(R.string.app_name));
intent.putExtra("EDAPP_ID",getPackageName());
intent.putExtra("EDAPP_VERSION",BuildConfig.VERSION_NAME);
intent.putExtra("EXT_LOCATION",this.getClass().getName().trim());
sendBroadcast(intent);
```

## ProGuard 적용 제외 설정
XCaliper SDK는 ProGuard로 코드 난독화를 적용하면 안 됩니다.<br>
XCaliper SDK를 사용하는 애플리케이션을 .apk 파일로 빌드할 때 ProGuard를 적용한다면, 다음과 같이 proguard-rules.pro 파일을 수정해 ProGuard 적용 대상에서 XCaliper SDK 파일을 제외합니다.
```kotlin
-keep class com.iscreamreport.xcaliper.**
-keepclassmembers class com.iscreamreport.xcaliper.** { *; }
-keep enum com.iscreamreport.xcaliper.**
-keepclassmembers enum com.iscreamreport.xcaliper.** { *; }
-keep interface com.iscreamreport.xcaliper.**
-keepclassmembers interface com.iscreamreport.xcaliper.** { *; }
```


## SDK 변경 이력
### v 1.1.0
1. GradeEvent - REF_ANSWERS 타입 변경 (List 에서 Json string 으로 변경)
2. 웹뷰(WebView) 에서 이벤트 전송 방법 변경 
3. AssignableEvent 에 Paused 액션 추가
4. MediaEvent 에 Completed 액션 추가 
5. MediaEvent 에 GameObject 추가
6. ViewEvent 에 OBJ_VIEW_TYPE 프로퍼티 추가

### v 1.2.0
1. AssignableEvent Object Type에 DigitalResource 추가
2. MediaEvent - JumpedTo 액션에 TG_PREVTIME 속성 추가

### v 1.2.2
1. Android target SDK 26 이상을 사용하는 앱은 백그라운드 실행 제한 정책 반영, Foreground Service 실행

### v 1.3.0
1. SearchEvent 추가
2. MessageEvent에 음성 발화 타입 추가

### v 1.4.0
1. 설문 관련 SurveyEvent, QuestionnaireEvent 추가
2. ViewEvent 에 OBJ_PAGE_NUM 프로퍼티 추가
3. NavigationEvent - OBJ_TYPE에 오늘의 학습일 경우 AssignableDigitalResource 추가

### v 1.4.1
1. 앱 실행 시 SDK 초기화 중 이벤트 전송이 안되는 문제 수정

### v 1.5.0
1. 시선 추적 이벤트(EyeTrackingEvent) 추가
2. Koin 라이브러리 사용 여부에 따른 모듈 명 변경

### v 1.5.1
1. 난독화 시 버그 수정
2. Log enable/disable 옵션 추가

### v 1.5.5
1. Koin 라이브러리 버전 충돌로 삭제
2. 시선 추적 이벤트에 캘리브레이션 여부 추가
3. NavigationEvent OBJ_ID 값이 없으면 SDK 에서 생성하도록 로직 추가
4. ToolUseEvent OBJ_ID, OBJ_NAME, OBJ_VERSION 값이 없으면 생성하도록 로직 추가

### v 1.5.8
1. 평가 GEN_ID, TG_ID 추가
2. 시선 추적 이벤트 학습 종료 시 1회만 수집되도록 수정

### v 1.6.1
1. 로그인 아이디 수집하지 않도록 수정

### v 1.7.0
1. 객관식 보기 선택/해제 이벤트 추가 (AssessmentItemChoiceEvent)
2. ToolUseEvent에 연습장 실행/종료 시 시험지ID, 문항ID 추가
3. 문항 채점 확인 이벤트 추가 (AssessmentItemEvent - Viewed)
4. MessageEvent에 OBJ_RECEIVER_ID 추가
5. 평가 풀이에서 해설 영상 재생 시 문항 ID 수집 (MediaEvent)