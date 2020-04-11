FROM maven:3.6-jdk-14
RUN mkdir -p /naming-server
WORKDIR /naming-server/
COPY . /naming-server/
RUN mvn clean install
