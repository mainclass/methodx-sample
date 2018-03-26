FROM openjdk:8-jdk-alpine

ARG APP_DIR

COPY ${APP_DIR} /app
WORKDIR /app
RUN chmod +x bin/start.sh
ENTRYPOINT ["sh", "bin/start.sh"]
