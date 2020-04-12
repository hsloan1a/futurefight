FROM maven:3.6-jdk-14
RUN mkdir -p /api-server
WORKDIR /api-server/
COPY . /api-server/
RUN mvn clean install
