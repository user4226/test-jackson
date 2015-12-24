package test.deserializer;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import test.domain.User;

public class UserDeserializer extends JsonDeserializer<User> {

	/*
	 * 
	 * {"id":111,"itemNr":"A200","createdBy":{"id":1,"name":"me"}}
	 * 
	 */
	@Override
	public User deserialize(JsonParser jp, DeserializationContext dc)
			throws IOException, JsonProcessingException {
	
		/*
		ObjectCodec oc = jp.getCodec();
        JsonNode node = oc.readTree(jp);
        return new User(node.get("id").getIntValue(), node.get("name").getTextValue());
        */
		
		User user = new User(0, null);
		while (jp.nextToken() != JsonToken.END_OBJECT) {
            
			String fieldname = jp.getCurrentName();
            
            if("id".equals(fieldname)){
            	jp.nextToken();
            	user.id = Integer.parseInt(jp.getText());
            }else if("name".equals(fieldname)){
            	jp.nextToken();
            	user.name = jp.getText();
            }else{
            	// doing nothing
            }
           
        }
        return user;
		
	}
}
