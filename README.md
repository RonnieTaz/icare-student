# iCare

## Prerequisites

1. [NodeJs (10 or higher)](https://nodejs.org)
2. npm (6.4.0 or higher), can be installed by running `apt install npm`
3. git, can be installed by running `apt install git`

## Setup

Clone repository

```bash
 git clone https://github.com/udsm-dhis2-lab/icare.git
```

Navigate to application root folder

```bash
cd icare/ui
```

Install all required dependencies for the app

```bash
npm install
```

## Development server

Duplicate  proxy-config.example.json and rename the copied file to proxy-config.json

Copy the following and paste it to the file proxy-config.json
```bash
{
  "/": {
    "target":"https://icare.dhis2.udsm.ac.tz",
    "secure": "false",
    "changeOrigin": "true"
  }
}
```
Start the development server 
```bash
npm start
```
Navigate to [http://localhost:4200](http://localhost:4200)

## Build

After making the changes to the backend we build the application so that the omod contains the backend changes by following the steps below:

Navigate to application root folder

```bash
cd omods/core
```
Run the following command to build the application
```bash
mvn clean package -DskipTests
```
Upload the omod to openmrs. 

## Running unit tests

## Running end-to-end tests

## Further help

## For Windows system UI/Angular

Download Docker desktop or Docker Engine from docker if you use linux or Mac OS.

### For CLI use

Navigate to application root folder and then start the compose process:

```bash
USER_ID="$(id -u)" USER_GID="$(id -g)" docker compose -f docker-compose.dev.yaml up -d
```

That is all

### For Windows / Docker Desktop use

Open docker desktop and make sure it is running in the tray.

Open your project in a cmd or powershell terminal. Git bash can also be used. This can be done by typing cmd in the address bar within your project directory or right-clicking on an empty space and selecting *git bash here*

Once in your terminal of your choice, type the following and hit enter:

```bash
docker compose -f docker-compose.dev.yaml up -d
```
