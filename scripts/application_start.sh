#!/bin/bash
sudo su
cd /home/ec2-user/t13archssezLegal/user/
sudo bash demo.sh > /dev/null 2> /dev/null < /dev/null &
cd /home/ec2-user/t13archssezLegal/tagging/
sudo bash demo.sh > /dev/null 2> /dev/null < /dev/null &
cd /home/ec2-user/t13archssezLegal/rating/
sudo bash demo.sh > /dev/null 2> /dev/null < /dev/null &
cd /home/ec2-user/t13archssezLegal/forum/
sudo bash demo.sh > /dev/null 2> /dev/null < /dev/null &
