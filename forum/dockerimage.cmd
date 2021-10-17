::mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker
::docker build -t springio/gs-spring-boot-docker .
docker build -t forum .
docker run -p 58083:58083 -t forum