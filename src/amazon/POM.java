package amazon;

public class POM {



    <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.qaautomationlab</groupId>
    <artifactId>WebAutomationFramework_Team4</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
    <modules>
        <module>Generic</module>
        <module>Ebay</module>
        <module>FoxNews</module>
        <module>BankOfAmerica</module>
        <module>StateFarm</module>
    </modules>

    <properties>
        <maven.compiler.source>1.11</maven.compiler.source>
        <maven.compiler.target>1.11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

    </properties>

    <dependencyManagement>

        <dependencies>
            <!--    Browser WebDriver Manager-->
            <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
            <dependency>
                <groupId>io.github.bonigarcia</groupId>
                <artifactId>webdrivermanager</artifactId>
                <version>4.3.1</version>
            </dependency>

            <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-java</artifactId>
                <version>3.141.59</version>
            </dependency>

            <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-server -->
            <dependency>
                <groupId>org.seleniumhq.selenium</groupId>
                <artifactId>selenium-server</artifactId>
                <version>3.141.59</version>
            </dependency>

            <!-- https://mvnrepository.com/artifact/org.testng/testng -->
            <dependency>
                <groupId>org.testng</groupId>
                <artifactId>testng</artifactId>
                <version>7.1.0</version>
                <!--            <scope>test</scope>-->
            </dependency>

            <!--            Others Related Dependencies-->
            <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
            <dependency>
                <groupId>org.apache.poi</groupId>
                <artifactId>poi</artifactId>
                <version>4.1.2</version>
            </dependency>
            <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
            <dependency>
                <groupId>org.apache.poi</groupId>
                <artifactId>poi-ooxml</artifactId>
                <version>4.1.2</version>
            </dependency>

            <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-schemas -->
            <dependency>
                <groupId>org.apache.poi</groupId>
                <artifactId>poi-ooxml-schemas</artifactId>
                <version>4.1.2</version>
            </dependency>

            <!--            Database connection-->
            <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>8.0.22</version>
            </dependency>
            <!-- https://mvnrepository.com/artifact/org.mongodb/mongo-java-driver -->
            <dependency>
                <groupId>org.mongodb</groupId>
                <artifactId>mongo-java-driver</artifactId>
                <version>3.12.7</version>
            </dependency>

            <!--            Extent Reports for Reporting purpose-->
            <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
            <dependency>
                <groupId>com.aventstack</groupId>
                <artifactId>extentreports</artifactId>
                <version>5.0.6</version>
            </dependency>
            <!-- https://mvnrepository.com/artifact/com.relevantcodes/extentreports -->
            <dependency>
                <groupId>com.relevantcodes</groupId>
                <artifactId>extentreports</artifactId>
                <version>2.41.2</version>
            </dependency>
            <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
            <dependency>
                <groupId>org.apache.commons</groupId>
                <artifactId>commons-lang3</artifactId>
                <version>3.12.0</version>
            </dependency>

            <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
            <dependency>
                <groupId>commons-io</groupId>
                <artifactId>commons-io</artifactId>
                <version>2.8.0</version>
            </dependency>

        </dependencies>

    </dependencyManagement>


    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.11</source>
                    <target>1.11</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <!-- TestNG http Error Handle purpose -->
                    <systemPropertyVariables>
                        <testng.dtd.http>true</testng.dtd.http>
                    </systemPropertyVariables>
                    <!-- Test Fail will be Ignored -->
                    <testFailureIgnore>true</testFailureIgnore>
                    <!--Test Runner Files-->
                    <suiteXmlFiles>
                        <suiteXmlFile>target/test-classes/EbayTestRunner.xml</suiteXmlFile>
<!--                        <suiteXmlFile>target/test-classes/FoxNewsTestRunner.xml</suiteXmlFile>-->
<!--                        <suiteXmlFile>target/test-classes/StateFarmTestRunner.xml</suiteXmlFile>-->

                    </suiteXmlFiles>


                </configuration>
            </plugin>

        </plugins>
    </build>


</project>
}
