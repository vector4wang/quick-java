package com.jmh.calendar;

import org.joda.time.DateTime;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

/**
 * Created with IDEA
 * User: vector 
 * Data: 2018/6/11 0011
 * Time: 10:11
 * Description: 
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class TestMain {
	static int mills = 24 * 3600 * 1000;

	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder().include(TestMain.class.getName()).forks(1).build();
		new Runner(options).run();
	}

	@Benchmark
	@Threads(5)
	public void runCalendar() {
		Calendar calendar = Calendar.getInstance();
	}


	@Benchmark
	@Threads(5)
	public void runJoda() {
		DateTime dateTime = new DateTime();
	}

	@Benchmark
	@Threads(5)
	public void runSystem() {
		long result = System.currentTimeMillis() / mills;
	}
}
