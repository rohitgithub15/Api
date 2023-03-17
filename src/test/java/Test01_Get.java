import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test01_Get {
   
	
	@Test
	void Test01() {
		
		Response response =get("https://reqres.in/api/users?delay=3");
		
		 System.out.println(response.asString());
	     System.out.println(response.getBody().asString());
		 System.out.println(response.getStatusCode());
		 System.out.println(response.getStatusLine());
		 System.out.println(response.getHeader("content-type"));
		 System.out.println(response.getTime());
		 
		 
		 
		 int statusCode = response.getStatusCode();
		 
		Assert.assertEquals(statusCode, 200);
		
		
	}
	  
	@Test
	void Test02(){
		
		given()
		.get("https://reqres.in/api/users?delay=3")
		.then()
		.statusCode(200);
		
		
	}
}
 