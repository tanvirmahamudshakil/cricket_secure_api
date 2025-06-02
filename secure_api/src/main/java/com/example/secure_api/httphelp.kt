package com.example.secure_api

import android.util.Log
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
import java.lang.annotation.Native
import java.net.URL


class HttpHelp {
    var client: OkHttpClient = OkHttpClient()
    fun getRequest(sUrl: String, token: String): String? {

        var result: String? = null
        try {
            // Create URL
            val url = URL(sUrl)
            // Build request
            val request = Request.Builder().header("ab", token).url(url).build()
            // Execute request
            val response = client.newCall(request).execute()
            result = response.body?.string()
        }
        catch(err:Error) {
            print("Error when executing get request: "+err.localizedMessage)
        }
        return result
    }

    fun getImageData(sUrl: String, token: String): ByteArray? {

        var result: ByteArray? = null
        try {
            // Create URL
            val url = URL(sUrl)
            // Build request
            val request = Request.Builder().header("ab", token).url(url).build()
            // Execute request
            val response = client.newCall(request).execute()
            result = response.body?.bytes()
        }
        catch(err:Error) {
            print("Error when executing get request: "+err.localizedMessage)
        }
        return result
    }

    fun postRequest(sUrl: String, token: String, matchid : Int, home : Int, away : Int, homename : String, awayname : String, draw : Int): String? {
        var result: String? = null
        try {
            val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("matchid", "${matchid}")
                .addFormDataPart("home", "${home}")
                .addFormDataPart("away", "${away}")
                .addFormDataPart("draw", "${draw}")
                .addFormDataPart("homename", "${homename}")
                .addFormDataPart("awayname", "${awayname}")
                .build()

            val request = Request.Builder()
                .header("ab", token)
                .url(sUrl)
                .post(requestBody)
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                result = response.body!!.string();
            }
        } catch(err:Error) {
            print("Error when executing get request: "+err.localizedMessage)
        }
        return result;
    }


}