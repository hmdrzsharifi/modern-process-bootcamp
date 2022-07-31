#!/bin/sh

PID=$(ps -ef | grep "spring-boot-module-2.4.2" | grep -v grep | awk '{print $2}')
if [ "" !=  "$PID" ]; then
    echo "killing $PID"
    kill -9 $PID

    sleep 3
fi