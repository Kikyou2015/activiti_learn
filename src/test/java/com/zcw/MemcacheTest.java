package com.zcw;

import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcacheTest {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void memcacheClient() {
		try {
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			logger.info("Connection to server successful.");

			Future fo = mcc.set("runoob", 3600, "Free Education");

			logger.info("set status: {}", fo.get());

			logger.info("runobb value in cache = {}", mcc.get("runoob"));

			fo = mcc.add("runoob", 900, "memcached");

			logger.info("add status: {}", fo.get());

			fo = mcc.add("codingground", 900, "All Free Compilers");

			logger.info("add status: {}", fo.get());

			logger.info("codingground value in cache = {}", mcc.get("codingground"));

			mcc.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void replaceOpr() {
		try {
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			logger.info("Connection to server successful.");

			Future fo = mcc.set("runoob", 900, "Free Education");

			logger.info("set status: {}", fo.get());

			logger.info("runobb value in cache = {}", mcc.get("runoob"));

			mcc.replace("runoob", 900, "Largest Tutorials' Library");

			mcc.append("runoob", " for all");

			mcc.prepend("runoob", "China ");

			logger.info("replace status: {}", fo.get());

			logger.info("runobb value in cache = {}", mcc.get("runoob"));

			mcc.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void casTest() {
		try {
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			logger.info("Connection to server successful.");

			Future fo = mcc.set("runoob", 900, "Free Education");

			logger.info("set status: {}", fo.get());

			logger.info("runobb value in cache = {}", mcc.get("runoob"));

			CASValue casValue = mcc.gets("runoob");

			logger.info("CAS token = {}", casValue);

			CASResponse casresp = mcc.cas("runoob", casValue.getCas(), 900, "Largest Git Library");

			logger.info("CAS Response = {}", casresp);

			logger.info("runobb value in cache = {}", mcc.get("runoob"));

			fo = mcc.delete("runoob");

			logger.info("delete status: {}", fo.get());

			logger.info("runobb value in cache = {}", mcc.get("runoob"));

			mcc.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void incrDecrTest() {

		try {
			MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
			logger.info("Connection to server successful.");

			Future fo = mcc.set("number", 900, "1000");

			logger.info("set status: {}", fo.get());

			logger.info("value in cache = {}", mcc.get("number"));

			logger.info("value in cache after increment = {}", mcc.incr("number", 111));

			logger.info("value in cache after decrement = {}", mcc.decr("number", 112));

			mcc.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
