# Account Rest Project

The project is built using JDK 1.8. The project can be built using Maven build tool. 

The Maven commands are as follows:<br/>
<b>Unit Tests:</b> mvn clean test <br/>
<b>Deployment to Embedded Tomcat Server:</b> mvn clean install tomcat7:run-war<br/>

<b>BASE URL:</b> http://localhost:8080/account/restapi<br/>

<b>GET ALL:</b><br/>
PATH: /account/json/<br/>
Protocol: GET<br/>

<b>GET ONE:</b><br/>
PATH: /account/json/{accountHolderID} <br/>
Protocol: GET<br/>

<b>CREATE:</b><br/>
PATH: /account/json/<br/>
Protocol: POST<br/>
Request Body: 
<pre>{
	"firstName": "John",
	"lastName": "Snow",
	"accountNumber": "12314"
}</pre>

<b>DELETE:</b><br/>
PATH: /account/json/{accountHolderID} <br/>
Protocol: DELETE<br/>
