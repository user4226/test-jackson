package test.deserializer;

import java.io.IOException;
import java.io.StringReader;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;
import org.codehaus.jackson.type.TypeReference;

import test.domain.Item;
import test.domain.User;

/*
 * This example is to show how to deserialize JSON string into Java objects
 * Object User is child of object Item
 */

public class Driver {

	/**
	 * @param args
	 * {"id":111,"itemNr":"A200","createdBy":{"id":1,"name":"me"}}
	 * {"id":111,"itemNr":"A200","createdBy":{"id":1,"name":"me"},"associatedWith":[{"id":2,"name":"John"},{"id":2,"name":"Jack"}]}
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String jsonStr = "{\"id\":111,\"itemNr\":\"A200\",\"createdBy\":{\"id\":1,\"name\":\"me\"}}";
		String jsonStr = "{\"id\":111,\"itemNr\":\"A200\",\"createdBy\":{\"id\":1,\"name\":\"me\"},\"associatedWith\":[{\"id\":2,\"name\":\"John\"},{\"id\":2,\"name\":\"Jack\"}]}";
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			SimpleModule simpleModule = new SimpleModule("SimpleModule",
					new Version(1, 0, 0, null));
			simpleModule.addDeserializer(Item.class, new ItemDeserializer());
			simpleModule.addDeserializer(User.class, new UserDeserializer());
			
			mapper.registerModule(simpleModule);
			
			StringReader reader = new StringReader(jsonStr);

			//Item myItem = mapper.readValue(reader, new TypeReference<Item>(){});
			Item item = mapper.readValue(reader, Item.class);
			
			System.out.println("Id : " + item.id);
			System.out.println("Item Nr : " + item.itemNr);
			System.out.println("User : " + item.createdBy.id + "," + item.createdBy.name);
			for(int i=0; i<item.associatedWith.size(); i++){
				System.out.println("User [" + i + "] : " + item.associatedWith.get(i).id + "," + item.associatedWith.get(i).name);
			}

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
