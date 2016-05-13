#!/bin/bash
# Author: Qiao Zhang

#mkdir mybuild
#cd mybuild
#touch Dockerfile
#open -e Dockerfile

docker build -t zq/pingpong .
docker run --name=ori -v /data zq/pingpong
docker run -dt -P --name=server --volumes-from ori zq/pingpong sh serverScript.sh
#to view and modify the IP address of server
docker inspect server
docker run -t -P --name=client --link=server --volumes-from ori zq/pingpong sh clientScript.sh
docker logs client