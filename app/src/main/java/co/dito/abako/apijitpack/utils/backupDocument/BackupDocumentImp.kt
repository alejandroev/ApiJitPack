package co.dito.abako.apijitpack.utils.backupDocument

import android.os.Environment
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class BackupDocumentImp<T : BackupRequestData> : BackupDocument<T> {

    private val backupFolder = File("${Environment.getExternalStorageDirectory().absolutePath}/Abako/Backup/")
    private lateinit var backupFileDocument: File

    override fun getBackup(backupName: String, tClass: Class<T>): BackupRequestData? {
        if (!backupFolder.exists() && !backupFolder.mkdirs()) {
            throw Exception("Error al crear la carpeta de backup")
        }
        backupFileDocument = File(backupFolder, backupName)
        if (!backupFileDocument.exists()) {
            return null
        }

        val reader = BufferedReader(InputStreamReader(FileInputStream(backupFileDocument)))
        val json = StringBuilder()
        var line: String?

        while (reader.readLine().also { line = it } != null) json.append(line)
        reader.close()

        return if (json.toString().isNotEmpty()) {
            Gson().fromJson(json.toString(), tClass)
        } else {
            null
        }
    }

    override fun saveBackup(backupRequestData: BackupRequestData) {
        val outStream = OutputStreamWriter(FileOutputStream(backupFileDocument))
        outStream.write(Gson().toJson(backupRequestData))
        outStream.close()
    }
}