FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/app.jar app.jar
RUN sh -c 'touch /app.jar'
CMD java -jar app.jar --server.port=$PORT