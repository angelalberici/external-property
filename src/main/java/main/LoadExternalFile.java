package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

import org.codehaus.jackson.map.ObjectMapper;
import org.mule.api.MuleEventContext;
import org.mule.api.lifecycle.Callable;

import com.github.fge.jsonschema.library.Library;


public class LoadExternalFile implements Callable{
	String body;
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		System.out.println(eventContext.getMessage().getPayload().toString());
		eventContext.getMessage().setInvocationProperty("myProperty", "Hello World!");
        eventContext.getMessage().getPayload().toString();
        System.out.println("-------------------------X123------------------------");
		String fileName = "C://sav4//external-property//src//main//resources//local.properties";

		String content = new String(Files.readAllBytes(Paths.get("C://sav4//external-property//src//main//resources//local.properties")));
		body = content;
        
		ObjectMapper mapper = new ObjectMapper();
		Map<String,Object> map = mapper.readValue(content, Map.class);
		
        return map;
        
    }
	
	public static void main(String args[]) {

		String fileName = "C://sav4//cry//src//main//resources//local.properties";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
