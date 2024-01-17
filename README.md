# EngineSamy
---
Automation framework done by Mahmoud Samy

---
Engine properties
---
---
---

**Page object model**
- Engine layer is totally separated from business layer
- Engine folders can be simply reused into new project
- NOT using page Base/test Base, instead running flow using many wrapper methods and classes [all called in series, ending at one single line called in test suites]
- This allowed a clean running flow and structured running selections with many ZERO arguments java methods

---

**Running**
- Mainly running through MVN commands
- Controlling different configurations through xmlFiles config files VS POM profiles
- Detecting these parameters is NOT using @parameters, instead created Java package to deal with all xml attributes, tags

---
**Listeners**

- Event listeners
- I-Execution listeners / I-Test listeners
- Test adapter listeners

---

**Allure**

- Automated Allure CMD commands runs after build finish using a CMD runner class triggered with listeners
- Automated cleaners to clean allure-result folder before build start, triggered by listeners

---

**Loggers**

- Three different loggers for [Engine, javaUtils, business] each logger has its own line color
- each logger is viewing [time - line number – class name]
- logger classes is also separate classes, wrapped into the Engine, NOT used natively into the engine classes

 
---


**Parallel execution [local]**

- Through one parameter key in config. file, it detects a json file
- This json file is used to map all available suites or tests VS browsers & platforms, with help of javaUtils package deals with all json nodes types
- This allowing ease of customizing what suite or test to run on which browsers / platforms [platforms only if using selenium grid].
- Multiple json files can be created and detected into one config key named [Parallel module]
- Multiple parallel levels can be easily selected with one config key [suite/test/class] (class level postponed due to thread handling issues-working on it)

---



**Parallel execution [Sel. grid]**

- Same logic of parallel local is used
- Automated CMDs to start selenium gird hubs and nodes, triggered by listeners
- Nodes are generated using TOML files
- Automated CMD commands to write these TOML files .. detecting the map from previously created json file [suite or test VS browser & platform]
- Automated CMD commands to delete these TOML files, after selenium grid nodes is created
- All these commands are handled with aid of threads handling

  
---


**Rest Assured**

- Separate "deserializer class", returns generic "POJO class object" to be used according to need
- POJO class is structured to be reused in both API and GUI tests
- Generic API request classes, wrapped into another separate business layer class which named according to business need
- These 3 points allowed fully separated engine layer


---


**Browser Stack**

- Can be decided with one config key, which is mapped into separate POM profile
- Ability to automatically create Trello card for issues


---



**Docker**

- A Docker-Compose file to run with aid of [selenium stand-alone and grid] docker images
- Using docker volumes to help checking Allure reports
- Pushed my project image to docker hub, and managed to run in into Browser Stack
- [future plan], to Automate doing all previous steps with one config key parameter

---


**Jenkins**

- [for company use only], I have managed to do "port forwarding" on my local machine, to make the Jenkins windows service
reachable to any one in my team, allowing the team to check for allure reports, and run tests if needed
- Created pipeline using scripted Jenkins file and parametrized run
- Running is triggered by both [pollScm] and normal schedule
- [future plan] with aid of port forwarding done, my local host is not detectable and I can make the run triggered by webhook
with a [commit] or [push] on test branch


---



**GitHub CI Actions**

- Created a YML file to enable GitHub CI triggered by pushing or pull requests on the "test" branch
- [future plan] to fix the issue of allure report exported files not working …
