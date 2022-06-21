FROM postgres:13.3
EXPOSE 5432
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=12345
ENV POSTGRES_DB=postgres
COPY init.sh /docker-entrypoint-initdb.d/
COPY data.backup .