#!/bin/bash
echo "Killing application"
kill -9 $(lsof -t -i:8081)
echo "Killing application done"
./gradlew run
echo "Run application done"
