#!/bin/bash

JAVA_OPT="$JAVA_OPT -Dspring.config.location=./config/application.properties"
java  $JAVA_OPT -jar spring-boot-module-2.4.2.jar