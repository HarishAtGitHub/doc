package harish.ws;
 
import javax.jws.WebService;
 
@WebService(endpointInterface = "harish.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
 
	@Override
	public String sayHelloTo(String name) {
		return "Hello " + name;
	}
 
}
