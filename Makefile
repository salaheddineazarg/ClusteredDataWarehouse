run:
	docker compose up
run-detatched:
	docker compose up -d
down:
	docker compose down
test:
	mvn test
clean:
	mvn clean install

