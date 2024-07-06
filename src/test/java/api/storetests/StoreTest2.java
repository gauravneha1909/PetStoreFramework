package api.storetests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payload.OrderData;
import api.storeendpoints.StoreEndPoints2;
import io.restassured.response.Response;





public class StoreTest2 {
	
	
	Faker faker;
	
	OrderData orderdata;
	
	Logger logger;
	
	
	@BeforeClass
	public void beforetest()
	
	{
		
		 faker=new Faker();
		orderdata=new OrderData();
		
		orderdata.setId(faker.hashCode());
		orderdata.setComplete("true");
		orderdata.setPetId(10);
		orderdata.setQuantity(1);
		orderdata.setShipDate("2024-07-05T23:29:16.888Z");
		orderdata.setStatus("placed");
		
		logger= LogManager.getLogger(this.getClass());
		
		
		
		
	}
	
	
	
	@Test
	public void getpetbyinventory()
	
	{
		logger.info("****getting inventory info*****");
		
		Response response=StoreEndPoints2.getpetinventory("inventory");
		
		AssertJUnit.assertEquals(response.statusCode(), 200);
		
		
	}
	
	
	@Test
	
	public void addorder()
	
	{
		
		logger.info("****adding new order*****");
		
		Response response =StoreEndPoints2.postpetorder("order", orderdata);
		
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.statusCode(), 200);
		
		
	}
	
	@Test
	public void findpurchasebypetid()
	
	{
		logger.info("****finding order by pet id*****");
		
		Response response =StoreEndPoints2.getorderdetails("order", this.orderdata.getPetId());
		
		AssertJUnit.assertEquals(response.statusCode(), 200);
		
		
	}
	
	
	@Test
	public void deletepurchasebyorderid()
	
	{
		logger.info("****deleting order by order id*****");
		
		System.out.print(this.orderdata.getId());

		Response response =StoreEndPoints2.deleteorderdetails("order",this.orderdata.getId());
		
		AssertJUnit.assertEquals(response.statusCode(), 200);
		
		
	}

}
