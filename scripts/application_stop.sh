#!/bin/bash
#kill all docker containers
echo "stopping all docker containers"
docker kill $(docker ps -q)