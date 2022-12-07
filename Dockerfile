FROM openjdk:8
WORKDIR /usr/local/app
ADD build/libs/rest-client-service-0.0.1-SNAPSHOT-plain.jar rest-client-service.jar
CMD java -jar ./rest-client-service.jar