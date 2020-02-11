package ecommerceWebsite.controller.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtils {

	private String value;

	public HttpUtils(String value) {
		this.value = value;
	}

	public <T> T tomodel(Class<T> tclass) {
		try {
			return new ObjectMapper().readValue(value, tclass);
		} catch (Exception e) {
			e.getMessage();
		}

		return null;
	}

	public static HttpUtils of(BufferedReader reader) {
		StringBuilder str = new StringBuilder();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				str.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new HttpUtils(str.toString());
	}
}
