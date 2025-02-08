# ChallengeApp

## Overview
ChallengeApp is a simple Spring Boot REST API that manages monthly challenges. It allows users to create, retrieve, update, and delete challenges.

## Features
- Retrieve all challenges
- Retrieve a challenge by month
- Add a new challenge
- Update an existing challenge
- Delete a challenge

## Technologies Used
- Java
- Spring Boot
- Spring REST
- Maven

## Installation & Setup
1. Clone the repository:
   ```sh
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```sh
   cd ChallengeApp
   ```
3. Build and run the project:
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
### Get All Challenges
- **GET** `/Challenges`
- **Response:** List of all challenges

### Get Challenge by Month
- **GET** `/Challenges/{month}`
- **Response:** Challenge details for the given month

### Add a New Challenge
- **POST** `/Challenges`
- **Body:** JSON object with `month` and `description`
- **Response:** Success or failure message

### Update a Challenge
- **PUT** `/Challenges/{id}`
- **Body:** JSON object with updated `month` and `description`
- **Response:** Success or failure message

### Delete a Challenge
- **DELETE** `/Challenges/{id}`
- **Response:** Success or failure message

## Example JSON Request Body
```json
{
  "month": "February",
  "description": "Complete a 30-day coding challenge."
}
```

## Contributing
Feel free to submit pull requests for enhancements and bug fixes!
