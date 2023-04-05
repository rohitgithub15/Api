package RestAssured.com;

	import org.json.JSONArray;
	import org.json.JSONObject;
	import org.everit.json.schema.Schema;
	import org.everit.json.schema.loader.SchemaLoader;

	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;

	public class JsonValidator {

	    public static void main(String[] args) throws IOException {
	        String jsonResponse = "path/to/api/response.json"; // Path to the API response in JSON format
	        String jsonSchemaCsv = "path/to/json/schema.csv"; // Path to the CSV file containing the JSON schema

	        // Load the CSV file containing the JSON schema
	        BufferedReader br = new BufferedReader(new FileReader(jsonSchemaCsv));
	        String line;
	        StringBuilder jsonSchema = new StringBuilder();
	        while ((line = br.readLine()) != null) {
	            jsonSchema.append(line);
	        }
	        br.close();

	        // Parse the CSV data into a JSON object
	        JSONArray jsonSchemaArray = new JSONArray(jsonSchema.toString());
	        JSONObject jsonSchemaObj = jsonSchemaArray.getJSONObject(0);

	        // Load the JSON schema
	        Schema schema = SchemaLoader.load(jsonSchemaObj);

	        // Parse the API response into a JSON object
	        BufferedReader br2 = new BufferedReader(new FileReader(jsonResponse));
	        StringBuilder jsonResponseData = new StringBuilder();
	        while ((line = br2.readLine()) != null) {
	            jsonResponseData.append(line);
	        }
	        br2.close();

	        JSONObject jsonResponseObj = new JSONObject(jsonResponseData.toString());

	        // Validate the API response against the JSON schema
	        try {
	            schema.validate(jsonResponseObj);
	            System.out.println("API response is valid against the provided JSON schema.");
	        } catch (org.everit.json.schema.ValidationException e) {
	            System.out.println("API response is not valid against the provided JSON schema.");
	            System.out.println("Validation error: " + e.getMessage());
	        }
	    }
	}


