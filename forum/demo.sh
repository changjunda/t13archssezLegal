#!/bin/bash
mvn install
docker build -t forum .
docker run -p 58083:58083 -t forum
