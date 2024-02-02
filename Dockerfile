FROM amazoncorretto:17
RUN mkdir filura-app
WORKDIR /filura-app
EXPOSE 8080
COPY build/libs/*.jar filura-app.jar
ENTRYPOINT ["java", "-jar", "filura-app.jar"]