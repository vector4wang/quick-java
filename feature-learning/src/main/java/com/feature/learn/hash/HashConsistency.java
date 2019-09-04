package com.feature.learn.hash;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.ConsistentHash;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hash 一致性
 *
 * @author wangxc
 * @date: 2019-08-26 21:49
 */
public class HashConsistency {


    public static void main(String[] args) throws FileNotFoundException {
        List<String> nodes = new ArrayList<String>() {{
            add("192.168.0.1");
            add("192.168.0.2");
            add("192.168.0.3");
            add("192.168.0.4");
        }};
        //
        ArrayList<String> lines = IoUtil.readUtf8Lines(new FileInputStream(new File("D:\\githubspace\\java-learning-quick\\feature-learning\\src\\main\\config\\words")), new ArrayList<>());
        ConsistentHash<String> consistentHash = new ConsistentHash<>(1, nodes);
        List<String> distinctList = lines.stream().distinct().collect(Collectors.toList());
        for (String line : distinctList) {
            String node = consistentHash.get(line);
            System.out.println(line + " ---> " + node);
        }
    }


}
