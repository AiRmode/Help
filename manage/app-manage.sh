#!/usr/bin/env bash

cd ../

git checkout master

mvn clean package install

cd manage