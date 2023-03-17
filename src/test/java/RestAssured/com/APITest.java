package RestAssured.com;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class APITest {

    @Test
    public void testAPIResponse() {

        // Make API request and get response as JSON
        String response = RestAssured.get("https://example.com/api").asString();

        // Define JSON schema
        String schema = "{\n" +
                "  \"$schema\": \"http://json-schema.org/draft-07/schema#\",\n" +
                "  \"type\": \"object\",\n" +
                "  \"properties\": {\n" +
                "    \"id\": {\n" +
                "      \"type\": \"number\"\n" +
                "    },\n" +
                "    \"name\": {\n" +
                "      \"type\": \"string\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"required\": [\n" +
                "    \"id\",\n" +
                "    \"name\"\n" +
                "  ]\n" +
                "}";

        // Validate response against schema
        RestAssured.given().body(response)
                .when().post("/schema-validation")
                .then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));
    }
}

