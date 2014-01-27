To publish a webservice :


Get into webservicehosting/src and do 

javac harish/ws/HelloWorld.java harish/ws/HelloWorldImpl.java harish/endpoint/HelloWorldPublisher.java

java -cp . harish.endpoint.HelloWorldPublisher

Now access http://localhost:9123/greet/hello

and to see wsdl http://localhost:9123/greet/hello?wsdl 


To consume a webservice :

Get into webserviceclient and do 

javac -cp . HelloWorldClient.java

java -cp . HelloWorldClient 



