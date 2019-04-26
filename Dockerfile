FROM openjdk:8
WORKDIR /app
ARG APPWORKSPACE
ENV WORKSPACE=$APPWORKSPACE
COPY ./target/Spring-todo-app-0.0.1-SNAPSHOT.jar /app
RUN java -version
CMD java -jar /app/Spring-todo-app-0.0.1-SNAPSHOT.jar


