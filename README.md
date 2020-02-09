# springboot-allinone

#Deployment steps for Cloud Foundry
Create an account on https://pivotal.io/

Create an Org Name

Create Spring boot project

build the project mvn clean install

create mainfest.yml file and add the required configuration 

cf push  -->Note : Make sure your manifest.yml is in same directory


Test URLs:

http://localhost:9090/sayHello/Pranab
http://localhost:9090/sayHi?name=Pranab