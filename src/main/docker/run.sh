#!/bin/sh

#Put a default port number, if none.

ARGS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=4000,suspend=${JAVA_DEBUG_SUSPEND}"

if [ "true" = "${JAVA_DEBUG_MODE}" ];
then
   if [ ! -z "${JAVA_DEBUG_PORT}" ];
   then
       ARGS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=${JAVA_DEBUG_PORT},suspend=${JAVA_DEBUG_SUSPEND}"       
   fi
else
   ARGS=""
fi

java -jar -Dorg.springframework.boot.logging.LoggingSystem=none ${ARGS} app.jar
