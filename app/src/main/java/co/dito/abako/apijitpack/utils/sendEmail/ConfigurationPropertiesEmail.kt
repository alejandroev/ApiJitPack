package co.dito.abako.apijitpack.utils.sendEmail

import java.security.Security
import java.util.Properties
import javax.mail.Authenticator
import javax.mail.Message
import javax.mail.PasswordAuthentication
import javax.mail.Session
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class ConfigurationPropertiesEmail : Authenticator() {

    fun prepareConfiguration(result: (session: Session, message: Message) -> Unit) {
        val props = Properties()
        props["mail.smtp.user"] = EMAIL_TRANSMITTER
        props["mail.smtp.password"] = PASSWORD_EMAIL_TRANSMITTER
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.smtp.host"] = "smtp.office365.com"
        props["mail.smtp.port"] = "587"
        props["mail.smtp.ssl.enable"] = "true"
        props["mail.smtp.ssl.protocols"] = "TLSv1.2"
        Security.addProvider(JSSEProvider())
        val session = Session.getInstance(props, this)
        val message = MimeMessage(session).apply {
            setFrom(InternetAddress(EMAIL_TRANSMITTER))
            addRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_RECEIVER))
        }
        result(session, message)
    }

    override fun getPasswordAuthentication(): PasswordAuthentication {
        return PasswordAuthentication(EMAIL_TRANSMITTER, PASSWORD_EMAIL_TRANSMITTER)
    }
}

private const val EMAIL_TRANSMITTER = "notificaciones@abakosoluciones.com"
private const val PASSWORD_EMAIL_TRANSMITTER = "4bak0S0L2023*"
private const val EMAIL_RECEIVER = "soporte@abakosoluciones.com"