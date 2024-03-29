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

#### Parallel Getway:

1. A parallel gateway (or AND-gateway) allows you to split the flow into concurrent paths.
2. When a parallel gateway with multiple outgoing sequence flows is entered, all flows are taken. The paths are executed concurrently and independently.
3. The concurrent paths can be joined using a parallel gateway with multiple incoming sequence flows. The process instance waits at the parallel gateway until each incoming sequence is taken.

#### Inclusive Getway:
   
    Note : Currently, Camunda Platform 8 only supports the diverging (i.e. splitting, forking) inclusive gateway. It does not yet support the converging (i.e. merging, joining) inclusive gateway. A combination of parallel and exclusive gateways can be used as an alternative way to merge the flows.
    
1. If an inclusive gateway has multiple outgoing sequence flows, all sequence flows must have a condition to define when the flow is taken. If the inclusive gateway only has one outgoing sequence flow, then it does not need to have a condition.
2. Optionally, one of the sequence flows can be marked as the default flow. This sequence flow should not have a condition, because its behavior depends on the other conditions.
3. When an inclusive gateway is entered, the conditions are evaluated. The process instance takes all sequence flows where the condition is fulfilled.    
4. If no condition is fulfilled, it takes the default flow of the gateway. Note that the default flow is not expected to have a condition, and is therefore not evaluated. If no condition is fulfilled and the gateway has no default flow, an incident is created.

### Event-based gateway:

1. An event-based gateway allows you to make a decision based on events.
2. An event-based gateway must have at least two outgoing sequence flows. Each sequence flow must to be connected to an intermediate catch event of type timer or message.
3. When an event-based gateway is entered, the process instance waits at the gateway until one of the events is triggered. When the first event is triggered, the outgoing sequence flow of this event is taken. No other events of the gateway can be triggered afterward.

## Sub-process

1. A subprocess in Camunda allows modeling based on reusability and grouping.
2. A subprocess is an activity that contains other activities, gateways, events, etc., which itself forms a process that is part of a bigger process.

### Types of Sub-process:

1. Embedded Subprocess
2. Call activities
3. Event subprocess

#### Embedded Subprocess:

1. A subprocess is completely defined inside a parent process (that’s why it’s often called an embedded Subprocess).
2. An embedded subprocess allows you to group elements of the process.
3. An embedded subprocess must have exactly one none start event. Other start events are not allowed.
4. When an embedded subprocess is entered, the start event is activated. The subprocess stays active as long as one containing element is active. When the last element is completed, the subprocess is completed and the outgoing sequence flow is taken.
5. Embedded subprocesses are often used together with boundary events. One or more boundary events can be attached to a subprocess. When an interrupting boundary event is triggered, the entire subprocess (including all active elements) is terminated.

#### Call activities:

1. A call activity (or reusable subprocess) allows you to call and invoke another process as part of this process. It's similar to an embedded subprocess, but the process is externalized (i.e. stored as separated BPMN) and can be invoked by different processes.
2. When a call activity is entered, a new process instance of the referenced process is created. The new process instance is activated at the none start event. The process can have start events of other types, but they are ignored.
3. When the created process instance is completed, the call activity is left and the outgoing sequence flow is taken.

#### Event subprocess:

1. An event subprocess is a subprocess triggered by an event. This can be added globally to the process, or locally inside an embedded subprocess.
2. An event subprocess must have exactly one start event of one of the following types:

* Timer
* Message
* Error

3. An event subprocess behaves like a boundary event, but is inside the scope instead of attached to the scope. Like a boundary event, the event subprocess can be interrupting or non-interrupting (indicated in BPMN by a solid or dashed border of the start event). The start event of the event subprocess can be triggered when its containing scope is activated.

4. A non-interrupting event subprocess can be triggered multiple times. An interrupting event subprocess can be triggered only once.


## Differences between camunda 7 and Camunda 8:

1. Camunda 7 based on activity engin & Camunda 8 based on zeebe engin which is self developed and zeebe scalable horizontally and linearly because of elastic search based back-end intead of dbms

2. Camunda 7 has shared engin, embeded engin, remote engine where as Camunda 8 has only remote engine.

3. Task processing in camunda 8 is asynchronous whereas in camunda 7 it can be synchronus.

4. Camunda 7 uses REST API to talk to the engine whereas in camunda 8 uses GRPC protocol based getway to talk to the engine.

5. camunda 7 engine wokrs on pushing whereas camunda 8 engine wokrs on polling.

7. camunda 7 does not offering software as a service (SAAS), where as camunda 8 offering SAAS.

# Zeebe :

Zeebe is the process automation engine powering Camunda Platform 8.

## With Zeebe you can:

1. Define processes graphically in BPMN 2.0.
2. Choose any gRPC-supported programming language to implement your workers.
3. Use as part of a software as a service (SaaS) offering with Camunda Platform 8 or deploy with Docker and Kubernetes (in the cloud or on-premises) with Camunda Platform 8 Self-Managed.
4. Scale horizontally to handle very high throughput.
5. Export processes data for monitoring and analysis (currently only available through the Elasticsearch exporter added in Camunda Platform 8 Self-Managed).

There are four main components in Zeebe's architecture: clients, gateways, brokers, and exporters.

![zeebe image](https://docs.camunda.io/assets/images/zeebe-architecture-409312dc13312932224304aad8815be0.png)

### Clients :

Clients send commands to Zeebe to:

1. Deploy processes
2. Carry out business logic

         Start process instances
         Publish messages
         Activate jobs
         Complete jobs
         Fail jobs
3. Handle operational issues
          
        Update process instance variables
        Resolve incidents
        
Client applications can be scaled up and down separately from Zeebe. The Zeebe brokers do not execute any business logic.  

Clients libraries are you embed in an application (e.g. a microservice that executes your business logic) to connect to a Zeebe cluster.  

Clients connect to the Zeebe gateway via gRPC, which uses HTTP/2-based transport.  

### Gateways:

A gateway serves as a single entry point to a Zeebe cluster and forwards requests to brokers.  

The gateway is stateless and sessionless, and gateways can be added as necessary for load balancing and high availability.  


### Brokers:

The Zeebe broker is the distributed workflow engine that tracks the state of active process instances.  

Brokers can be partitioned for horizontal scalability and replicated for fault tolerance. A Zeebe deployment often consists of more than one broker.  

It's important to note that no application business logic lives in the broker. Its only responsibilities are:  

      Processing commands sent by clients
      Storing and managing the state of active process instances
      Assigning jobs to job workers
      
      
### Exporters:

The exporter system provides an event stream of state changes within Zeebe. This data has many potential uses, including but not limited to:  

      Monitoring the current state of running process instances
      Analysis of historic process data for auditing, business intelligence, etc.
      Tracking incidents created by Zeebe
      
The exporter includes an API you can use to stream data into a storage system of your choice. Zeebe includes an out-of-the-box Elasticsearch exporter, and other community-contributed exporters are also available.      


# Camunda componants & Architecture:

![camunda ar](https://docs.camunda.io/assets/images/ComponentsAndArchitecture_SaaS-edd9396b71911e6e4df0e16fa905e869.png)


