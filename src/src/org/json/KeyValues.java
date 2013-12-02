package org.json;

import java.io.FileInputStream;
import java.io.Reader;

public class KeyValues {
    private static boolean parse(KeyValuesTokener k, JSONObject context) throws JSONException {
        char c;
        String key;
        Object value;
        
        c = k.nextClean();
        if (c == KeyValuesTokener.OBJECT_START)
            throw k.syntaxError("Can not start an object here");
        else if (c == KeyValuesTokener.OBJECT_END) 
            return false;
        else
            key = k.nextString(KeyValuesTokener.STRING_DELIMITER);

        value = k.nextValue();
        
        //context.accumulate(key, value);
        if (context.has(key)) context.remove(key);
        context.put(key, value);
        
        c = k.nextClean();
        if (c == KeyValuesTokener.STRING_DELIMITER)
            k.back();
        else if (c == KeyValuesTokener.OBJECT_END)
            return false;
        else
            k.syntaxError("Expected string delimiter or object end");
        return true;
    }
    
    public static JSONObject toJSONObject(KeyValuesTokener k) throws JSONException {
        JSONObject jo = new JSONObject();
        boolean run = true;
        while (k.more() && run) {
            run = parse(k, jo);
        }
        return jo;
        
    }
    
    public static JSONObject toJSONObject(String string) throws JSONException {
        return toJSONObject(new KeyValuesTokener(string));
    }

    public static JSONObject toJSONObject(FileInputStream in) throws JSONException {
        return toJSONObject(new KeyValuesTokener(in));
    } 

    public static JSONObject toJSONObject(Reader reader) throws JSONException {
        return toJSONObject(new KeyValuesTokener(reader));
    } 
}
