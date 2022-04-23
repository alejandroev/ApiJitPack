private const val ANDROID_X_CORE_VERSION = "1.7.0"
private const val APP_COMPAT_VERSION = "1.4.1"
private const val GOOGLE_MATERIAL_VERSION = "1.5.0"
private const val CONSTRAINT_LAYOUT_VERSION = "2.1.3"
private const val RETROFIT_VERSION = "2.9.0"
private const val KOTLINX_COROUTINES_VERSION = "1.6.1"
private const val LIFECYCLE_KTX_VERSION = "2.4.1"

private const val HILT_VERSION = "2.40.5"

private const val MOCKK_VERSION = "1.12.3"
private const val KOTLINX_COROUTINES_TEST_VERSION = "1.6.0"
private const val CORE_TESTING_VERSION = "2.1.0"
private const val JUNIT_VERSION = "4.13.2"
private const val TEST_JUNIT_VERSION = "1.1.3"
private const val ESPRESSO_VERSION = "3.4.0"

private const val HILT_TESTING_VERSION = "2.35"

object Dependencies {

    const val ANDROID_X_CORE = "androidx.core:core-ktx:$ANDROID_X_CORE_VERSION"
    const val APP_COMPAT = "androidx.appcompat:appcompat:$APP_COMPAT_VERSION"
    const val GOOGLE_MATERIAL = "com.google.android.material:material:$GOOGLE_MATERIAL_VERSION"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:$CONSTRAINT_LAYOUT_VERSION"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"

    const val DAGGER_HILT = "com.google.dagger:hilt-android:$HILT_VERSION"
    const val KAPT_DAGGER_HILT = "com.google.dagger:hilt-android-compiler:$HILT_VERSION"

    const val JUNIT = "junit:junit:$JUNIT_VERSION"
    const val JUNIT_EXT = "androidx.test.ext:junit:$TEST_JUNIT_VERSION"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:$ESPRESSO_VERSION"

    const val KOTLINX_COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:$KOTLINX_COROUTINES_VERSION"

    const val LIFECYCLE_VIEWMODEL_KTX =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_KTX_VERSION"

    const val LIFECYCLE_RUNTIME_KTX =
        "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_KTX_VERSION"

    const val MOCKK = "io.mockk:mockk:$MOCKK_VERSION"
    const val KOTLINX_COROUTINES_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:$KOTLINX_COROUTINES_TEST_VERSION"
    const val CORE_TESTING = "androidx.arch.core:core-testing:$CORE_TESTING_VERSION"

    const val HILT_ANDROID_TESTING = "com.google.dagger:hilt-android-testing:$HILT_TESTING_VERSION"
    const val HILT_ANDROID_COMPILER =
        "com.google.dagger:hilt-android-compiler:$HILT_TESTING_VERSION"
}