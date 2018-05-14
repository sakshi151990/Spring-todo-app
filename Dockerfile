FROM openjdk:8
WORKDIR /tmp/springtodoapp
COPY Spring-todo-app-0.0.1-SNAPSHOT.jar .
RUN java -version
CMD java -jar Spring-todo-app-0.0.1-SNAPSHOT.jar


