# slow-test-compile
Reproducer for https://stackoverflow.com/posts/7015154

Build with 
```
./mvnw clean package -DskipTests -Dprofile
```

Check the output of the profiler in `.profile` folder to see that "test-compile" takes much longer than "compile"

run build in docker (powershell):
```
docker run -it -v ${home}\.m2:/root/.m2 -v ${pwd}:/usr/src/mymaven -w /usr/src/mymaven maven:3.8.4-jdk-11 mvn clean package -DskipTests -Dprofile
```
