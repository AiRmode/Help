#!/usr/bin/env bash

sh checkoutProject.sh
sh buildProject.sh
sh deploy.sh
sh restartTomcat.sh