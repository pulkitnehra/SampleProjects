###### A script run_prog.sh has been provided to make the cwcc.jar file executable as a runnable script. To create a script similar to what is present in the /op/cwcc.sh run the below commands


1. #### command to make the script executable. Navigate to /Java folder and run the below command in terminal
```bash
cat run_prog.sh cwcc.jar > cwcc && chmod +x cwcc
```
2. #### command to register script in /usr/bin and to run the app in terminal only by its name
```bash
sudo cp cwcc /usr/bin
```
3. #### Now type in cwcc in your terminal and execute the commands using -l, -w, -m parameters on the test.txt file provided. For program execution output see the images in /output folder.


#### command to create JAR executable file in java
```bash
jar cvfm cwcc.jar manifest.txt *.class
```