package co.dito.abako.apijitpack.utils.backupDocument

interface BackupDocument<T: BackupRequestData> {

    fun getBackup(backupName: String, tClass: Class<T>): BackupRequestData?

    fun saveBackup(backupRequestData: BackupRequestData)
}