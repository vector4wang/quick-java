package com.feature.learn.hash;

import cn.hutool.core.io.IoUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/count-primes/
 *
 * 数据集不够大，足够大的时候，31最均匀
 *
 * @author vector
 * @date: 2019/8/27 0027 15:09
 */
public class WhyUse31 {
    public static void main(String[] args) throws FileNotFoundException {
        String content = read();
        String[] split = content.split("\\n");
        List<String> strings = Arrays.asList(split);
//        Arrays.asList(args).stream().map(calculateConflictRate())
        List<Integer> multipliers = calPrimeNumber(200);
        for (Integer multiplier : multipliers) {
            List<Integer> hashes = strings.stream().map(item -> hashCode(item, multiplier)).collect(Collectors.toList());
            calculateConflictRate(multiplier,hashes);
        }
    }

    static List<Integer> calPrimeNumber(int n) {

        List<Integer> result = new ArrayList<>();
        if (n == 1 || n == 2) {
            return null;
        }

        for (int i = 2; i <= n; i++) {
            boolean flag = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(i);
            }
        }
        System.out.println(result);
        return result;
    }

    private static String read() throws FileNotFoundException {
        return IoUtil.read(new FileInputStream(new File("D:\\githubspace\\java-learning-quick\\feature-learning\\src\\main\\java\\com\\feature\\learn\\hash\\words.txt")), "utf-8");
    }

    public static void calculateConflictRate(Integer multiplier, List<Integer> hashs) {
        Comparator<Integer> cp = Integer::compareTo;
        Integer maxHash = hashs.stream().max(cp).get();
        Integer minHash = hashs.stream().min(cp).get();

        long uniqueHashNum = hashs.stream().distinct().count();
        long conflictNum = hashs.size() - uniqueHashNum;
        double conflictRate = (conflictNum * 1.0) / hashs.size();

        System.out.println(String.format("multiplier=%4d, minHash=%11d, maxHash=%10d, conflictNum=%6d, conflictRate=%.4f%%",
                multiplier, minHash, maxHash, conflictNum, conflictRate * 100));
    }

    private static Integer hashCode(String str, Integer multiplier) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = hash * multiplier + str.charAt(i);
        }

        return hash;
    }
}