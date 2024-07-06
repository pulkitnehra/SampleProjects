### Quick Start:
##### 1. navigate to /op folder and run the command #2 to register the script in your system and make it executable systemwide.
##### 2. Now type cwcc in your terminal you should see the program running as expected.

###### \nA script run_prog.sh has been provided to make the cwcc.jar file executable as a runnable script. To create a script similar to what is present in the /op/cwcc.sh run the below commands


1. #### command to make the script executable
```bash
cat run_prog.sh cwcc.jar > cwcc && chmod +x cwcc
```
2. #### command to register script in /usr/bin and to run the app in terminal only by its name
```bash
sudo cp cwcc /usr/bin
```

```bash
jar cvfm cwcc.jar manifest.txt *.class
```