# demo-sns-feign-client
This app used as feign client for my [amazon_services](https://github.com/slavko28/eam/tree/master/amazon_services_demo)

- Get list of available SNS topics HTTP GET:  
  http://localhost:8080/client/topics
- Create new SNS topic HTTP POST(request parameter topicName):
  http://localhost:8080/client/create/topic
- Delete SNS topic HTTP DELETE(request parameter topicArn):
  http://localhost:8080/client/delete/topic



