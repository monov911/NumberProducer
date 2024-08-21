# Number producer
An app send up to 5 numbers per second (up to a total of 100) through HTTP request and write the sent ones in a CSV file
The app starts sending as soon as it is started
# How to run
## Prerequisites
#### -Docker installed  [Docker download](https://www.docker.com/)
#### All the prerequisites from Prime Number Identifier app are met and it is launched successfully through Docker
##### Follow steps mentioned in [Prime Number Identifier README](https://github.com/monov911/primeNumberIdentifier)
## Steps
Run the following commands as ordered in the CMD of the root folder of this project

`docker build -f Dockerfile -t number_producer .`

`docker run  --network host number_producer`

