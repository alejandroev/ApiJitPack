package co.dito.abako.apijitpack.utils

import android.content.Context
import android.os.Environment
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel
import javax.inject.Inject

class FileUtils @Inject constructor(@ApplicationContext context: Context) {

    private val transmitterDatabaseFolder = File("${Environment.getDataDirectory()}/data/${context.packageName}/databases/")
    private val receiverDatabaseFolder = File("${Environment.getExternalStorageDirectory().absolutePath}/Abako/Databases/")

    fun transferDatabaseToExternalStorage(databaseName: String): File {
        if (!receiverDatabaseFolder.exists() && !receiverDatabaseFolder.mkdirs()) {
            throw FileUtilsException()
        }

        val transmitterDatabaseFile = File(transmitterDatabaseFolder, databaseName)
        val receiverDatabaseFile = File(receiverDatabaseFolder, databaseName)

        val src: FileChannel = FileInputStream(transmitterDatabaseFile).channel
        val dst: FileChannel = FileOutputStream(receiverDatabaseFile).channel
        dst.transferFrom(src, 0, src.size())
        src.close()
        dst.close()

        return receiverDatabaseFile
    }
}

class FileUtilsException : IOException(EXCEPTION_MESSAGE)
private const val EXCEPTION_MESSAGE = "Error al crear la carpeta de la base de datos"