package MostActiveAuthors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ActiveAuthors {
	
	 public static void main(String[] args) {
	       
	        List<String> username = getUsername(10);
	        System.out.println(username);
	    }

	    public  static List<String> getUsername(int threshold){
	        String apiUrl = "https://jsonmock.hackerrank.com/api/article_users/search?page=";
	        List<String> usernames = new ArrayList<>();
	        int page = 1;
	        int totalPages = getTotalPages(apiUrl);

	        while (page <= totalPages){
	            String url = apiUrl+page;
	            String jsonResponse = getApiResponse(url);

	            if(jsonResponse != null){
	                int start = jsonResponse.indexOf("[");
	                int end = jsonResponse.lastIndexOf("]");
	                if(start != -1 && end!=-1){
	                    String userJson = jsonResponse.substring(start,end+1);
	                    String userEntries[] = userJson.split("\\{");

	                    for (String entry : userEntries) {
	                        if(!entry.isEmpty()){
	                            String fields[] = entry.split(",");
	                            int submissionCount = 0;
	                            String username = "";

	                            for (String field : fields){
	                                if(field.contains("submission_count")){
	                                    submissionCount = Integer.parseInt(getFieldValue(field));
	                                } else if (field.contains("username")) {
	                                    username = getFieldValue(field);
	                                }
	                            }
	                            if(submissionCount > threshold){
	                                usernames.add(username);
	                            }
	                        }
	                    }
	                }
	            }
	            page++;
	        }
	        return  usernames;
	    }

	    public static int getTotalPages(String apiUrl){
	        String url = apiUrl + 1;
	        String jsonResponse = getApiResponse(url);

	        if(jsonResponse!=null){
	            int start = jsonResponse.indexOf("\"total_pages\":");
	            int end = jsonResponse.indexOf(",",start);
	            if(start!=-1 && end != -1){
	                String totalPages =  jsonResponse.substring(start+14,end);
	                return Integer.parseInt(totalPages);
	            }
	        }
	        return 0;
	    }
	    public static String getApiResponse(String url){
	        try {
	            URL apiUrl = new URL(url);
	            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
	            connection.setRequestMethod("GET");
	            int responseCode = connection.getResponseCode();
	            if(responseCode == HttpURLConnection.HTTP_OK){
	                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String line;
	                StringBuilder response = new StringBuilder();
	                while ((line = reader.readLine())!=null){
	                    response.append(line);
	                }
	                reader.close();
	                return response.toString();
	            }

	        } catch (Exception e){
	            e.printStackTrace();
	        }
	        return  null;
	    }

	    public static  String getFieldValue(String field){
	        int separatorIndex = field.indexOf(":");
	        if(separatorIndex!=-1){
	            String value = field.substring(separatorIndex+1).trim();
	            if(value.startsWith("\"") && value.endsWith("\"")){
	                value = value.substring(1, value.length() - 1);
	            }
	            return value;
	        }
	        return "";
	    }

}
