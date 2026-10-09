plugins { id("com.android.application") }
android { namespace="com.sergec.feedermonitor"; compileSdk=36
 defaultConfig { applicationId="com.sergec.feedermonitor"; minSdk=26; targetSdk=36; versionCode=1; versionName="1.0.0"; buildConfigField("String","FEEDER_API_URL","\"https://example.com/api/feeders/latest/\"") }
 buildFeatures { buildConfig=true }
 buildTypes { release { isMinifyEnabled=false; proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro") } }
 compileOptions { sourceCompatibility=JavaVersion.VERSION_17; targetCompatibility=JavaVersion.VERSION_17 }
}
