package resources.api;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	// Place API resources
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json"),
	
	// Library API resources
	
	AddBookAPI("/Library/Addbook.php");

	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
