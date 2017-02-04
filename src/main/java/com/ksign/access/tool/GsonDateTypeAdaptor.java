package com.ksign.access.tool;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class GsonDateTypeAdaptor implements JsonSerializer<Date>, JsonDeserializer<Date>{
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     
    public JsonElement serialize(Date src,Type t,JsonSerializationContext c) {
        String text = formatter.format(src);
        return new JsonPrimitive(text);
    }
    
    public Date deserialize(JsonElement json,Type t,JsonDeserializationContext c) throws JsonParseException {
        
        String text = json.getAsJsonPrimitive().getAsString();
        Date dt = null;
		try {
			dt = formatter.parse(text);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return dt;
    }
}
