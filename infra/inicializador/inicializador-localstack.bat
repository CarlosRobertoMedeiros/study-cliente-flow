echo ### Criando o Alias para o LocalStack...
alias awslocal="AWS_ACCESS_KEY_ID=fake AWS_SECRET_ACCESS_KEY=fake AWS_DEFAULT_REGION=us-east-1 aws --endpoint-url=http://localhost:4566"

echo ### Criando Chaves no AWS Parameter Store do LocalStack...
aws --endpoint http://localhost:4566 --profile dev ssm put-parameter --name "/config/my-demo-boot_dev/helloworld" --value "Hello World Parameter Store" --type String


echo ### Criando SQS no LocalStack...
aws --endpoint http://localhost:4566 --profile dev sqs create-queue --queue-name sqs-consulta-cliente
aws --endpoint http://localhost:4566 --profile dev sqs create-queue --queue-name sqs-retorno-consulta-cliente
aws --endpoint http://localhost:4566 --profile dev sqs create-queue --queue-name sqs-inclusao-cliente-assync
aws --endpoint http://localhost:4566 --profile dev sqs create-queue --queue-name sqs-reenvio-consulta-cliente


echo ### Criando um Topico SNS no LocalStack...
aws --endpoint-url=http://localhost:4566 --profile dev sns create-topic --name sns-disponibiliza-dados-aplicacao-cliente 

# Cria uma assinatura para o Topico
aws --endpoint-url=http://localhost:4566 --profile dev sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:sns-disponibiliza-dados-aplicacao-cliente --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:FILA_DYNAMO 

#Criacao da tabela do DynamoDB
# Cria uma tabela no dynamodb com nome TabelaMensagens
aws --endpoint-url=http://localhost:4566 --profile dev dynamodb create-table --table-name dynamo-cliente-db --attribute-definitions AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 

echo ### Banco de Dados Rds a Criar


