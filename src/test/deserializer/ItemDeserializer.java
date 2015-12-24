package test.deserializer;

import java.io.IOException;
import java.util.ArrayList;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.type.TypeReference;

import test.domain.Item;
import test.domain.User;

public class ItemDeserializer extends JsonDeserializer<Item> {

	//public static TypeReference ref = new TypeReference<User>() { };
	
	/*
	 * 
	 * {"id":111,"itemNr":"A200","createdBy":{"id":1,"name":"me"}}
	 * 
	 */
	//public ItemDeserializer(){
		//super(Item.class);
	//}
	
	
	@Override
	public Item deserialize(JsonParser jp, DeserializationContext dc)
			throws IOException, JsonProcessingException {
		
		/*
		 * This is one way to implement deserializer
		 * 
		 */
		//ObjectCodec oc = jp.getCodec();
        //JsonNode node = oc.readTree(jp);
       
        // return new User(null, node.get("username").getTextValue(), 
        //	node.get("password").getTextValue());
		
		/*
		 * This is one way to implement deserializer
		 * 
		 */
		Item item = new Item(0, null, null);
		while (jp.nextToken() != JsonToken.END_OBJECT) {
			
            String fieldname = jp.getCurrentName();
            if("id".equals(fieldname)){
            	jp.nextToken();
            	item.id = Integer.parseInt(jp.getText());
            }else if("itemNr".equals(fieldname)){
            	jp.nextToken();
            	item.itemNr = jp.getText();
            }else if("createdBy".equals(fieldname)){
            	jp.nextToken();
            	//User user = jp.readValueAs(new TypeReference<User>(){});
            	User user = jp.readValueAs(User.class);
            	item.createdBy = user;
            }else if("associatedWith".equals(fieldname)){
            	jp.nextToken();
            	item.associatedWith = jp.readValueAs(new TypeReference<ArrayList<User>>(){});
            }else{
            	// doing nothing
            }
        }
		
		return item;
	}

}
