echo ### Criando o Alias para o LocalStack...
alias awslocal="AWS_ACCESS_KEY_ID=fake AWS_SECRET_ACCESS_KEY=fake AWS_DEFAULT_REGION=us-east-1 aws --endpoint-url=http://localhost:4566"

echo ### Criando Chaves no AWS Parameter Store do LocalStack...
aws --endpoint http://localhost:4566 --profile dev ssm put-parameter --name "/config/my-demo-boot_dev/helloworld" --value "Hello World Parameter Store" --type String





echo ### Criando Queue(Standard) no SQS do LocalStack...
aws --endpoint http://localhost:4566 sqs create-queue --queue-name sqsHelloWorld