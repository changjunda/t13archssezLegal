#!/bin/bash
#create our working directory if it doesn't exist
DIR="/home/ec2-user/t13archssezLegal"
if [ -d "$DIR" ]; then
  echo "${DIR} exists"
else
  echo "Creating ${DIR} directory"
  mkdir ${DIR}
fi
