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
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String content = new String(Files.readAllBytes(Paths.get("C://sav4//external-property//src//main//resources//local.properties")));
		Map<String,Object> map = mapper.readValue(content, Map.class);
        return map;
    }

}
