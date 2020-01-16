#EAM

Steps to launch
1. Prepare .jar files in each service `mvn pakage`
2. Put your AWS credentials into docker-compose.yml  
here `aws_access_key` and here `aws_secret_key`
3. Build image  
`docker-compose build`
4. Run
`docker-compose up`