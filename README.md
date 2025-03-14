# Fin-Track

![tests](https://github.com/kwnna15/fin-track/actions/workflows/maven.yml/badge.svg)

Financial tracker integrating with TrueLayer.

## Table of Contents
 - [Get Started](#get-started)
 - [Documentation](#documentation)

## Get Started

1. Create a developer account at https://truelayer.com/:
    1. Create a sandbox app.
    2. Configure callback url matching the one in the project: `http://localhost:8080/api/v1/callback`.
2. Setup your .env file:
    1. Use the .env.template file as a blueprint to configure the secrets on TrueLayer.
2. Make sure docker is up and running:
    1. Start docker depdendencies with `make start`
3. Verify with `mvn clean install`.
4. Success! Happy coding 🚀

## Documentation

[Authorization](https://swimlanes.io/#fZBNT4NAEIbv+yveIyVBkN4aPxKjbYyNPUjjoeGwwrRMWHaTZaHir3dB00ZjvM4878eMY6dogVdShWkIzqA9cqOkpvaCjRBi25JFdIMl6yizsqgX2K0eshyx7FwVK3Ng/U1dRT+oeZJiudk+3+fIbEdrOXhmFBnLH9Kx0egsI2ANVxEqkiXZ2TnxJPJeheKizrEe0yB1efIh9CwnvfcS4hz0Z+VCKvXmB7eFKen6Mp0LcYJ+R6ZJgs1T/g8xea7ITWX862rSCLK7R3+D0Mb5t74QIQx3+04ptIN28h2mJ9szHfMgPvg2ZId4XEdf61kYYm8sGmMJJTnJqv0E)

[Kafka flow](https://app.mural.co/t/home65128/m/home65128/1741538690908/7459d1d6a22a5014438f207ae78463cbf8d5e5b0?sender=u3b827cd6e607a1579eb57870)