# Kinesis Test Application

This is a SprinBoot application that demonstrates how to use AWS Kinesis Data Streams to produce and consume data. The application consists of a producer (actually a scheduler, which generates random order) and a consumer component that work together to send and receive data from an AWS Kinesis Data Stream.

## Table of Contents
- [Pre-requisites](#prerequisites)
- [Configuration](#configuration)
- [Details to execute the application](#execution)

<a name="prerequisites"></a>
## Pre-requisites
Before you can use this application, you need to have the following pre-requisites in place:

1. __AWS account:__ You need to have an AWS account with a user, and associated accessKey and secretKeys. Also, the user should have the following permissions:<br>
a. __AmazonDynamoDBFullAccess__<br>
b. __AmazonKinesisFullAccess__<br>


2. Kinesis Data Stream: You need to have a Kinetic Data Stream with name kinesisTest and default configuration in AWS.


3. __Java:__ This project was built using __Oracle OpenJDK version 18__ 


4. __Maven:__ This project was built using __Maven version 3.9.3__


5. __Git:__ This is optional. But, if you have git, you can use the following command to clone the project:

<code> git clone https://github.com/bowofarjun/kinesis.git </code>


<a name="configuration"></a>
## Configuration

Once you have downloaded or cloned the code, go to the kinesis/src/main/resources/application.properties file and configure the following properties:<br>

<code><br>
cloud.aws.credentials.accessKey=&lt;your-access-key&gt;<br>
cloud.aws.credentials.secretKey=&lt;your-secret-key&gt;<br>
cloud.aws.region.static=&lt;aws-region&gt;
</code>

## <a name="execution"></a>Details to execute the application
From the __kinesis__ folder, execute the following commands:<br>
<code><br>
mvn clean package<br>
java -jar target/kinesis-0.0.1-SNAPSHOT.jar
</code>