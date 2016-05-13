FROM ubuntu:latest
MAINTAINER Qiao Zhang <qiz121@ucsd.edu>

RUN apt-get update
RUN apt-get install -y default-jre
RUN apt-get install -y default-jdk
RUN apt-get install -y make
RUN apt-get install -y vim

RUN mkdir /data
RUN cd data
RUN mkdir build
RUN mkdir conformance
RUN mkdir rmi
RUN mkdir test
RUN mkdir unit

COPY ./lab1/build/* /data/build/
COPY ./lab1/conformance/*.java /data/conformance/
COPY ./lab1/conformance/rmi/*.java /data/conformance/rmi/
COPY ./lab1/rmi/*.java /data/rmi/
COPY ./lab1/test/*.java /data/test/
COPY ./lab1/unit/*.java /data/unit/
COPY ./lab1/unit/rmi/*.java /data/unit/rmi/

COPY ./lab1/PingPong.java /data/
COPY ./lab1/PingPongImpl.java /data/
COPY ./lab1/PingPongClient.java /data/
COPY ./lab1/PingPongServer.java /data/
COPY ./lab1/Makefile /data/
COPY ./lab1/*.sh /data/

WORKDIR /data