FROM clojure:temurin-21-lein-2.11.2-bookworm-slim AS build
COPY . /src/
WORKDIR /src
RUN lein do clean, test, check, uberjar

FROM eclipse-temurin:21.0.2_13-jre-jammy
COPY --from=build /src/target/todo-api-0.1.0-SNAPSHOT-standalone.jar /opt/
CMD ["java", "-jar", "/opt/todo-api-0.1.0-SNAPSHOT-standalone.jar"]