# gameshop

Hello, Before you is a simple spring application simulating the work of an online store.

App setup (only for maven)

    1 Installing MySQL database 
    
        $sudo apt update
        $sudo apt install mysql-server
        $sudo mysql_secure_installation
        
        
    2 Change settings in src/main/resource/sapplication.properties 
        spring.datasource.url=jdbc:mysql://docker_db:3306/{DATABASE_NAME}
        spring.datasource.username={DATABASE_USER}
        spring.datasource.password={DATABASE_PWD}

Options for start app:
    
    # Using maven
    
    1 Start by updating the package index:
    
    $sudo apt update
    
    2 Next, install Maven by typing the following command:
    
    $sudo apt install maven
    
    3 Verify the installation by running the mvn -version command:
    
    $mvn -version
    
    The output should look something like this:
    
    Apache Maven 3.5.2
    Maven home: /usr/share/maven
    Java version: 10.0.2, vendor: Oracle Corporation
    Java home: /usr/lib/jvm/java-11-openjdk-amd64
    Default locale: en_US, platform encoding: ISO-8859-1
    OS name: "linux", version: "4.15.0-36-generic", arch: "amd64", family: "un
    
    from dirrectory with pom.xml run command
    
    $mvn spring-boot:run
    
    
    # Using docker-compose 
    
        1 Install docker engine from official tutorial - https://docs.docker.com/install/linux/docker-ce/ubuntu/
        
        2 From directory with docker-compose.yml file run command 
                
                $ docker-compose up
    
