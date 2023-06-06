## What is business process management (BPM)?

Business process management (BPM) is the practice of modeling, analyzing, and optimizing end-to-end business processes to help meet your strategic business goals, such as the improvement of your customer experience framework. BPM methodology can be applied to tasks and processes that are often repeated, ongoing, or predictable.  

A business process is a set of activities that help a business reach a specific goal. Using BPM, you can evaluate your existing processes to find ways to improve efficiency, reduce costs and errors, and support digital transformation efforts.  

## what is BPMN:  

Business Process Modeling Notation (BPMN), also called Business Process Model and Notation, is an open standard to diagram a business process. It is like a flowchart and uses standardized graphics to represent the participants, choices and flow of the process.

## What is Camunda: 

Camunda is an open-source platform that uses a workflow engine and decision engine to automate business processes. Organizations can use it to automate workflow and decision processes, freeing up time for employees to focus on more thoughtful projects.

## How many ways to distribute camunda setup:

1. Camunda shared process engine distribution with Embeded tomcate
2. Using spring boot

## BPMN Core Elements:

1. Activity
2. Events
3. Getways
4. Sequence flow
5. Message flow
6. Participants(Pool & Lane)
7. Associates
8. Annotation
9. Artifacts
10. Data Object
11. Data Group

## Getway:

a gateway is a graphical element that represents a decision point or branching in a business process. It allows you to define the flow of the process based on certain conditions or criteria.

### Types of Getways:
1. Exclusive gateways
2. Parellel gateways
3. Inclusive gateways
4. Event-based gateways

#### Exclusive Getway:

1. An exclusive gateway (or XOR-gateway) allows you to make a decision based on condition.  
2.If an exclusive gateway has multiple outgoing sequence flows, all sequence flows except one must have a conditionExpression to define when the flow is taken. The gateway can have one sequence flow without conditionExpression, which must be defined as the default flow.  
3. When an exclusive gateway is entered, the conditionExpression is evaluated. The process instance takes the first sequence flow where the condition is fulfilled.  
4. If no condition is fulfilled, it takes the default flow of the gateway. If the gateway has no default flow.  
5. An exclusive gateway can also be used to join multiple incoming flows together and improve the readability of the BPMN
6. A joining gateway doesn't merge the incoming concurrent flows like a parallel gateway.



