package org.example;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class ReadEmail {
    public  static void check(String host,String storetype,String user,String password ) {
        try {
            Properties prop = new Properties();
            prop.put("mail.pop3.host", host);
            prop.put("mail.pop3.port", "995");
            prop.put("mail.pop3.starttls.enable", "true");
            //prop.put("mail.pop3.ssl.enable","true");


            Session emailSession = Session.getDefaultInstance(prop);

            Store store = emailSession.getStore("pop3s");
            store.connect(host, user, password);
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message message[] = emailFolder.getMessages();
            System.out.println("------------"+message.length);
            int i = ((message.length) - 1);
            Message msg = message[i];
            System.out.println("Email Number" + (i + 1));
            System.out.println("Subject: " + message[0].getSubject());
            System.out.println("From: " + message[0].getFrom());
            emailFolder.close(true);
            store.close();

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  void main (String[] args){
        String host = "pop.gmail.com";
        String mailStoreType= "pop3";
        String username = "silpi.sahoo93@gmail.com";
        String password = "eheukwaxkoznwsvr";
        check( host, mailStoreType, username,password);

    }
}

