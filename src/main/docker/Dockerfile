FROM frolvlad/alpine-oraclejdk8:slim
ADD debug-*.jar /app.jar
ADD run.sh /run.sh
RUN ["chmod","+x","/run.sh"]
RUN ["chmod","+x","/app.jar"]
ENTRYPOINT ["/run.sh"]
