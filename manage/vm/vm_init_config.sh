#!/usr/bin/env bash

#create user
adduser user
#grant user sudo
sudo usermod -a -G sudo user

#install docker
wget -qO- https://get.docker.com/ | sh

#install python pip
sudo apt-get -y install python-pip

#updating locale
export LC_ALL=C

#install docker-compose
sudo pip install docker-compose

#install mc
sudo apt-get install mc

#add user to docker group
sudo usermod -aG docker user

#swith to user
su - user

#manage apt-get
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update

#install java
sudo apt-get install oracle-java8-installer

#install maven
sudo apt-get install maven

#install git
sudo apt-get install git

#create postgres
git clone https://github.com/docker-library/postgres
cd postgres
cd 9.5
docker build -t postgres95test .
docker run -d --name mypostgres -e POSTGRES_PASSWORD=postpassword -p 5432:5432 postgres95test