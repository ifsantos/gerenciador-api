FROM adoptopenjdk/openjdk11:latest

MAINTAINER ifsantos <github@ifsantos.io>

ADD target/gerenciador-api-0.0.1-SNAPSHOT.jar /opt/gerenciador-api-0.0.1-SNAPSHOT.jar

EXPOSE 8080

CMD java -Xms256M -Xmx512M -Duser.timezone=America/Sao_Paulo -jar /opt/gerenciador-api-0.0.1-SNAPSHOT.jar
