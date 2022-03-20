package files;

public class payload {
	
	public String processOrder(String order_status, String last_updated_timestamp)
	{
		String payload = "{\n"
		+ "	\"order_id\": 0,\n"
		+ "	\"order_description\": \"sample description\",\n"
		+ "	\"order_status\": \""+order_status+"\",\n"
		+ "	\"last_updated_timestamp\": \""+last_updated_timestamp+"\",\n"
		+ "	\"special_order\": false\n"
		+ "}";
		return payload;
	}
}
