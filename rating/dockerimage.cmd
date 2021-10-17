::mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker
::docker build -t springio/gs-spring-boot-docker .
docker build -t rating .
docker run -p 58082:58082 -t rating