package harish.endpoint;
 
import javax.xml.ws.Endpoint;
import harish.ws.HelloWorldImpl;
 
public class HelloWorldPublisher{
 
	public static void main(String[] args) {
	   Endpoint.publish("http://localhost:9123/greet/hello", new HelloWorldImpl());
    }
 
}
