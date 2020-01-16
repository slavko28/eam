**EAM**

Steps to launch
1. Prepare .jar files in each repo  
	`mvn pakage`
2. Set your AWS credentials into docker-compose.yml 
	here `aws_access_key` and here `aws_secret_key`
4. Build image  
`docker-compose build`
5. Run 
`docker-compose up`
