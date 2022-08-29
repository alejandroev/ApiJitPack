package co.dito.abako.apijitpack.utils.backupDocument

import java.util.Date

abstract class BackupRequestData(
    @Transient open val creationDateBackup: Date,
    @Transient open val updateDateBackup: Date
)