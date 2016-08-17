#!/usr/bin/env bash

sudo apt-get update
sudo apt-get install fail2ban

sudo cp /etc/fail2ban/jail.conf /etc/fail2ban/jail.local

sudo nano /etc/fail2ban/jail.local

#bantime = 3600
#findtime = 600
#maxretry = 3