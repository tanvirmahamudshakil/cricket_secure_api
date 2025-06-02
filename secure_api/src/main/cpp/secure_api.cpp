#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_getdomain(JNIEnv *env, jobject) {
    return env->NewStringUTF( "https://cricket.gtvcricketlive.com/api2");
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_liveMatch(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/live");
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_upCommingMatch(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/upcomming");
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_matchInfo(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/match/information");
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_matchDetails(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/match/details");
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_matchIning(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/match/inning");
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_matchLineUp(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/match/lineup");
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_countryList(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/countrylist");
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_seriesList(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/series");
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_seriesDetails(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/seriesdetails");
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_matchTable(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/matchtable");
}

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_secure_1api_NativeLib_somedaymatch(JNIEnv *env, jobject) {
    return env->NewStringUTF( "/matchtable/someDayMatchesGet");
}



