FROM postgres
ENV POSTGRES_USER blogdb
ENV POSTGRES_PASSWORD blogdb
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432