#!/usr/bin/env bash

sh createNewDBSchema.sh
sh updateDBScheme.sh
sh checkoutProject.sh
sh buildProject.sh
sh deploy.sh
sh restartTomcat.sh