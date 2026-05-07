# Problem 7.x Web Services (NetBeans 8 + JDK 8)

This folder contains **ready-to-open NetBeans 8 Maven projects** for Distributed Systems Problem 7.x:

- **7.1** Simple Calculator web service + consumer
- **7.2** Simple Interest web service + consumer
- **7.3** Hello (takes user name) web service + consumer
- **7.4 / 7.5** Miles to Kilometres web service + consumer (same problem repeated)

Implementation uses **JAX-RS (Jersey 2.x)** with an **embedded Grizzly HTTP server**, so you do **not** need GlassFish.

## Projects

- `DS7_Producer` (REST producer)
  - Base URL: `http://localhost:5000/`
  - Endpoints:
    - `GET /calc?a=10&b=4&op=add`
    - `GET /si?p=1000&r=5&t=2`
    - `GET /hello?name=Alice`
    - `GET /miles_to_km?miles=10`
- `DS7_Consumer` (REST consumer)
  - Calls all above endpoints and prints JSON responses

## How to run in NetBeans 8

1. Open NetBeans 8
2. **File → Open Project...**
3. Open `DS7_Producer` and `DS7_Consumer`
4. Right-click `DS7_Producer` → **Run**
   - Keep it running (it waits for ENTER to stop)
5. Right-click `DS7_Consumer` → **Run**

## How to run from terminal (optional)

From inside each project folder:

```bash
mvn -q clean package
mvn -q exec:java
```

If `mvn` is not installed, just run from NetBeans.

