package org.example;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

import java.io.IOException;


//api key= Co3qZhhnd356LAXs
//domain = porch-factory@fsekpwtu.mailosaur.net
//server id- fsekpwtu
public class MailSaurTest {

    public static void main(String[] args) throws MailosaurException, IOException {
        String apiKey = "Co3qZhhnd356LAXs";
        String serverId = "fsekpwtu";
        String serverDomain = "fsekpwtu.mailosaur.net";

        MailosaurClient mailosaur = new MailosaurClient(apiKey);

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(serverId);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("printed-scene@" + serverDomain);

        Message message = mailosaur.messages().get(params, criteria);
        System.out.println(message.subject());
        System.out.println(message.text().body());

    }
}
