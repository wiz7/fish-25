FROM openjdk:17-oracle

ARG ACTIVE_PROFILE
ARG INTERNAL_PORT

ENV ACTIVE_PROFILE ${ACTIVE_PROFILE}
ENV INTERNAL_PORT ${INTERNAL_PORT}


ENV TZ Asia/Seoul
RUN locale-gen ko_KR.UTF-8
ENV LANG ko_KR.UTF-8
ENV LANGUAGE ko_KR.UTF-8
ENV LC_ALL ko_KR.UTF-8

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir /opt/app

COPY fish25.jar /opt/app/fish25.jar

CMD ["java", \
"-verbose:gc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+UseGCLogFileRotation -XX:GCLogFileSize=50m -XX:NumberOfGCLogFiles=5 -Xloggc:/home/gc/fish25-gc.log", \
"-jar", \
"-Dspring.profiles.active=${ACTIVE_PROFILE}", \
"-Dserver.port=${INTERNAL_PORT}", \
"/opt/app/fish25.jar"]