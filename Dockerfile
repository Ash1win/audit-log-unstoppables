FROM openjdk
RUN mkdir -p /opt/auditlog
COPY ./target/audit-log-unstoppables-0.0.1-SNAPSHOT.jar /opt/auditlog/auditlog.jar
WORKDIR /opt/auditlog
EXPOSE 8081
CMD ["java", "-jar", "auditlog.jar"]
