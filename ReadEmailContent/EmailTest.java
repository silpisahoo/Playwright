package org.example;

import javax.mail.MessagingException;
import java.io.IOException;

public class EmailTest {
    public static void main(String[] args) throws MessagingException, IOException {
        EmailUtil emailUtil=new EmailUtil("pop.gmail.com","silpi.sahoo93@gmail.com","eheukwaxkoznwsvr");
        System.out.println(emailUtil.getEmailFromInboxCount());
        System.out.println(emailUtil.getLatestEmailSubject());
        System.out.println(emailUtil.getLatestEmailContent());


        EmailUtil emailUtilOutlook=new EmailUtil("pop.outlook.com","playwright_testing@outlook.com","Play@type1");
        System.out.println(emailUtilOutlook.getEmailFromInboxCount());
    }


}
