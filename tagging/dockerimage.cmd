::mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=springio/gs-spring-boot-docker
::docker build -t springio/gs-spring-boot-docker .
docker build -t tagging .
docker run -p 58081:58081 -t tagging