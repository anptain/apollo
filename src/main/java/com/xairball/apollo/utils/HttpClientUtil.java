package com.xairball.apollo.utils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xairball.apollo.config.AppConstant;

public class HttpClientUtil {
	private static Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);

	private static PoolingHttpClientConnectionManager cm = null;

	static {
		LayeredConnectionSocketFactory sslsf = null;
		try {
			sslsf = new SSLConnectionSocketFactory(SSLContext.getDefault());
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("创建SSL连接失败");
		}
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("https", sslsf).register("http", new PlainConnectionSocketFactory()).build();
		cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
		cm.setMaxTotal(200);
		cm.setDefaultMaxPerRoute(20);
	}

	private static CloseableHttpClient getHttpClient() {
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

		// RequestConfig requestConfig = RequestConfig.custom()
		// .setConnectTimeout(REQUEST_TIMEOUT)
		// .setSocketTimeout(REQUEST_SOCKET_TIME).build();
		// // 设置重定向策略
		// LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
		//
		// httpClient = HttpClients.custom()
		// .setConnectionManager(httpClientConnectionManager)
		// .setDefaultRequestConfig(requestConfig)
		// .setRedirectStrategy(redirectStrategy).build();

		return httpClient;
	}

	public static String get(String url, List<BasicNameValuePair> params) {
		// 创建默认的httpClient实例
		CloseableHttpClient httpClient = HttpClientUtil.getHttpClient();
		CloseableHttpResponse httpResponse = null;
		// 发送get请求
		try {
			if (params != null && !params.isEmpty()) {
				url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(params, AppConstant.CHARSET));
			}
			// 用get方法发送http请求
			HttpGet get = new HttpGet(url);
			LOGGER.info("执行get请求, uri: " + get.getURI());
			httpResponse = httpClient.execute(get);
			// response实体
			HttpEntity entity = httpResponse.getEntity();
			if (null != entity) {
				String response = EntityUtils.toString(entity);
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				LOGGER.info("响应状态码:" + statusCode);
				LOGGER.info("响应内容:" + response);
				if (statusCode == HttpStatus.SC_OK) {
					// 成功
					return response;
				} else {
					return null;
				}
			}
			return null;
		} catch (IOException e) {
			LOGGER.error("httpclient请求失败", e);
			return null;
		} finally {
			if (httpResponse != null) {
				try {
					EntityUtils.consume(httpResponse.getEntity());
					httpResponse.close();
				} catch (IOException e) {
					LOGGER.error("关闭response失败", e);
				}
			}
		}
	}
}
