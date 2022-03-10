## Machine Learning curve fitting compilation instructions
```
On CLI (recommended to do this on jade directory):

javac -cp [directory for jade.jar] [agent source directory]/[agent].java -d classes/

java -cp [directory for jade.jar];classes jade.Boot -gui [agentName]:[agent package]
```

Example
```
javac -cp lib/jade.jar src/proyects/curvefitting/AgentBasedCurveFitting.java -d classes/

java -cp lib/jade.jar;classes jade.Boot -gui agentName:proyects.curvefitting.AgentBasedCurveFitting

```
