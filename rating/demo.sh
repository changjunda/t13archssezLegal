#!/bin/bash
docker build -t rating .
docker run -p 58082:58082 -t rating