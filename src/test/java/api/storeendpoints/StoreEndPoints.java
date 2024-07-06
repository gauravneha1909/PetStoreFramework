package api.storeendpoints;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import api.payload.OrderData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	
	public static Response getpetinventory(String pathparam)
	
	{
		Response response=given()
		
		.header("accept","application/json")
		.pathParam("inventory", pathparam)
		
		.when()
		.get(Routes.get_petinventory);
		
		return response;
		
		
	}
	
	public static Response postpetorder(String pathparam,OrderData orderdata)
	
	{
		
		Response response=given()
		
		.accept("application/json")
		.contentType(ContentType.JSON)
		.pathParam("order", pathparam)
		.body(orderdata)
		
		.when()
		
		.post(Routes.post_postorder) ;
		
		return response;
		
	}
	
	public static Response getorderdetails(String pathparam, int petid)
	
	{
		
		Response response=given()
		.accept("application/json")
		.pathParam("order",pathparam)
		.pathParam("petid", petid)
		
		.when()
		.get(Routes.get_purchaseorderbypetid)
		;
		
		return response;
		
		
		
		
		
		
	}

public static Response deleteorderdetails(String order,int orderid)
	
	{
		
		Response response= given()
		.accept("application/json")
		.pathParam("order", order)
		.pathParam("orderid", orderid)
		
		.when()
		.get(Routes.delete_orderid);
		return response;
		
	
		
	}



}
