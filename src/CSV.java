import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class CSV {
    public static String  kursas (String date, String valiuta) {
   String ats = null;
   
    try {

	String url = "https://www.lb.lt/lt/currency/daylyexport/?csv=1&class=Eu&type=day&date_day="+date;

	URL obj = new URL(url);
	HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

	BufferedReader in = new BufferedReader(
                              new InputStreamReader(conn.getInputStream()));

	
	String line = "";

	
    while ((line = in.readLine()) != null) {

      
        String[] index = line.split(";");
if (index[1].equals("\""+valiuta+"\"")){
   
    ats = index[2];
    ats = ats.substring(1, ats.length() - 1);
    break;}
        

    }
   
	in.close();


    } catch (Exception e) {
	e.printStackTrace();
    }
        return ats;
       
        

  }  

}
