## Machine Learning curve fitting compilation instructions
```
On CLI (recommended to do this on jade directory):

javac -cp [directory for jade.jar] [agent source directory]/[agent].java -d classes/

java -cp [directory for jade.jar];classes jade.Boot -gui [agentName]:[agent package]
```

Example
```
javac -cp [directory for jade.jar eg lib/jade.jar] src/proyets/behaviours/SimpleAgent.java -d classes/
java -cp [directory for jade.jar eg lib/jade.jar];classes jade.Boot -gui agentName:examples.behaviours.SimpleAgent

```
