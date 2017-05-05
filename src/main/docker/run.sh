#!/bin/sh

#Put a default port number, if none.

ARGS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=4000,suspend=n"

if [ "true" = "${JAVA_DEBUG_MODE}" ];
then
   if [ ! -z "${JAVA_DEBUG_PORT}" ];
   then
       ARGS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=${JAVA_DEBUG_PORT},suspend=n"       
   fi
else
   ARGS=""
fi

java -jar ${ARGS} app.jar
