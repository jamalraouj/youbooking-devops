# Use the LTS version of Node.js as the base image
FROM node:lts-alpine

RUN npm install -g @angular/cli@14
# Set the working directory in the container
WORKDIR /app

# Copy the package.json and package-lock.json files
COPY package*.json .

# Install the dependencies
RUN npm install

# Copy the rest of the application files
COPY . .


# Build the application
RUN ng build

# Expose the port that the application will run on
# EXPOSE 4200

RUN npm install -g serve

# Start the application
CMD ["serve", "/app/dist/client"]













#FROM node:latest  as node
#WORKDIR /app
#COPY . .
#RUN npm install
#RUN npm run build --prod
#
#FROM nginx:alpine
#COPY --from=node /app/dist/youbooking /usr/share/nginx/html

#FROM node:alpine as node
#RUN mkdir -p /app
#WORKDIR /app
#COPY  package.json /app/
#RUN npm install
#COPY . .
#RUN npm run build --prod
#FROM nginx:alpine
#COPY --from=node /app/dist/youbooking /usr/share/nginx/html


# Use an official Node.js image as the base image
#FROM node:18-alpine
#
## Set the working directory
#WORKDIR /app
#
## Copy package.json and package-lock.json
#COPY package*.json ./
#
## Install dependencies
#RUN npm install
#
## Copy the rest of the application code
#COPY . .
#
## Build the application
#RUN npm run build
#
## Copy the dist folder to the container
#COPY ./dist /app/dist
#
## Expose the port the app will run on
#EXPOSE 4200
#
## Start the app
#CMD ["npm", "start"]


# Use an official Node.js runtime as the base image
#FROM node:18
#
## Set the working directory in the container
#WORKDIR /usr/src/app
#
## Copy the package.json and package-lock.json files to the container
#COPY package*.json ./
#
## Install the application's dependencies
#RUN npm ci
#
## Copy the rest of the application's files to the container
#COPY . .
#
## Build the Angular application
#RUN npm run build
#
## Expose the application's port
#EXPOSE 4200
#
## Start the application
#CMD ["npm", "start"]



#dist/youbooking

#RUN mkdir -p /app
#WORKDIR /app
#COPY package.json /app/
#RUN npm install
#COPY . /app/

    # && rm -rf node_modules/


#WORKDIR /app
#RUN npm install && npm run build:prod && rm -rf node_modules/

#EXPOSE 80



#FROM node:10.16.3-alpine as node
#
#WORKDIR /opt/
#COPY package.json .
#RUN npm install
#COPY . .
#RUN ./node_modules/@angular/cli/bin/ng build
#
#FROM nginx
#RUN rm /usr/share/nginx/html/*
#COPY --from=node /opt/dist/. /usr/share/nginx/html/
