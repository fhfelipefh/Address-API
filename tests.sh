#!/bin/bash
chmod +x ./gradlew
echo "Running tests..."
./gradlew test
echo "Tests finished"