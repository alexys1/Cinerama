# Etapa 1: Construcción del proyecto usando Maven 3.9.9 con JDK 17
FROM maven:3.9.9-eclipse-temurin-17 AS builder

# Copiar todo el proyecto al contenedor
COPY . /app
WORKDIR /app

# Compilar el proyecto (esto generará el .war en /app/target/)
RUN mvn clean package

# Etapa 2: Imagen base de producción con Tomcat 10 y JDK 17
FROM tomcat:10.1-jdk17

# Limpiar aplicaciones por defecto del Tomcat (ROOT, docs, etc.)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiar el .war compilado desde el paso anterior
COPY --from=builder /app/target/Proyecto_Cine.war /usr/local/tomcat/webapps/ROOT.war



# Exponer el puerto donde escuchará el contenedor
EXPOSE 8080

# Comando de inicio de Tomcat
CMD ["catalina.sh", "run"]
