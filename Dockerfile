FROM openjdk:8
COPY target/Spring-todo-app-0.0.1-SNAPSHOT.jar /tmp/springtodoapp
WORKDIR /tmp/springtodoapp
CMD [ "java -jar Spring-todo-app-0.0.1-SNAPSHOT.jar" ]
