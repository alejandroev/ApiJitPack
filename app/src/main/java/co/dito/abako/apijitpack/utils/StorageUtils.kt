package co.dito.abako.apijitpack.utils

import android.os.Environment
import android.os.StatFs

class StorageUtils {

    fun getAvailableFreeMemory(): String {
        val free: Long = (getAvailableExternalMemorySize() + getAvailableInternalMemorySize()) * 100 / (getTotalExternalMemorySize() + getTotalInternalMemorySize())
        return formatSize(free)
    }

    private fun getAvailableExternalMemorySize(): Long {
        return if (externalMemoryAvailable()) {
            val path = Environment.getExternalStorageDirectory()
            val stat = StatFs(path.path)
            val blockSize = stat.blockSizeLong
            val availableBlocks = stat.availableBlocksLong
            availableBlocks * blockSize
        } else {
            0
        }
    }

    private fun getAvailableInternalMemorySize(): Long {
        val path = Environment.getDataDirectory()
        val stat = StatFs(path.path)
        val blockSize = stat.blockSizeLong
        val availableBlocks = stat.availableBlocksLong
        return availableBlocks * blockSize
    }

    private  fun getTotalExternalMemorySize(): Long {
        return if (externalMemoryAvailable()) {
            val path = Environment.getExternalStorageDirectory()
            val stat = StatFs(path.path)
            val blockSize = stat.blockSizeLong
            val totalBlocks = stat.blockCountLong
            totalBlocks * blockSize
        } else {
            0
        }
    }

    private  fun getTotalInternalMemorySize(): Long {
        val stat = StatFs(Environment.getDataDirectory().path)
        val blockSize = stat.blockSizeLong
        val totalBlocks = stat.blockCountLong
        return totalBlocks * blockSize
    }

    private fun externalMemoryAvailable(): Boolean = Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

    private fun formatSize(size: Long): String {
        var newSize = size
        var suffix: String? = null
        if (newSize >= 1024) {
            suffix = "KB"
            newSize /= 1024
            if (newSize >= 1024) {
                suffix = "MB"
                newSize /= 1024
            }
        }
        val resultBuffer = StringBuilder(newSize.toString())
        var commaOffset = resultBuffer.length - 3
        while (commaOffset > 0) {
            resultBuffer.insert(commaOffset, ',')
            commaOffset -= 3
        }
        if (suffix != null) resultBuffer.append(suffix)
        return resultBuffer.toString()
    }
}