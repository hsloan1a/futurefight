FROM maven:3.6-jdk-14
RUN mkdir -p /characters
WORKDIR /characters/
COPY . /characters/
RUN mvn clean install
