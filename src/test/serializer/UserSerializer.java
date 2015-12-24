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

import test.domain.User;

public class UserSerializer extends SerializerBase<User> {

	public UserSerializer(){
		super(User.class, true);
	}
	
	@Override
	public void serialize(User value, JsonGenerator jgen,
	        SerializerProvider provider) throws IOException,
	        JsonProcessingException, JsonGenerationException {
		
	    jgen.writeStartObject();
	    jgen.writeNumberField("id", value.id);
	    jgen.writeStringField("name", value.name);
	    jgen.writeEndObject();
	}

	@Override
	public JsonNode getSchema(SerializerProvider arg0, Type arg1)
			throws JsonMappingException {
		// TODO Auto-generated method stub
		return null;
	}

}