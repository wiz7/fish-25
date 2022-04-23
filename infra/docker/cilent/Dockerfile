FROM node:16

ARG APP_PATH
ENV HOST 0.0.0.0

# 시간 설정
ENV TZ Asia/Seoul
RUN locale-gen ko_KR.UTF-8
ENV LANG ko_KR.UTF-8
ENV LANGUAGE ko_KR.UTF-8
ENV LC_ALL ko_KR.UTF-8
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 파일 설정
RUN mkdir /src
RUN mkdir /app_log
WORKDIR /src
COPY ${APP_PATH} ./

RUN yarn add next
RUN yarn run build

CMD ["yarn" , "run", "dev"]