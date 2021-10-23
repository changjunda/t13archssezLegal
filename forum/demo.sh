#!/bin/bash
mvn install -f /home/ec2-user/t13archssezLegal/forum/pom.xml
docker build -t forum .
docker run -p 58083:58083 -t forum
