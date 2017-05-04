FROM frolvlad/alpine-oraclejdk8:slim
ADD debug-*.jar ./app.jar
ADD run.sh ./run.sh
RUN chmod a+x ./run.sh
ENTRYPOINT ["./run.sh"]