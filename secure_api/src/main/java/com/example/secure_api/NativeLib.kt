package com.example.secure_api
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class NativeLib(context: Context) {
    private var token : String? = null;


    init {
//        System.loadLibrary("secure_api")
        token = context.packageName
    }
    external fun stringFromJNI(): String
    private external fun getdomain(): String


    private external fun liveMatch(): String
    private external fun upCommingMatch() : String
    private external fun matchInfo() : String
    private external fun matchDetails() : String
    private external fun matchIning() : String
    private external fun matchLineUp() : String
    private external fun countryList() : String
    private external fun seriesList() : String
    private external fun seriesDetails() : String
    private external fun matchTable() : String
    private external fun somedaymatch() : String
    private external fun imageurl() : String


    suspend fun getliveMatch(): String? {
        val match = CoroutineScope(Dispatchers.IO).async {
            var dara =  HttpHelp().getRequest("${getdomain()}${liveMatch()}", token!!)
            dara
        }
        return match.await();
    }

    suspend fun getupCommingMatch(date: String = "20221005"): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${upCommingMatch()}/${date}",token!!)
            dara
        }
        return fixture_match.await();
    }

    suspend fun getmatchInfo(matchid: String = "20221005"): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${matchInfo()}/${matchid}",token!!)
            dara
        }
        return fixture_match.await();
    }

    suspend fun getmatchDetails(matchid: String = "20221005"): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${matchDetails()}/${matchid}",token!!)
            dara
        }
        return fixture_match.await();
    }

    suspend fun getmatchIning(matchid: String = "20221005"): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${matchIning()}/${matchid}",token!!)
            dara
        }
        return fixture_match.await();
    }

    suspend fun getmatchLineUp(matchid: String = "20221005"): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${matchLineUp()}/${matchid}",token!!)
            dara
        }
        return fixture_match.await();
    }


    suspend fun getcountryList(): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${countryList()}",token!!)
            dara
        }
        return fixture_match.await();
    }


    suspend fun getseriesList(country : String): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${seriesList()}/${country}",token!!)
            dara
        }
        return fixture_match.await();
    }


    suspend fun getseriesDetails(country : String, seriesSlug: String): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${seriesDetails()}/$country/$seriesSlug",token!!)
            dara
        }
        return fixture_match.await();
    }

    suspend fun GetLeagueTable(leaguename : String, leagueslug: String): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${matchTable()}/$leaguename/$leagueslug",token!!)
            dara
        }
        return fixture_match.await();
    }

    suspend fun getsomeDayMatch(): String? {
        val fixture_match = CoroutineScope(Dispatchers.IO).async {
            val dara =  HttpHelp().getRequest("${getdomain()}${somedaymatch()}",token!!)
            dara
        }
        return fixture_match.await();
    }


    fun getBannerImageBytes(slug: String): ByteArray? {
        return try {
            val url = URL("${imageurl()}i2/fh/xcr-${slug}.jpg")
            val connection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()

            val input: InputStream = connection.inputStream
            val buffer = ByteArrayOutputStream()
            val data = ByteArray(1024)
            var n: Int

            while (input.read(data).also { n = it } != -1) {
                buffer.write(data, 0, n)
            }

            buffer.toByteArray()
        } catch (e: Exception) {
            null
        }
    }



    companion object {
        // Used to load the 'secure_api' library on application startup.
        init {
            System.loadLibrary("secure_api")
        }
    }
}