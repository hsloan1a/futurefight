FROM node:lts-slim
RUN mkdir -p /client
WORKDIR /client/
COPY ./src /client/src
COPY ./public /client/public
COPY ./package.json /client/package.json
RUN npm install
CMD ["npm", "start"]
