package utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIUtil {

	public static String getJsonPath(Response response, String key) {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		return js.get(key).toString();
	}

	public static List<String> getKeys(Response response) throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		String json = response.asString();
		List<String> keys = new ArrayList<String>();
		JsonNode jsonNode = mapper.readTree(json);

		Iterator<String> iterator = jsonNode.fieldNames();
		iterator.forEachRemaining(e -> keys.add(e));

//		System.out.println(keys);

		return keys;
	}
}
