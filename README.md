# IBM MQ Docker Image for Apple Silicon Chips
## Setup Docker Local Registry
Run docker registry
```shell
docker run -d -p 5001:5000 --restart=always --name registry registry:2.7
```

## Build IBM MQ Docker Image
Pull the code from repository in other directory:
```shell
git clone https://github.com/ibm-messaging/mq-container.git
cd mq-container
make build-devserver
```
The image will be built with image name `ibm-mqadvanced-server-dev` and will be automatically tagged as `9.3.3.0-arm64`.

tag and push the image
```
docker tag ibm-mqadvanced-server-dev:9.3.3.1-arm64 localhost:5001/ibm-mq:latest
docker push localhost:5001/ibm-mq
```

Refer to [this link](https://community.ibm.com/community/user/integration/blogs/richard-coppen/2023/06/30/ibm-mq-9330-container-image-now-available-for-appl)

## Run the Docker compose
Run the [docker-compose.yaml](docker-compose.yaml) file.

## Admin Console
Access to the admin console: [https://localhost:9443/ibmmq/console](https://localhost:9443/ibmmq/console)

Username: `admin`

Password: `passw0rd`
