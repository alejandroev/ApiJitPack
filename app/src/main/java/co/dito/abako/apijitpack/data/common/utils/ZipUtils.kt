package co.dito.abako.apijitpack.data.common.utils

import co.dito.abako.apijitpack.data.model.response.general.JsonCompress
import com.google.gson.Gson
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.nio.charset.Charset
import java.util.zip.GZIPInputStream

object ZipUtils {

    /**
     * @param zipText = info compressed
     */
    @JvmStatic
    @Deprecated("Only use for the old services, after to migrate to the new API send to Deprecated and later delete the classes")
    @Throws(IOException::class)
    fun decompress(zipText: String?): String {
        var size: Int
        val gzipBuff = Base64.decode(zipText)
        val memstream = ByteArrayInputStream(gzipBuff, 4, gzipBuff.size - 4)
        val gzin = GZIPInputStream(memstream)
        val buffSize = 8192
        val tempBuffer = ByteArray(buffSize)
        val baos = ByteArrayOutputStream()
        while (gzin.read(tempBuffer, 0, buffSize).also { size = it } != -1) {
            baos.write(tempBuffer, 0, size)
        }
        val buffer = baos.toByteArray()
        baos.close()
        return String(buffer, Charset.forName("UTF-8"))
    }
}

fun <T> JsonCompress?.mappingTo(tClass: Class<T>): T = try {
    Gson().fromJson(ZipUtils.decompress(this?.content), tClass)
} catch (ex: Exception) {
    throw BackEndException(ex.message)
}