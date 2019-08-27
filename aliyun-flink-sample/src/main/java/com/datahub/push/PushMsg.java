package com.datahub.push;

import com.aliyun.datahub.client.DatahubClient;
import com.aliyun.datahub.client.DatahubClientBuilder;
import com.aliyun.datahub.client.auth.AliyunAccount;
import com.aliyun.datahub.client.common.DatahubConfig;
import com.aliyun.datahub.client.http.HttpConfig;
import com.aliyun.datahub.client.model.*;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author vector
 * @date: 2019/8/19 0019 13:43
 */
public class PushMsg {

    private static String endpoint = "https://dh-cn-shenzhen.aliyuncs.com";
    private static String accessId = "LTAIdhTimxPyt5Ng";
    private static String accessKey = "C66tdOqByXH3MHeAT88IPj9xAFauoR";

    private static String projectName = "flinkhub";
    private static String topicName = "datahub_ipplace";
    private static String shardId = "0";
    private static int recordLimit = 10;


    public static void main(String[] args) throws IOException {

        write();


    }

    private static void write() throws IOException {
        DatahubClient client = getClient();

        RecordSchema schema = new RecordSchema();


        schema.addField(new Field("name", FieldType.STRING));
        schema.addField(new Field("place", FieldType.STRING));
        // generate 10 records
        List<RecordEntry> recordEntries = new ArrayList<>();
        List<String> cityList = IOUtils.readLines(new FileInputStream(new File("D:\\code\\feature\\baza-fs-base-tools\\FDT-1356\\baza-fs-base-tools\\push-msg-datahub\\src\\main\\resources\\city.txt")));
        Random random = new Random();
        while (true) {
            for (int i = 0; i < 100; ++i) {
                RecordEntry recordEntry = new RecordEntry();
                // set attributes
                recordEntry.addAttribute("key1", "value1");
                // set tuple data
                TupleRecordData data = new TupleRecordData(schema);
                data.setField("name", "name" + random.nextInt(100));
                Collections.shuffle(cityList);
                System.out.println(cityList.get(0));
                data.setField("place", cityList.get(0));

                recordEntry.setRecordData(data);
                recordEntries.add(recordEntry);
            }

//        client.putRecordsByShard(projectName, topicName, shardId, recordEntries);
            client.putRecords(projectName, topicName, recordEntries);

        }


    }

    public static DatahubClient getClient() {
        DatahubClient datahubClient = DatahubClientBuilder.newBuilder()
                .setDatahubConfig(
                        new DatahubConfig(endpoint,
                                // 是否开启二进制传输，服务端2.12版本开始支持
                                new AliyunAccount(accessId, accessKey), true))
                //专有云使用出错尝试将参数设置为       false
                // HttpConfig可不设置，不设置时采用默认值
                .setHttpConfig(new HttpConfig().setConnTimeout(10000))
                .build();

        return datahubClient;
    }

    public static void read() {
        DatahubClient client = getClient();
        // Tuple Topic schema
        RecordSchema schema = new RecordSchema();
        schema.addField(new Field("name", FieldType.STRING));
        schema.addField(new Field("place", FieldType.STRING));

        String cursor = client.getCursor(projectName, topicName, shardId, CursorType.LATEST).getCursor();


        // 读取数据
        GetRecordsResult result = client.getRecords(projectName, topicName, shardId, schema, cursor, recordLimit);
        // 如果有数据则处理，无数据需sleep后重新读取
        if (result.getRecordCount() > 0) {
            for (RecordEntry entry : result.getRecords()) {
                TupleRecordData data = (TupleRecordData) entry.getRecordData();
                System.out.println("field1:" + data.getField("name"));
                System.out.println("field2:" + data.getField("place"));
            }
        }
    }


}
