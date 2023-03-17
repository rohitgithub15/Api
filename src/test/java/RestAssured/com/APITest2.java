package RestAssured.com;


	import io.restassured.RestAssured;

import org.json.JSONException;
//import org.json.JSONException;
	import org.json.JSONObject;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class APITest2 {

	    @Test
	    public void testAPIResponse()throws JSONException {

	        // Make API request and get response as JSON string
	        String response = RestAssured.get("https://example.com/api").asString();

	        // Parse JSON string into JSONObject
	        JSONObject jsonObject = new JSONObject(response);

	        // Traverse nested objects and properties
	        String name = jsonObject.getString("name");
	        int age = jsonObject.getInt("age");
	        JSONObject address = jsonObject.getJSONObject("address");
	        String street = address.getString("street");
	        String city = address.getString("city");
	        String state = address.getString("state");
	        JSONObject friend1 = jsonObject.getJSONArray("friends").getJSONObject(0);
	        String friend1Name = friend1.getString("name");
	        int friend1Age = friend1.getInt("age");

	        // Assert values
	        Assert.assertEquals(name, "John");
	        Assert.assertEquals(age, 30);
	        Assert.assertEquals(street, "123 Main St");
	        Assert.assertEquals(city, "New York");
	        Assert.assertEquals(state, "NY");
	        Assert.assertEquals(friend1Name, "Mary");
	        Assert.assertEquals(friend1Age, 25);
	    }
	}


