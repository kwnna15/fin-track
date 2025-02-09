.PHONY: run-dependencies
run-dependencies:
	docker compose -f docker/docker-compose.yml up -d

.PHONY: stop-dependencies
stop-dependencies:
	docker compose -f docker/docker-compose.yml down