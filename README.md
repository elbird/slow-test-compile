# slow-test-compile
Reproducer for https://stackoverflow.com/questions/70151545/compiling-java-unit-tests-very-slow

Build with 
```
./mvnw clean package -DskipTests -Dprofile
```

Check the output of the profiler in `.profile` folder to see that "test-compile" takes much longer than "compile"

run build in docker (powershell):
```
docker run -it -v ${home}\.m2:/root/.m2 -v ${pwd}:/usr/src/mymaven -w /usr/src/mymaven maven:3.8.4-jdk-11 mvn clean package -DskipTests -Dprofile
```
