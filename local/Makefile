.ONESHELL:

appFile = -f example-compose.yml
noAppFiles = -f postgreSQL-compose.yml
allFiles = $(noAppFiles) $(appFile)
allVolumes = example_example-db-data

start: ## Start the application and dependencies in a local container
	@if [ -z "$$(docker images -q example 2> /dev/null)" ]; then \
		echo "Building example jar...";
		@cd ..
		@gradle clean build -x test
		@cd local
		echo "Building example image...";
		@docker build --build-arg ENVIRONMENT=DEV --no-cache -t 'example' ..
	fi
	@docker compose -p example $(allFiles) up -d --remove-orphans

dev: ## Start dependencies in a local container
	@docker compose -p example $(noAppFiles) up -d --remove-orphans

stop: ## Stop the application in the local container
	@docker compose -p example $(allFiles) stop

clean: ## Stop the application and remove the image
	@docker compose -p example $(allFiles) down --remove-orphans
	@docker rmi -f example:latest

nuke: clean ## Clean and destroy all volumes
	@docker volume rm $(allVolumes)

restart: stop start ## Re-start(Stop & Start) the docker stack