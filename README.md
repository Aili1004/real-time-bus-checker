# Real-time Bus Time Checker written in JAVA and JSP

### This web-app allows users to check bus time by entering their origin, destination and direction. Users can also track the exact position of the bus by clicking it from the list.

#### Since we were not able to track the real position of the bus, it is just a simulator bus. The name of the bus stops are collected from one of the cities in China. 

----------------------------------------------

## Code

### Back end is written in JAVA which is in *src* folder.
- dao: add, update and delete functionalities.
- entity: setters and getters.
- ita: file uploader.
- manager: GET and POST requests. It gets the user input and sends to server; tells it which JSP file to talk to and redirect to which page.

### Front end is written in JSP which is in *WebContent* folder.

----------------------------------------------

## Main Functionalities
- Managers are able to add, update and delete buses, bus stops and advertisement.
- When users enter their origin, destination and direction, different bus routes will be listed in the order of arrival time. 
- When the arrival time of the bus has passed, it disappears from the list.
- When users click on one of the buses, it shows where the bus is at the moment and the bus is moving through the route.


