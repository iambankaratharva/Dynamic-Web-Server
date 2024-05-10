# Dynamic Web Server

## Overview

This project is a dynamic web server that extends a previously built static HTTP server. The web server supports dynamic content and routing, allowing for the creation of web applications with functionality inspired by the Spark Java Framework. This server will form the foundation for future enhancements and projects, including a frontend for a search engine.

## Functionality

### Server Configuration

- **port(int portNumber)**: Sets the port for HTTP requests. If not called, the default HTTP port is 80.
- **securePort(int portNumber)**: Sets the port for HTTPS requests. This method should be called before defining any routes. If set, the server listens for HTTPS requests on the specified port and HTTP requests on the port set by `port()`, or 80 if not set.

### Routing

- **get(String path, Route route)**: Defines a route for GET requests. The `path` can include dynamic parameters (e.g., `"/hello/:name"`). The `route` is a functional interface with a method that takes a `Request` and `Response` object and returns a response string.

### Request and Response Objects

- **Request Interface**: Provides methods to access HTTP request data, including parameters, headers, and cookies.
- **Response Interface**: Provides methods to set HTTP response data, including headers and status codes.

### Session Management

- **session()**: Manages user sessions. If a session ID cookie is present in the request, it retrieves the associated session. If not, it creates a new session with a unique ID, associates it with the request, and sets a session ID cookie in the response.
- **Session Expiration**: Each session has a maximum active interval (`tmax`) of 300 seconds by default. Sessions expire after this interval of inactivity, and expired sessions are periodically deleted.

### HTTPS Support

- **TLS Certificate**: The server loads a TLS certificate from a `keystore.jks` file with a default password of "secret" to support HTTPS. The server can handle both HTTP and HTTPS requests simultaneously on different ports.

### AWS Deployment

- **EC2 Instance Deployment**: The server is deployed on an AWS EC2 instance and accessible via a domain name (e.g., `https://<yourname>.cis5550.net/`). A valid TLS certificate from Let’s Encrypt is used for secure connections.
- **Main Page**: The server's main page displays a message: "Hello World - this is `<yourname>`", with the user's full name.
