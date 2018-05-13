FROM openjdk:8
WORKDIR /tmp/springtodoapp
COPY /target/Spring-todo-app-0.0.1-SNAPSHOT.jar /tmp/springtodoapp
CMD [ "java -jar Spring-todo-app-0.0.1-SNAPSHOT.jar" ]