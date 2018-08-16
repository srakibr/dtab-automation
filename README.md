# dtab-automation

Write your tests under /src/test/java/tests

After updating the code run :

`` mvn clean package -DskipTests=true ``

This will package everything and will create a "zip-with-dependencies.zip" file under target directory. 
Which we will need to upload in our amazon device farm to run our automation tests.
