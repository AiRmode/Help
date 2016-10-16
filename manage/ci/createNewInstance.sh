#!/usr/bin/env bash

sh checkoutProject.sh
sh buildProject.sh
sh deploy.sh
sh createNewDBSchema.sh
sh updateDBScheme.sh
sh restartTomcat.sh