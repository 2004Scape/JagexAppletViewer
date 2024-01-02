This applet viewer is meant to be paired with a launcher program that handles starting Java with no user interaction or prior setup required.  
The jar can be used directly if the necessary arguments are passed, say you wanted to make a Linux desktop shortcut.

## Example

JVM args:
```
-Djava.class.path=jagexappletviewer.jar
-Dcom.jagex.config=http://master.2004scape.org/jav_config.ws
-Xmx128m
-Xss2m
jagexappletviewer
```

Passing the above to a Java runtime should work the same as a launcher.
