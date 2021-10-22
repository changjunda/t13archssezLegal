#!/bin/bash
mvn install -f /home/ec2-user/t13archssezLegal/tagging/pom.xml
docker build -t tagging .
docker run -p 58081:58081 -t tagging--memory-swap*
