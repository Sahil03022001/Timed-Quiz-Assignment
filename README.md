# Timed-Quiz-Assignment
Timed-Quiz Assignment on tech stack - Java, Springboot, Hibernate/JPA, MySQL.


A timed quiz system has been developed. The project allows clients to create new quizzes and interact with them using APIs.
The quizzes and their associated questions are stored in a MySQL database.

The project utilizes cron jobs, which run every minute, to actively monitor the start and end times of each quiz. 
This ensures that the status of a quiz (active or inactive) is updated in real-time.

The project provides several GET APIs, including:

"Get Active Quizzes": Retrieves a list of quizzes that are currently active.
"Get All Quizzes": Retrieves a list of all quizzes, regardless of their status.
"Get Quiz Result": Retrieves the result of a specific quiz.
Overall, the project enables clients to create quizzes, add questions to quizzes, monitor quiz activity in real-time, 
and retrieve quiz-related information using various APIs.
