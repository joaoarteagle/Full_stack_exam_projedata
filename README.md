##BACK-END:

- Open the project in the IDE
- Open Docker Desktop
- In teminal run `mvn package` to build the .jar
- In terminal of project run: `docker build -t aplicacao-projedata . ` to build the image
- After run `docker images` and copy the ID of the repository "aplicacao-projedata" 
- Run `docker run -p PORT:PORT ID:IMAGEAPLICATION`

  
