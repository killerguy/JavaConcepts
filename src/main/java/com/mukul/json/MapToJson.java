package com.mukul.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

public class MapToJson {

	public static void main(String[] args) {

		ObjectMapper mapperObj = new ObjectMapper();
		Map<String, String> inputMap = new HashMap<>();
		inputMap.put("name", "Mukul");
		inputMap.put("site", "http://java.com");


		try {
			String jsonResp = mapperObj.writeValueAsString(inputMap);
			System.out.println(jsonResp);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
