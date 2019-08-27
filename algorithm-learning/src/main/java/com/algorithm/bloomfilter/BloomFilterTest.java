package com.algorithm.bloomfilter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.lucene.util.RamUsageEstimator;

import java.util.HashSet;

/**
 * 100000000 数据加了hashset跑了一小时还没有结果
 * @author wangxc
 * @date: 2019-08-24 13:17
 *
 */
public class BloomFilterTest {
	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<>();
		BloomFilter<String> bloomFilter = BloomFilter
				.create((com.google.common.hash.Funnel<String>) (from, into) -> into.putString(from, Charsets.UTF_8),
						1024 * 1024 * 32, 0.0000001d);
		for (int i = 0; i < 100000; i++) {
			String s = RandomStringUtils.randomAlphabetic(10);
			bloomFilter.put(s);
			hashSet.add(s);
		}
		long sizeOfBloom = RamUsageEstimator.sizeOf(bloomFilter);
		long sizeOfHashSet = RamUsageEstimator.sizeOf(hashSet);

		System.out.println("BloomFilter count: " + bloomFilter.approximateElementCount() + " size: " + sizeOfBloom);
		System.out.println("HashSet count: " + hashSet.size() + " size: " + sizeOfHashSet);

		String key = "wangxingchao";
		boolean exists = bloomFilter.mightContain(key);
		if (!exists) {
			bloomFilter.put(key);
		}
		System.out.println(key + "not exist");
		System.out.println(bloomFilter.mightContain(key));

	}

}

