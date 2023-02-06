#!/bin/bash
chmod +x ./gradlew
./gradlew test && \
./gradlew ujar
