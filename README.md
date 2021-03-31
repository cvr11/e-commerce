# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Quick summary
* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)
### How do I get set up? ###
* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions
### Contribution guidelines ###
* Writing tests
* Code review
* Other guidelines
### Who do I talk to? ###
* Repo owner or admin
* Other community or team contact
###Maven Command	Description
	mvn --version	Prints out the version of Maven you are running.
	mvn clean	Clears the target directory into which Maven normally builds your project.
	mvn package	Builds the project and packages the resulting JAR file into the target directory.
	mvn package -Dmaven.test.skip=true	Builds the project and packages the resulting JAR file into the target directory - without running the unit tests during the build.
	mvn clean package	Clears the target directory and Builds the project and packages the resulting JAR file into the target directory.
	mvn clean package -Dmaven.test.skip=true	Clears the target directory and builds the project and packages the resulting JAR file into the target directory - without running the unit tests during the build.
	mvn verify	Runs all integration tests found in the project.
	mvn clean verify	Cleans the target directory, and runs all integration tests found in the project.
	mvn install	Builds the project described by your Maven POM file and installs the resulting artifact (JAR) into your local Maven repository
	mvn install -Dmaven.test.skip=true	Builds the project described by your Maven POM file without running unit tests, and installs the resulting artifact (JAR) into your local Maven repository
	mvn clean install	Clears the target directory and builds the project described by your Maven POM file and installs the resulting artifact (JAR) into your local Maven repository
	mvn clean install -Dmaven.test.skip=true	Clears the target directory and builds the project described by your Maven POM file without running unit tests, and installs the resulting artifact (JAR) into your local Maven repository
	mvn dependency:tree	Prints out the dependency tree for your project - based on the dependencies configured in the pom.xml file.
	mvn dependency:tree -Dverbose	Prints out the dependency tree for your project - based on the dependencies configured in the pom.xml file. Includes repeated, transitive dependencies.
	mvn dependency:tree -Dincludes=com.fasterxml.jackson.core	Prints out the dependencies from your project which depend on the com.fasterxml.jackson.core artifact.
	mvn dependency:tree -Dverbose -Dincludes=com.fasterxml.jackson.core	Prints out the dependencies from your project which depend on the com.fasterxml.jackson.core artifact. Includes repeated, transitive dependencies.
	mvn dependency:build-classpath	Prints out the classpath needed to run your project (application) based on the dependencies configured in the pom.xml file.
	
### Docker Commands 
Docker Commands:
1. Docker images 
2. docker container ls => List the active containers
3. docker container ls -a => List active containers with status 
3. docker logs -f <firt 4 degits of image OR container-name> => to view the running logs
4. docker container stop <container-name> => Stops the container ---> example "docker container logs user-mysql"
5. docker container rm <container-name> => Remove the stopped container
Commnads to build Image in docker: 
1. docker build -f Dockerfile -t docker-spring-boot . => Creates a image, . represents the right directry path
2. docker images -> it will shows all created images 
3. docker run -p 8085:8085 docker-spring-boot -> this is used for run the application inside the container and push the application
4. docker run -p 8085:8085 -d  docker-spring-boot - > runs in ditached mode (-d)
5. docker logs <first 4 ditigs of fitached mode image id>
6. docker container stop <first 4 ditigs of image id>
7. docker restart my_container

1. docker build -f Dockerfile -t docker-spring-boot .
2. docker run -p 8085:8085 docker-spring-boot => this is used for run the application inside the container and push the application, (8085(localhost):8085(containerhost)) 
3. docker run -d -p 8085:8085 --name docker-spring-boot --link localhost:mysql docker-spring-boot => its connect the mysql connection on container, (connection=localhost, project shanpshot= docker-spring-boot)
4. docker run -d -p 8080:8080 --name docker-orders --link localhost:mysql docker-orders
5. docker restart my_container

Commands to provision MySql in docker container and useage:
1. docker pull mysql => Provising the latest version of MySql 
2. docker run --name localhost -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=OMDB -e MYSQL_USER=root -e MYSQL_PASSWORD=root -d mysql ==> its runs the MySql on Docker container name as localhost with database=OMDB, username=root, password=root 
3. docker container logs localhost - it shows logs 
4. docker events
5. 

### Spring Security 
1. once you added the OAuth 2 maven depen, Spring boot will config the OAuth Security with basic authentication (default User name : user, passward: it will generate once you ran the application like Using generated security password: 6ac817b6-5c35-49d3-aefc-8bfe5f3101ae
2. on Spring configuration page by eabling websecurity we can protect the http requests and create Users, and User Roles 
3. In this craeted user1, Admin1 and Created custom passward for both

### Kafka 
#1. Kafka Commands
1. to start zookeeper on windows => .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
2. To start Apache Kafka on windows => .\bin\windows\kafka-server-start.bat .\config\server.properties
3. Create Topic => .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic TestTopic
4. Show list of Topics => .\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181
5. Produce sample data in localhost => .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic TestTopic
6. Consume Data in localhost topic => .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic TestTopic --from-beginning
#2. Commads to create a kafka topic on docker image with docker-compose file 
## Docker Commands:
1. docker --version
2. docker-compose --version
3. docker-compose up
4. docker-compose -f docker-compose.yml up -d : (it runs in background mode)
5. docker-compose down : it will stop the all containers 
6. docker ps => shows the running images 
7. docker exec -it kafka /bin/sh => it used to go inside the kafka image 
	1. # ls => shows all root folders
	2. cd /opt/ => it used to enter into opt folder
	3. /opt # ls => shows available folders in htis root directory
	4. /opt # cd kafka => go into kafka folder 
	5. /opt/kafka # ./bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic OrdersTopic => this command is used to create a topic in docker image 
	6. /opt/kafka #./bin/kafka-topics.sh --list --zookeeper zookeeper:2181


### AWS Process
1. EC2 Instance 
	1. It need to a provisiona instance with ubuntu/windows - and install all softwares for develop and run the application to available 
	2. to connect the Ubuntu instance, need to create pem file when you hosting the instance 
		i) to connect this aws ubuntu instance host, need PuTTY and PuTTYGen
		ii) PuTTY - connects the ubuntu instance
		iii) PuTTYGen - using this create ppk file from pem file ( it converts the pem to ppk secrect key file )
	3. To connecct the AWS windows instance - need to download the RDP (Remote Desktop on AWS instance)
		i) once the windows instance active - generate the password by using the pem file which is generated when creating the windows instance on AWS
2. AWS Elastic BeanStack 
	1. It is use to host the WEB application - by selecting the platform, upload an application and ran it 
	2. Its not required to install OS or softwares like EC2
	3. select platform 
3. AWS Lambda 
	1. It use to test the code, it gives the results in json formate, Text formate view results
	2. It will not the application 
	3. you get the code and it will run the code and gives you the output 
4. AWS S3 
	1. S3 is an object based storage - stores in an object formate 
	2. Its a file storage system in AWS 
	3. Its mostly available 99.99% (high availability)
	4. if we create a folder (buckets) in S3, using glacier service we can backup the files 
	5. EFS:Elastic File System 
		1. AWS Elastic File System - mount to EC2 instance, move data, share file data
		2. Ensure all Instance should be assign/acce to the EFS Security group
		3. It will mount the data through the multiple instance (ex: instance 1&2 have smae directoryfolder and both access the security groups, 
			then if you create text1 file in any one instance the other instance also have that file)
	6. AWS Storage Gatewyas - it help to connect the on promiss It env to aws storage infrastracture 	
5. AWS RDS : Relational Database services 
	1. its uses to set up RDBMS databses (oracle, mysql, postgre, mariaDB etc...)
	2. AWS Dynamo DB - NoSql Database by Amazon
	3. AWS RedShift - it stores all data in S3 Buckets
	4. AWS Elastic Cache - which serves the cache, layer b/w the client and web server. it reduces the similar request queries and increass the perforamence 
	
6. AWS IAM : Identity and Access Management 
	1. IAS is used to autenticate the AWS servers and resources securly 
	2. Root account have all permissions 
	3. useing this create different AWS users with limited permissions (for development, up/down instances etc)
7. AWS cloudFormation 
	1. based on Json/YML file, once run in cloud formation, its auto config and create the whole archithecture accoring to my json file. 
	2. it can run in multiple instances 
8. AWS cloud watch 
	1. we can setup an alarms 
	2. collecct logs and metric data and analyzing the metrics
	3. monitor applications in use 
9. AWS SES: simple email service 
	1. used to send bulk emails, notifications, recipt mails - this is for customer engaging service 
10. AWS SQS : Simple Queue Service 
	1. its a simple queue service using producer in one part and consumer on other part 
	
