package test.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;

import test.domain.Item;
import test.domain.User;

public class ItemSerializer extends SerializerBase<Item> {

	public ItemSerializer(){
		super(Item.class, true);
	}
	
	@Override
	public void serialize(Item value, JsonGenerator jgen,
	        SerializerProvider provider) throws IOException,
	        JsonProcessingException, JsonGenerationException {
		
	    jgen.writeStartObject();
	    jgen.writeNumberField("id", value.id);
	    jgen.writeStringField("itemNr", value.itemNr);
	    jgen.writeObjectField("createdBy", value.createdBy);
	    jgen.writeArrayFieldStart("associatedWith");
	    for(int i=0; i<value.associatedWith.size(); i++){
	    	jgen.writeObject(value.associatedWith.get(i));
	    }
	    jgen.writeEndArray();
	    jgen.writeEndObject();
	}

	@Override
	public JsonNode getSchema(SerializerProvider arg0, Type arg1)
			throws JsonMappingException {
		// TODO Auto-generated method stub
		return null;
	}

}
