FROM maven:3.6-jdk-14
RUN mkdir -p /shadowland-micro-service
WORKDIR /shadowland-micro-service/
COPY . /shadowland-micro-service/
RUN mvn clean install
