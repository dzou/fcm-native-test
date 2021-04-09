FROM ghcr.io/graalvm/graalvm-ce:java11-21.0.0.2

ADD . /build
WORKDIR /build

RUN gu install native-image;
RUN native-image --version

RUN ./mvnw -Pnative clean package

FROM oraclelinux:8-slim

COPY --from=0 "/build/target/fcmnativetest" app

CMD [ "sh", "-c", "./app" ]