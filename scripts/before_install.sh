#!/bin/bash
sudo yum -y update
sudo dockerd
#create our working directory if it doesnt exist
DIR="/home/ec2-user/t13archssezLegal"
if [ -d "$DIR" ]; then
  echo "${DIR} exists"
else
  echo "Creating ${DIR} directory"
  mkdir ${DIR}
fi
