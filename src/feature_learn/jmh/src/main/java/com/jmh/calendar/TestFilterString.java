package com.jmh.calendar;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/6/20 0020
 * Time: 10:40
 * Description: 
 */
@OutputTimeUnit(TimeUnit.SECONDS)
@BenchmarkMode(Mode.AverageTime)
public class TestFilterString {

	private final static Pattern stringFilterPattern = Pattern
			.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]");

	private static String clearNotChinese(String str) {
		String tmpString = str.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");//去掉所有中英文符号
		char[] carr = tmpString.toCharArray();
		for (int i = 0; i < tmpString.length(); i++) {
			if (carr[i] < 0xFF) {
				carr[i] = ' ';
			}
		}
		return String.copyValueOf(carr).trim();
	}

	public static String strFilter(String str) throws PatternSyntaxException {
		Matcher m = stringFilterPattern.matcher(str);
		return m.replaceAll("").trim().replaceAll(" ", "").replaceAll("\r|\n", "");
	}

	@Benchmark
	@Threads(10)
	public void run1() {
		clearNotChinese("▲高扬");
	}

	@Benchmark
	@Threads(10)
	public void run2() {
		strFilter("▲高扬");
	}

	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder().include(TestFilterString.class.getName()).forks(1).build();
		new Runner(options).run();
	}
}
