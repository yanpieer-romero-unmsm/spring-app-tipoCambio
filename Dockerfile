FROM openjdk:11
COPY "./target/spring-app-tipoCambio-1.0.0.jar" "spring-app-tipoCambio.jar"
EXPOSE 8090
ENTRYPOINT ["java","-jar","spring-app-tipoCambio.jar"]