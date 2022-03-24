# JadeAgents

Repository for IA2 Problem Solving works

Como ejecutar jade.

En el directorio de jade:
```
javac -cp lib/jade.jar src/examples/behaviours/SimpleAgent.java -d classes/

java -cp lib/jade.jar;classes jade.Boot -gui simpleAgent:examples.behaviours.SimpleAgent
```

## Machine Learning curve fitting compilation instructions
```
On CLI (recommended to do this on jade directory):

javac -cp [directory for jade.jar] [agent source directory]/[agent or *].java -d classes/

java -cp [directory for jade.jar];classes jade.Boot -gui [agentName]:[agent package]

For multiple java files/classes
javac -cp [directory for jade.jar] [agent source directory]/*.java -d classes/
```
