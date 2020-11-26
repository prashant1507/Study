# Each line create different layer (container)
# You can also write RUN in one line to reduce number of layers
# FROM - base image
# LABEL - to give some labels
# ENV - environment variable
# RUN - to run commands
# USER - to change user
# COPY - to copy to docker image
# ADD - to copy content from tar or link to image 
# CMD - to run command as soon as container starts
# EXPOSE - to expose port
# ENTRYPOINT - To run command on container starts

FROM ubuntu
#LABEL name="ubuntu"
#LABEL name="version 1"
#ENV NAME prashant
#ENV PASS test
USER root
RUN apt-get update
#RUN apt-get install -y tree &&\
#    apt-get install -y vim
#RUN echo "hello" > /tmp/hello.txt && touch /tmp/test.txt
#RUN cd /tmp
#RUN echo "I am a new image"
#RUN echo ${NAME}  ${PASS}
#RUN apt-get install -y openssh-server && apt-get install -y python
#RUN whoami
#RUN mkdir /tmp/folder1
#COPY ./commands.yml /tmp/folder1
#ADD ./file.zip /tmp/folder1
#CMD ["ifconfig"]i
#EXPOSE 22 80
#ENTRYPOINT [ "tree" ]