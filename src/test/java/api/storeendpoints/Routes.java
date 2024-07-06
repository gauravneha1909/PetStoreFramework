package api.storeendpoints;

public class Routes {
	
	public static String baseURI="https://petstore.swagger.io/v2/store";
	
	public static String get_petinventory= baseURI+"/{inventory}";
	public static String post_postorder=baseURI+"/{order}";
	public static String get_purchaseorderbypetid=baseURI+"/{order}/{petid}";
	public  static String delete_orderid=baseURI+"/{order}/{orderid}";

}
