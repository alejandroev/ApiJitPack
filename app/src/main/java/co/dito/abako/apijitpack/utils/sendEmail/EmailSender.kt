package co.dito.abako.apijitpack.utils.sendEmail

import co.dito.abako.apijitpack.utils.sendEmail.data.EmailData
import co.dito.abako.apijitpack.utils.sendEmail.data.EmailType
import javax.activation.DataHandler
import javax.activation.FileDataSource
import javax.inject.Inject
import javax.mail.Message
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMultipart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EmailSender @Inject constructor() {

    private lateinit var session: Session
    private lateinit var message: Message

    init {
        ConfigurationPropertiesEmail().prepareConfiguration { session, message ->
            this.session = session
            this.message = message
        }
    }

    suspend fun sendEmail(email: EmailData) {
        // Set Subject: header field
        message.subject = email.title

        // Create the message part
        val bodyPart = MimeBodyPart()
        // Now set the actual message
        if (email.type == EmailType.SUPPORT) {
            bodyPart.setText(email.body.toString())
        } else {
            bodyPart.setText(email.bodyError.toString())
        }
        // Create a multipart message
        val multipart = MimeMultipart()
        // Set text message part
        multipart.addBodyPart(bodyPart)

        email.paths.forEach { path ->
            val bodyAttach = MimeBodyPart()
            bodyAttach.dataHandler = DataHandler(FileDataSource(path.file))
            bodyAttach.fileName = path.name
            multipart.addBodyPart(bodyAttach)
        }
        message.setContent(multipart)

        withContext(Dispatchers.IO) {
            Transport.send(message)
        }
    }
}