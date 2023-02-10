package org.example;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class EmailUtil {
    Store store;
    Folder emailFolder;
    public EmailUtil(String host,String userName, String password){
        try {
            Properties prop = new Properties();
            prop.put("mail.pop3.host", host);
            prop.put("mail.pop3.port", "995");
            prop.put("mail.pop3.starttls.enable", "true");

            Session emailSession = Session.getDefaultInstance(prop);

            store = emailSession.getStore("pop3s");
            store.connect(host, userName, password);
            emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getEmailFromInboxCount() throws MessagingException {
        Message message[] = emailFolder.getMessages();
        return message.length;
    }
    public String getLatestEmailSubject() throws MessagingException {
        Message message[] = emailFolder.getMessages();
        return message[message.length-1].getSubject();
    }
    public Object getLatestEmailContent() throws MessagingException, IOException {
        Message message[] = emailFolder.getMessages();
        return message[message.length-1].getContent();
    }
    public void closeInbox() throws MessagingException {
        emailFolder.close(true);
        store.close();
    }

}
