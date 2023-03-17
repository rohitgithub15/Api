package RestAssured.com;

	import io.restassured.RestAssured;
	import org.json.JSONException;
	import org.json.JSONObject;
	import org.testng.Assert;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import org.everit.json.schema.Schema;
	import org.everit.json.schema.loader.SchemaLoader;

	//import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Paths;

	public class APITest3 {

	    private String endpointUrl;
	    private Schema schema;

	    @BeforeClass
	    public void setUp() throws IOException {
	        // Set endpoint URL and JSON schema file path
	        endpointUrl = "https://example.com/api";
	        String schemaFilePath = "schema.json";

	        // Load JSON schema from file
	        String schemaString = new String(Files.readAllBytes(Paths.get(schemaFilePath)));
	        JSONObject schemaJson = new JSONObject(schemaString);
	        schema = SchemaLoader.load(schemaJson);
	    }

	    @Test
	    public void testAPIResponse() throws JSONException, IOException {

	        // Make API request and get response as JSON string
	        String response = RestAssured.get(endpointUrl).asString();

	        // Validate response against JSON schema
	        schema.validate(new JSONObject(response));

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


