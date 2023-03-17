package RestAssured.com;

	import org.json.JSONArray;
	import org.json.JSONObject;

	public class NestedJSONSchema {

	    public static void main(String[] args) {

	        // Create outer object
	        JSONObject outerObject = new JSONObject();

	        // Add properties to outer object
	        outerObject.put("name", "John");
	        outerObject.put("age", 30);

	        // Create inner object
	        JSONObject innerObject = new JSONObject();

	        // Add properties to inner object
	        innerObject.put("street", "123 Main St");
	        innerObject.put("city", "New York");
	        innerObject.put("state", "NY");

	        // Add inner object to outer object
	        outerObject.put("address", innerObject);

	        // Create JSON array
	        JSONArray jsonArray = new JSONArray();

	        // Create objects to add to array
	        JSONObject object1 = new JSONObject();
	        object1.put("name", "Mary");
	        object1.put("age", 25);

	        JSONObject object2 = new JSONObject();
	        object2.put("name", "Tom");
	        object2.put("age", 35);

	        // Add objects to array
	        jsonArray.put(object1);
	        jsonArray.put(object2);

	        // Add array to outer object
	        outerObject.put("friends", jsonArray);

	        // Print JSON string
	        System.out.println(outerObject.toString());
	    }
	}


