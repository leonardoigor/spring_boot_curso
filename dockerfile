# FROM ubuntu as pc
# RUN apt-get update
# RUN apt-get upgrade
# # RUN apt install nodejs -y

FROM maven

ENV path=/myapp


COPY ./ ${path}
WORKDIR ${path}



# CMD ["java", "br.com.igor"]
