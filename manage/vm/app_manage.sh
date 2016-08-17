#!/usr/bin/env bash

cd ../

git checkout .

git checkout master

mvn clean package install

cd manage

chmod -R 777 *