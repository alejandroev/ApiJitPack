package co.dito.abako.apijitpack.utils.backupDocument

import android.content.Context
import android.os.Environment
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import javax.inject.Inject

class BackupDocumentImp<T : BackupRequestData> @Inject constructor(
    @ApplicationContext context: Context
) : BackupDocument<T> {

    private val backupFolder = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
    private lateinit var backupFileDocument: File

    override fun getBackup(backupName: String, tClass: Class<T>): BackupRequestData? {
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

    override fun deleteFiles() {
        if (backupFolder == null) {
            return
        }

        if (backupFolder.isDirectory) {
            backupFolder.listFiles()?.forEach { file ->
                file.delete()
            }
        }
    }
}