package com.base.core.utils;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.DestinationSource;
import org.apache.commons.io.IOUtils;
import sun.nio.ch.IOUtil;

import javax.jms.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/**
 * 可以用来查看ActiveMQ对应队列的消息内容，不消费
 * @author vector
 * @date: 2019/3/6 0006 13:49
 */
public class MQUtil {

    public static void main(String[] args) {
        try {
            extraMsgInQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void extraMsgInQueue() throws Exception {
        //tcp://activemq-hn-internal.ibole.net:61616  http://192.168.1.160:8161/admin/queues.jsp
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://120.55.168.18:8881");
        ActiveMQConnection connection = (ActiveMQConnection) connectionFactory.createConnection();
//        DestinationSource ds = connection.getDestinationSource();

        QueueSession queueSession = connection.createQueueSession(true, Session.CLIENT_ACKNOWLEDGE);
        Queue queue = queueSession.createQueue("tbd_talent_zero_update_pro_1");
        QueueBrowser browser = queueSession.createBrowser(queue);
        connection.start();
        Enumeration<?> messagesInQueue = browser.getEnumeration();

        List<String> list = new ArrayList<String>();
        while (messagesInQueue.hasMoreElements()) {
            Message queueMessage = (Message) messagesInQueue.nextElement();
            list.add(queueMessage.toString());

            if (list.size() > 500000) {
                System.out.println(list.size());
                IOUtils.writeLines(list, "\n", new FileOutputStream(new File(new Date().getTime() + ".txt")));
            }
        }
        System.exit(0);
    }

}
