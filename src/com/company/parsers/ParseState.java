package com.company.parsers;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.company.interfaces.IParse;
import com.company.stringClasses.Coordinates;
import com.company.stringClasses.State;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Parsing states file
  */
public class ParseState implements IParse<List<State>> {
    /**
     *
     * @param str Line from states file
     * @return states list
     */
    @Override
    public List<State> parse(String str)  {
       List<State> stateArray=new ArrayList<>();
       Pattern pattern=Pattern.compile("[A-Z]+");
       Matcher matcher=pattern.matcher(str);
       while (matcher.find())
       {
           State state=new State();
           state.setWord(str.substring(matcher.start(),matcher.end()));
           stateArray.add(state);

       }
        try{
            JSONObject obj= null;
            for(int i=0;i<stateArray.size();i++) {
                State state1=new State();
                state1=stateArray.get(i);
                String s=state1.getWord();
                JSONParser parser=new JSONParser();
                obj = (JSONObject)parser.parse(str);
                JSONArray array = (JSONArray) obj.get(s);
                List<List<List<Coordinates>>> coord=new ArrayList<>();
                state1.setWord(s);
                for(int j=0;j<array.size();j++) {
                    JSONArray array1 = (JSONArray) array.get(j);
                    List<List<Coordinates>> coordinates=new ArrayList<>();
                    for(int q=0;q<array1.size();q++) {

                        JSONArray array2 = (JSONArray) array1.get(q);
                        String stroka2=array2.toJSONString();
                        stroka2=stroka2.replace("[","");
                        stroka2=stroka2.replace("]","");
                        String []strArray=stroka2.split(",");
                        List<Coordinates> coordinate=new ArrayList<>();
                        for(int z=0;z<strArray.length;z+=2)
                        {
                            Coordinates coordinates1=new Coordinates();
                            coordinates1.setLongitude(strArray[z]);
                            coordinates1.setLatitude(strArray[z+1]);
                            coordinate.add(coordinates1);
                        }
                        coordinates.add(coordinate);
                    }
                  coord.add(coordinates);
                }
                state1.setCoordinates(coord);
                stateArray.set(i,state1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stateArray;
    }
}
