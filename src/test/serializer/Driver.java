package test.serializer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import test.domain.Item;
import test.domain.User;

/*
 * This example shows how to serialize java objects into JSON string
 */

public class Driver {

	public static void main(String[] args) {

		User myUser = new User(1, "me");
		User myUser1 = new User(2, "John");
		User myUser2 = new User(2, "Jack");
		ArrayList<User> list = new ArrayList<User>();
		list.add(myUser1);
		list.add(myUser2);
		Item myItem = new Item(111, "A200", myUser, list);
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			SimpleModule simpleModule = new SimpleModule("SimpleModule",
					new Version(1, 0, 0, null));
			simpleModule.addSerializer(new ItemSerializer());
			simpleModule.addSerializer(new UserSerializer());
			mapper.registerModule(simpleModule);
			StringWriter writer = new StringWriter();

			mapper.writeValue(writer, myItem);
			
			System.out.println(writer.toString());

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
