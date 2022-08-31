FROM eclipse-temurin:17-jdk

RUN mkdir -p /tmp/project/

WORKDIR /tmp/project/

COPY . /tmp/project/

RUN /tmp/project/mvnw clean package

FROM eclipse-temurin:17-jre

WORKDIR /root/

COPY --from=0 /tmp/project/target/*.war .
COPY --from=0 /tmp/project/target/dependency/webapp-runner.jar .

EXPOSE $PORT

ENTRYPOINT java -jar webapp-runner.jar --port $PORT azubi-api.war
