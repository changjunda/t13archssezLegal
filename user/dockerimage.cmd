::mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker
::docker build -t springio/gs-spring-boot-docker .
docker build -t user .
docker run -p 58080:58080 -t user