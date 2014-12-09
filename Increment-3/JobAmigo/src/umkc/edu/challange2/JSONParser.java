
package umkc.edu.challange2;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParser {

	private static JSONParser parserObj;
	
	private JSONParser() {

	}

	public static JSONParser getInstance() {
		if (parserObj == null)
			parserObj = new JSONParser();

		return parserObj;
	}

	public ArrayList<JSONObject> getJobDetails(String placesJson)
	{
		ArrayList<JSONObject> JobDetails = new ArrayList<JSONObject>();
		try {
			JSONObject json = new JSONObject(placesJson);
			String status = json.getString("status");
			System.out.println("JSON status: " + json.getString("status"));
			
			if(status.equals("OK")){
				
				JSONArray results = json.getJSONArray("results");
				System.out.println("Number of items in results array: " + results.length());
				for(int i = 0; i < results.length(); i++)
				{
					JobDetails.add(results.getJSONObject(i).getJSONObject("geometry").getJSONObject("location"));
				}
				System.out.println("Number of items in store Locations array: " + JobDetails.size());
				System.out.println("Location: " + JobDetails.toString());
			}
			else if(status.equals("ZERO_RESULTS")){
                System.out.println("Sorry no places found. Try to change the types of places");
            }
            else if(status.equals("UNKNOWN_ERROR"))
            {
//                        "Sorry unknown error occured.",
            }
            else if(status.equals("OVER_QUERY_LIMIT"))
            {
//                        "Sorry query limit to google places is reached",
            }
            else if(status.equals("REQUEST_DENIED"))
            {
//                        "Sorry error occured. Request is denied",
            }
            else if(status.equals("INVALID_REQUEST"))
            {
//                        "Sorry error occured. Invalid Request",
            }
            else
            {
//                        "Sorry error occured.",
            }
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return JobDetails;
	}
}
