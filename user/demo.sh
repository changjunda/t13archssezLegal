#!/bin/bash
mvn install -f /home/ec2-user/t13archssezLegal/user/demo.sh
docker build -t user .
docker run -p 58080:58080 -t user
