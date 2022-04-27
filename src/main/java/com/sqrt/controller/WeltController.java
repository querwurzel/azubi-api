package com.sqrt.controller;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns={"/welt"})
public final class WeltController extends HttpServlet {

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, java.io.IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/rss+xml");
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			final HttpGet rssReq = new HttpGet("https://www.welt.de/feeds/latest.rss");

			try (CloseableHttpResponse rssResp = httpClient.execute(rssReq)) {
				final HttpEntity entity = rssResp.getEntity();

				if (entity != null) {
					final String result = EntityUtils.toString(entity);

					final Writer writer = response.getWriter();
					writer.write(result);
					writer.flush();
				}

			}
		}
	}

}
