# Example  Local

## How to Run Locally

### Overall Info

Running locally involves running the project with all its dependencies in Docker, so you can just test the thing out or
develop with the infrastructure more easily.

Once you run, a Postgres DB will be created and pre-populated with some basic info for testing and whatnot.

Some example data you should know:

Default Master User Id:

    cb183e77-8b9a-4cfa-91d3-4e72f2b9ced4

Default Master Organization Id:

    5a77d0f5-7a82-463f-ab72-bab8abef7db2

### Technologies
- Java 21
- Docker
- Docker Compose
- GNU Make

>If it is your first time running Docker you may need to run the following command to create the local docker network all your containers will be using

    docker network create docker-network

### Commands

All the commands listed below must be executed inside the `local` directory.

Build & Run all the containers:

    make start

Run all containers except for the application:

    make dev

Stop the stack

    make stop

Restart the stack (stop and then start)

    make restart

Update the application container to include new code changes

    make clean start

For a hard reset

    make clean start

For a nuclear option (delete all volumes and images, this will clear the DB)

    make nuke

Show help information

    make help


