# ─── Stage 1: Build ───────────────────────────────────
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copy pom.xml first (so Maven dependencies are cached)
# If pom.xml didn't change, Docker skips this layer next time
COPY pom.xml .
RUN mvn dependency:go-offline -q

# Now copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests -q

# ─── Stage 2: Run ─────────────────────────────────────
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy only the JAR from build stage (not Maven, not source code)
COPY --from=build /app/target/movie-booking-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 3000

ENTRYPOINT ["java", "-Duser.timezone=Asia/Kolkata", "-jar", "app.jar"]