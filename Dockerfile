# Usamos una imagen oficial de Tomcat con JDK 17
FROM tomcat:10.1-jdk17

# Limpiamos las apps por defecto de Tomcat (como ROOT, docs, etc.)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copiamos el archivo WAR generado por Maven al directorio webapps
# Render ejecutará "mvn clean package", así que el WAR estará en target/
COPY target/Proyecto_Cine.war /usr/local/tomcat/webapps/Proyecto_Cine.war

# Expone el puerto por donde Tomcat escuchará (Render usará este)
EXPOSE 8080

# Comando por defecto para iniciar Tomcat
CMD ["catalina.sh", "run"]
