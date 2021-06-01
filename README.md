<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again! Now go create something AMAZING! :D
***
***
***
*** To avoid retyping too much info. Do a search and replace for the following:
*** github_username, repo_name, twitter_handle, email, project_title, project_description
-->

<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/github_username/repo_name">
    <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFYjQW9Fczjt7gKdxIseJ_YaAbhBHRalm3gA&usqp=CAU" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Rock Paper Scissor</h3>

  <p align="center">
    Simple Java Spring Boot REST Application for Rock Paper Scissor game
    <br />
    <a href="https://github.com/rswijesena/rockpaperscissors/issues">Report Bug</a>
    <a href="https://github.com/rswijesena/rockpaperscissors/issues">Request Feature</a>
  </p>
</p>

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Spring Boot REST application to play Rock Papper Scissor Game. 


### Built With

* Spring Boot
* Java 16
* H2
* Docker



<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these simple steps.

### Prerequisites

* JDK 16*
* Maven
* Docker

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/rswijesena/rockpaperscissors.git
   ```
2. Install MVN packages
   ```sh
   mvn clean install
   ```
3. Docker
   ```sh
   docker pull roshan86web/rockpaperscissor_image
   docker run -p 8787:8080  roshan86web/rockpaperscissor_image
   ```


<!-- USAGE EXAMPLES -->
## Usage

This application currenlty has 3 APIs,
```sh
1. Create a player into the system

HTTP Post request with basic auth

Username apiuser
Password abc123

Post Request Body


http://localhost:8787/player

{
    "name" :"rosha1_wijesena",
    "email":"koora1@gmail.com"
}


Successfull response would give you below response

{
    "id": 1,
    "name": "rosha1_wijesena",
    "email": "koora1@gmail.com"
}

2. Play Rock Paper Scissor

http://localhost:8787/game/play

HTTP Post request protected by basic auth

HTTP Post Request, Here you should pass user id created in the previous step and you can pass your choic for "R" for Rock "P" for Paper or Scissor "S"

{
    "playerId" : 1,
    "playerShape" : "R"
}

Sample Response 

{
    "id": 3,
    "playerId": 1,
    "playerShape": "ROCK",
    "gameResults": "win",
    "computerShape": "SCISSORS"
}

You can see your results of the game with Computer move and your choice.

3. Get game stats

http://localhost:8787/game

HTTP Get request with basic auth protected. With this endpoint you would see your game results.

[
    {
        "id": 1,
        "playerId": 1,
        "playerShape": "ROCK",
        "gameResults": "lose",
        "computerShape": "PAPER"
    },
    {
        "id": 2,
        "playerId": 1,
        "playerShape": "ROCK",
        "gameResults": "lose",
        "computerShape": "PAPER"
    },
    {
        "id": 3,
        "playerId": 1,
        "playerShape": "ROCK",
        "gameResults": "win",
        "computerShape": "SCISSORS"
    },
    {
        "id": 4,
        "playerId": 1,
        "playerShape": "ROCK",
        "gameResults": "draw",
        "computerShape": "ROCK"
    },
    {
        "id": 5,
        "playerId": 1,
        "playerShape": "ROCK",
        "gameResults": "lose",
        "computerShape": "PAPER"
    }
]
```
<!-- ROADMAP -->
## Roadmap

This application can grow by adding more features.

Pending features
1. Get Results for specific user.
2. Etc. etc.



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.





