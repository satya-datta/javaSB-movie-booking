# Movie Booking System

## Tech Stack
Spring Boot | PostgreSQL | Redis | Docker | AWS EC2 | GitHub Actions

## Architecture Diagram

![Architecture](./assets/architecture.png)

## Features
- Movie management
- Seat booking
- Redis caching for seat locking

## CI/CD Pipeline
- Auto builds on every push to main
- Pushes Docker image to Docker Hub
- Auto deploys to AWS EC2

## API Documentation
MovieController (/api/movies)

GET /api/movies
GET /api/movies/{id}
POST /api/movies
PUT /api/movies/{id}
DELETE /api/movies/{id}
GET /api/movies/search
GET /api/movies/genre
GET /api/movies/language
CityController (/api/cities)

GET /api/cities
GET /api/cities/{id}
POST /api/cities
DELETE /api/cities/{id}
CinemaController (/api/cinemas)

GET /api/cinemas
GET /api/cinemas/city/{cityId}
GET /api/cinemas/{id}
POST /api/cinemas/city/{cityId}
DELETE /api/cinemas/{id}
ScreenController (/api/screens)

GET /api/screens/cinema/{cinemaId}
GET /api/screens/{id}
POST /api/screens/cinema/{cinemaId}
DELETE /api/screens/{id}
ShowtimeController (/api/showtimes)

POST /api/showtimes/movie/{movieId}/screen/{screenId}
GET /api/showtimes
GET /api/showtimes/{id}
DELETE /api/showtimes/{id}

## How to Run Locally
(docker-compose up --build)

## Live URL
http://100.30.239.142:3000

