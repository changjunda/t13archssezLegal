#!/bin/bash
mvn install -f /home/ec2-user/t13archssezLegal/user/pom.xml
docker build -t rating .
docker run -p 58082:58082 -t rating
