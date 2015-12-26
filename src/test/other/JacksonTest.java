package test.other;
import java.net.URLEncoder;

public class JacksonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URLEncoderTest();
	}

	public static void URLEncoderTest(){

		try{
			
			String encodedStr = URLEncoder.encode("<h1>h</h1>", "UTF-8");
			System.out.println(encodedStr);
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
