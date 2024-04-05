# Usar la imagen de OpenJDK  como base
FROM openjdk:21

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /usr/src/app

# al directorio de trabajo en el contenedor
COPY target/cassandra-0.0.1-SNAPSHOT.jar /usr/src/app/aplication.jar

# Establecer una variable de entorno para el punto de contacto de Cassandra
ENV CASSANDRA_CONTACT_POINTS=localhost

# Especificar el comando para ejecutar tu aplicación, incluyendo la variable de entorno
CMD ["java", "-jar", "/usr/src/app/application.jar", "--spring.data.cassandra.contact-points=${CASSANDRA_CONTACT_POINTS}"]