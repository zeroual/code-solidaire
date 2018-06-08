# Code solidaire
is an application that aims to help people starving around you get free meals. You are welcome to bring your contribution and make the world a better place.
## Getting started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
### Prerequisites
**Maven**

    sudo apt-get install maven

**Java**

    sudo apt-get install java
    
**NodeJs**

    sudo apt-get install nodejs npm    

**Yarn**

    curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
    echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list   
    sudo apt-get update && sudo apt-get install yarn
    
    
### Installing
  #### Frontend
  Run frontend application located in the `frontend/` directory.
  
  Install node module packages:
  ```  
  yarn install
  ```
  
  Launch the application:
  ```  
  yarn start
  ```
  #### Backend
 Run backend application located in the `/backend` directory.
 
     mvn spring-boot:run  
 
 To see endpoints documentation     
	 localhost:8080/swagger-ui.html 
	 
### Running the tests
- how to run fronted tests ? [check here](frontend/README.md)
- how to run backend tests ? [check here](backend/README.md)

## Contributing
To keep this project growing and improving we need all help we can get, feel free to make your comments.
 Two possibilities:
- Issues tracker available on github [here](https://github.com/zeroual/code-solidaire/issues)
- Email available: zeroual.abde@gmail.com

**NOTE: If you’re stuck, can’t get something working or need some help, please head on over and join our [Slack community](https://otchi.slack.com) rather than opening an issue.**

To know more about our flow work please read this Contributing guide

- Step 1 : Set up a working copy on your computer

Firstly you need a local fork of the the project, so go ahead and press the "fork" button in GitHub.
This will create a copy of the repository in your own GitHub account and you'll see a note that it's been forked.

- Step 2 : Do some work

This is the fun bit where you get to contribute to the project. It's usually best to discuss with us and ask us to assign 
to you a user story.

Branch!

The number one rule is to put each piece of work on its own branch.

- Step 3 : Create the PR

To create a PR you need to push your branch to the origin remote and then press some buttons on GitHub (create pull request).

- Step 4 : Review by the maintainers

For your work to be integrated into the project, the maintainers will review your work and either request changes or merge it.

## Deployment
//TODO
## Licence
//TODO
