FROM gradle:jdk17 as gradleimage
COPY . /home/gradle/source
WORKDIR /home/gradle/source
RUN gradle build

FROM openjdk:17-jdk-slim-buster
COPY --from=gradleimage /home/gradle/source/build/libs/barber-service.jar app.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app.jar ${0} ${@}"]