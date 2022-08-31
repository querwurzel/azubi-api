FROM eclipse-temurin:17-jre

WORKDIR /root/

COPY ./target/*.war .
COPY ./target/dependency/webapp-runner.jar .

EXPOSE $PORT

ENTRYPOINT ["java", "-jar", "webapp-runner.jar", "--port", "${PORT}", "*.war"]
