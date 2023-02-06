#!/bin/bash
echo "Killing application"
kill -9 $(lsof -t -i:8081)
echo "Killing application done"
java -jar build/libs/AddressAPI.jar
echo "Run application done"
