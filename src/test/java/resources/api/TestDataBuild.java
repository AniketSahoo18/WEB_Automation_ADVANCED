package resources.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pojoRequest.AddBook;
import pojoRequest.AddPlace;
import pojoRequest.Location;

public class TestDataBuild {

	// Place Data

	public static AddPlace addPlacePayLoad(Map<String, String> mapData) {
		AddPlace p = new AddPlace();
		p.setAccuracy(50);

		p.setAddress(mapData.get("Address"));
		p.setLanguage(mapData.get("Language"));
		p.setPhone_number(mapData.get("PhoneNumber"));
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName(mapData.get("Name"));

		List<String> myList = new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
	}

	public String deletePlacePayload(String placeId) {
		return "{\r\n    \"place_id\":\"" + placeId + "\"\r\n}";
	}

	// Book Data

	public static AddBook addBookPayLoad(Map<String, String> mapData) {
		AddBook b = new AddBook();

		b.setName(mapData.get("BookName"));
		b.setIsbn(mapData.get("Isbn"));
		b.setAisle(mapData.get("Aisle"));
		b.setAuthor(mapData.get("Author"));

		return b;
	}
}
