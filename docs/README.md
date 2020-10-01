# User Guide

## Introduction

Duke is an application that is designed to help users to keep track of different types of tasks (i.e. todos, deadlines, events).

## Quick start

1. Ensure you have Java 11 or above installed in your computer.
1. Download the latest CS2113_IP.jar from [here](https://github.com/Cao-Zeyu/ip/releases/tag/A-Release).
1. Copy the file to the folder you want to use as the howe folder for your Duke.
1. Double-click the file to start the app.

## Features
#### Providing help information: `help`
* Displays all the valid input commands for the user to understand how to use Duke.
* Format: `help`
* Example of expected output:
```
___________________________________________
	Here are some available commands and their corresponding input format: 

	Listing all the tasks: `list` 
	Format: `list`

	Adding a todo task: `todo` 
	Format: `todo TASK`

	Adding a deadline task: `deadline` 
	Format: `deadline TASK /by BYTIME`

	Adding an event task: `event` 
	Format: `event TASK /by ATTIME`

	Marking a task as done: `done` 
	Format: `done INDEX`

	Deleting a task: `delete` 
	Format: `delete INDEX`

	Finding a task: `find` 
	Format: `find KEYWORD`

	Exiting Duke: `bye` 
	Format: `bye`
	___________________________________________
```

#### Listing all the tasks: `list`
* Displays the list of all recorded tasks.
* Format: `list`
* Example of expected output:
```
	___________________________________________
	Here are the tasks in your list: 
	1. [T][✘] read a book
	2. [D][✘] return the book (by: 10 Oct)
	3. [E][✘] group meeting (at: 11am Thursday)
	___________________________________________
```

#### Adding a todo task: `todo`
* Adds a todo task which has no time limit to finish.
* Format: `todo TASK`
* Example: `todo read a book`
* Example of expected output:
```
	___________________________________________
	Got it. I've added this task: 
	   [T][✘] read a book
	Now you have 1 tasks in the list. 
	___________________________________________
```

#### Adding a deadline task: `deadline`
* Adds a deadline task which has to be done by a certain time.
* Format：`deadline TASK /by YYYY-MM-DD HOUR:MINUTE`
* Example: `ddeadline submit report /by 2020-10-03 14:59`
* Example of expected output:
```
	___________________________________________
	Got it. I've added this task: 
	   [D][✘] submit report (by: Oct 03 2020 14:59)
	Now you have 1 tasks in the list. 
	___________________________________________
```

#### Adding an event task: `event`
* Adds an event task which will happen at a certain time.
* Format：`event TASK /by YYYY-MM-DD HOUR:MINUTE`
* Example: `event project meeting /at 2020-10-06 11:00`
* Example of expected output:
```
	___________________________________________
	Got it. I've added this task: 
	   [E][✘] project meeting (at: Oct 06 2020 11:00)
	Now you have 2 tasks in the list. 
	___________________________________________
```

#### Marking a task as done: `done`
* Marks a certain task indicated by the user as done.
* Format: `done INDEX`
* Example: `done 1`
* Example of expected output:
```
	___________________________________________
	Nice! I've marked this task as done: 
	   [T][✓] read a book
	___________________________________________
```

#### Deleting a task: `delete`
* Deletes a certain task indicated by the user.
* Format: `delete INDEX`
* Example: `delete 4`
* Example of expected output:
```
	___________________________________________
	Noted. I've removed this task: 
	   [T][✘] take a walk
	Now you have 3 tasks in the list.
	___________________________________________
```

#### Finding a task: `find`
* Finds the tasks that contains the certain keyword given by the user.
* Format: `find KEYWORD`
* Example: `find book`
* Example of expected output:
```
	___________________________________________
	Here are the matching tasks in your list: 
	1. [T][✓] read a book
	2. [D][✘] return the book (by: 10 Oct)
	___________________________________________
```

#### Exiting Duke: `bye`
* Exits Duke.
* Format: `bye`
* Example of expected output:
```
	___________________________________________
	Bye. Hope to see you again soon!
	___________________________________________
```