#!/usr/bin/env bash

ps -ef | grep tomcat | awk '{print $2}' | xargs kill -9
cd $CATALINA_HOME/bin
./startup.sh