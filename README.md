 <p align="center"><img width="385" alt="Screenshot 2024-02-23 at 11 39 39 AM" src="https://github.com/rakhyun-kim/Todo/assets/128246360/4c34ba2a-6a43-4d5d-93f8-ad18a0115f36"></p>

This repository contains a simple Java-based command-line program to manage a to-do list. 
The application can load tasks from a CSV file, display the tasks, add new tasks, delete existing tasks, and change the status of tasks. 
Here are some of its features:

1. **File Reading and Writing**:
   The program reads tasks from a CSV file named "checklist.csv" at startup.
   Each line in the file represents a task, with the task description and its status (done or not done) separated by a comma.
   When the program ends, it writes all current tasks back to the "checklist.csv" file.

2. **Task Management**:
   The user can add new tasks, delete existing tasks, and change the status of tasks.
   The status of a task is represented by a boolean value, where 'true' means the task is done and 'false' means the task is not done.

3. **User Interaction**:
   The program interacts with the user through the command line.
   It prompts the user to enter commands to manage tasks.
   The user can enter a task description to add a new task,
   'D' or 'Delete' to delete a task, 'C' or 'Change' to change the status of a task, 'F' or 'Finished' to view finished tasks,
   'O' or 'Ongoing' to view ongoing tasks, and 'Q' or 'Quit' to quit the program.

This program showcases the usage of basic Java features such as file I/O, exception handling, and collection manipulation. 
It can be a good starting point for beginners who want to learn Java programming and build a simple but functional application.
