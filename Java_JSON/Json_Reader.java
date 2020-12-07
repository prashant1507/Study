import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class Json_Reader {
    public static String[] getData(String superDataType) {
        String key1 = null;
        String key2 = null;
        try {
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(new FileReader("data.json"));
            JSONObject jsonObject = (JSONObject) obj;
            
            obj = jsonParser.parse(jsonObject.get(superDataType).toString());
            jsonObject = (JSONObject) obj;
            key1 = jsonObject.get("key1").toString();
            key2 = jsonObject.get("key2").toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new String[] {key1, key2};
    }

    public static void main (String[] args) {
        System.out.print(getData("superKey1")[0]);
        System.out.print(getData("superKey1")[1]);
        System.out.print(getData("superKey2")[0]);
    }
}