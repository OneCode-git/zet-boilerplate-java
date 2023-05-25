FROM --platform=$BUILDPLATFORM alpine:3.8 as downloader
RUN apk update && \
    apk add unzip && \
    apk add curl && \
    curl --location https://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic-java.zip  > newrelic-java.zip && \
    unzip -q newrelic-java.zip
    

FROM --platform=$BUILDPLATFORM  arm64v8/amazoncorretto:11
WORKDIR /app
COPY --from=downloader newrelic/newrelic.jar /var/
COPY target/integration-service-0.0.1-SNAPSHOT/integration-service-0.0.1-SNAPSHOT.jar /app
COPY mvnw /app
ENV PATH="${PATH}:/app"
EXPOSE 8080

ENTRYPOINT ["java","-javaagent:/var/newrelic.jar", "-jar","/app/integration-service-0.0.1-SNAPSHOT.jar"]
# ENTRYPOINT ["java", "-jar","/app/integration-service-0.0.1-SNAPSHOT.jar"]

CMD ["./app/mvnw","spring-boot:run"]
