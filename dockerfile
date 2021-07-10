FROM maven
ENV path=/myapp
COPY ./ ${path}

WORKDIR ${path}


# CMD ["java", "br.com.igor"]
