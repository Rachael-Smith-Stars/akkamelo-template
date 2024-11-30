This is the Gatling test suite for the Akkamelo API. It was taken from the Rinha de backend contest, so everything is in portuguese.
I plan on refactoring this to english, but it is not a priority right now. 
It should run, since the external contracts of the API are tailored for this suite.

## Running the tests
If you want, you can add the following profile to the pom: 

```xml
<profile>
    <id>gatling-suite</id>
    <build>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.4.1</version>
                <executions>
                    <execution>
                        <id>run</id>
                        <phase>test</phase>
                        <goals>
                            <goal>java</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <mainClass>com.akkamelo.api.gatling.GatlingRunner</mainClass>
                    <classpathScope>test</classpathScope>
                </configuration>
            </plugin>
        </plugins>
    </build>
</profile>
```

After that, you can run the test suite with the following command:
```bash
mvn test -Pgatling-suite
```
This will run the tests and generate a report in the `target/gatling` directory.

You can also run from your IDE if you wish, running the `GatlingRunner` class, or find another way entirely to run this.
