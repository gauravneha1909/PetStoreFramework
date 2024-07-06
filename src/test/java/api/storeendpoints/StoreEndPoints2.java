package api.storeendpoints;

import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import org.testng.annotations.Test;

import api.payload.OrderData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints2 {
	
	static ResourceBundle getURL()
	{
	
	ResourceBundle routes= ResourceBundle.getBundle("routes");
	return routes;
	
	}
	
	public static Response getpetinventory(String pathparam)
	
	{
		
		String get_petinventory=getURL().getString("get_petinventory");
		
		Response response=given()
		
		.header("accept","application/json")
		.pathParam("inventory", pathparam)
		
		.when()
		.get(get_petinventory);
		
		return response;
		
		
	}
	
	public static Response postpetorder(String pathparam,OrderData orderdata)
	
	{
		String post_postorder=getURL().getString("post_postorder");
		
		Response response=given()
		
		.accept("application/json")
		.contentType(ContentType.JSON)
		.pathParam("order", pathparam)
		.body(orderdata)
		
		.when()
		
		.post(post_postorder) ;
		
		return response;
		
	}
	
	public static Response getorderdetails(String pathparam, int petid)
	
	{
		
		String get_purchaseorderbypetid=getURL().getString("get_purchaseorderbypetid");
		
		Response response=given()
		.accept("application/json")
		.pathParam("order",pathparam)
		.pathParam("petid", petid)
		
		.when()
		.get(get_purchaseorderbypetid)
		;
		
		return response;
		
		
		
		
		
		
	}

public static Response deleteorderdetails(String order,int orderid)
	
	{
	String delete_orderid=getURL().getString("delete_orderid");
	
		Response response= given()
		.accept("application/json")
		.pathParam("order", order)
		.pathParam("orderid", orderid)
		
		.when()
		.get(delete_orderid);
		return response;
		
	
		
	}



}
