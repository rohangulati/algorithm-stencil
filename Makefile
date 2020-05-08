MVN?=mvn  # Configurable path to mvn binary

.PHONY: build clean help test test-unit-only

.DEFAULT_GOAL := help

build: ## Java build
	$(MVN) -B package

build-no-checks: ## Build JAR without code checks and tests
	$(MVN) -B package -Dcheckstyle.skip -DskipTests

compile-no-checks: ## Compile java code without code checks
	$(MVN) -B compile -Dcheckstyle.skip

clean: ## Clean build artifacts
	$(MVN) clean

deploy:
	${MVN} deploy

install: ## Clean build artifacts
	$(MVN) install

test:
	$(MVN) -B test

help:
	@grep -E '^[a-zA-Z_%-]+:.*?## .*$$' $(MAKEFILE_LIST) | sort | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
