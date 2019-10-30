# xCaliperSample
### 프로젝트 설정
1. 프로젝트의 build.gradle 파일의 repositories에 다음의 maven 저장소를 추가합니다.
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

2. 프로젝트의 gradle.properties 파일에 다음 내용을 추가합니다.
```kotlin
AWS_ACCESS_KEY=(발급 받은 Access Key)
AWS_SECRET_KEY=(발급 받은 Secret Access Key)
```
AWS_ACCESS_KEY 와 AWS_SECRET_KEY 는 발급 받은 내용을 사용하시면 됩니다.<br>
주의 : 해당 파일이 외부에 공개되지 않도록 유의합니다. ‘.gitignore’에 이 파일을 추가하는 것을 권장합니다.

3. 모듈의 build.gradle 파일의 dependencies에 다음 내용을 추가합니다.**
```kotlin
implementation (group: 'com.iscreamreport.xcaliper', name: 'iscreamEduXCaliper', version: '1.0.0', ext: 'aar', classifier: 'release') {
   transitive = true
}
```
개발중일때는 debug 버전을 사용하시면 됩니다.<br>
debug 버전을 사용하면 개발 서버에 데이터가 저장되며 Logcat에서 로그를 확인할 수 있습니다.<br>
gradle 파일을 수정하게 되면 Android Studio에서 Sync Now버튼이 보이게 됩니다.<br>
Sync를 하게 되면 메이븐 저장소에서 SDK 라이브러리를 다운로드 받게 됩니다.(로컬 저장소에 다운받기 때문에 프로젝트에서는 볼 수 없습니다)

4. AndroidManifest.xml 파일의 application안에 다음 내용을 추가합니다.**
```kotlin
<meta-data
   android:name="com.iscreamreport.xcaliper.servicecode"
   android:value="발급 받은 서비스 코드" />
```
value 는 발급 받은 서비스 코드를 사용하시면 됩니다.

### SDK 사용법
프로젝트의 Application Class 의 onCreate() 에 XCaliper.start 를 호출합니다. 적용된 코드는 아래와 같습니다. 
```kotlin
override fun onCreate() {
   super.onCreate()
   XCaliper.start(this)
}
```
프로젝트의 strings.xml 에 발급받은 action 이름을 추가합니다. action 이름은 Broadcast 전송시 사용되므로 원하는 곳에 저장하여 사용하시면 됩니다. 아래 예제는 strings.xml에 저장 후 불러오는 코드입니다. 
```kotlin
<resources>
   <string name="xcaliper_action">com.xcaliper.sample</string>
</resources>
```
주의 : com.xcaliper.sample 은 예제이므로 발급받은 action 이름을 넣어줘야 합니다. 
```kotlin
//Kotlin 예제 
val intent = Intent(getString(R.string.xcaliper_action))
intent.putExtra("EVENT_TYPE", "NavigationEvent")
intent.putExtra("ACTION_TYPE", "NavigatedTo")
//추가 데이터 
...
sendBroadcast(intent)
```
```java
//Java 예제 
Intent intent = new Intent(getString(R.string.xcaliper_action));
intent.putExtra("EVENT_TYPE","NavigationEvent");
intent.putExtra("ACTION_TYPE","NavigatedTo");
//추가 데이터 
...
sendBroadcast(intent);
```

### 이벤트 전송 방법 & 데이터 정의
별도로 전달드린 가이드 문서를 참고바랍니다.