FROM openjdk:17
EXPOSE 8080
ADD ./target/spring-0.0.1-SNAPSHOT.jar spring-react.jar
ENTRYPOINT ["java","-jar","spring-react.jar"]

CMD java -cp target com.richards.spring.SpringReactApplication

