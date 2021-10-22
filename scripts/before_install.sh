#!/bin/bash
sudo su
sudo yum -y update
dockerd > /dev/null 2> /dev/null < /dev/null &
#create our working directory if it doesnt exist
DIR="/home/ec2-user/t13archssezLegal"
if [ -d "$DIR" ]; then echo "${DIR} exists"
else echo "Creating ${DIR} directory";
mkdir ${DIR}
fi
