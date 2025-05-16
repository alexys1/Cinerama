# Etapa 1: compilar el proyecto con Maven
FROM maven:3.9.4-eclipse-temurin-17 as builder

# Copiamos el código fuente al contenedor
COPY . /app
WORKDIR /app

# Compilamos el proyecto
RUN mvn clean package

# Etapa 2: imagen de producción con Tomcat
FROM tomcat:10.1-jdk17

# Limpiamos las apps por defecto
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiamos el .war generado desde el contenedor anterior
COPY --from=builder /app/target/Proyecto_Cine.war /usr/local/tomcat/webapps/Proyecto_Cine.war

# Exponemos el puerto
EXPOSE 8080

# Comando por defecto para ejecutar Tomcat
CMD ["catalina.sh", "run"]
